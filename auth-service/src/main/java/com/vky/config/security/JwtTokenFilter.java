package com.vky.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenManager jwtTokenManager;
    @Autowired
    JwtUserDetails jwtUserDetails;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        /**
         * Gelen istegin header kisminin icinde Authorization anahtari var mi var ise icinde ne var bu bilgiyi aliyorum
         * bu bilgi icinde Bearer ile baslayan bir token bilgisi olabilidir.
         */
        final String authorizationHeader = request.getHeader("Authorization");
//        final String getBodyToken =  request.getParameter("Token");
        /**
         * Gelen string ve request icindeki oturum bilgisini kontrol ederek isleme devam ediyorum.
         */
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ") &&
                SecurityContextHolder.getContext().getAuthentication() == null){
            String token = authorizationHeader.substring(7);
            Optional<Long> authId = jwtTokenManager.getUserId(token);
            if(authId.isPresent()){
                /**
                 * Spring icin gerekli olan oturum kullanicisinin tanimlanmasi gereklidir.
                 * bunu spring UserDetails sinifindan turetilmis ozellestirilmis bir kullanicinin
                 * olusturularak eklenmesi gereklidir.
                 */
                UserDetails userDetails = jwtUserDetails.loadUserByUserId(authId.get());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}

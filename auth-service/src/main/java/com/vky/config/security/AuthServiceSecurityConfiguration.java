package com.vky.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthServiceSecurityConfiguration{

    @Bean
    JwtTokenFilter getJwtTokenFilter()
    {
        return new JwtTokenFilter();
    }
    /**
     * Sunucunuza gelen tum isteklerin configurasyonunu burada yapiyorsunuz
     * @param
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        /**
         * Olmasini istedigniz tum ayarlamalari burada yapip
         */
        /**
         * 1- tum isteklerde csrf kapali olsun.
         *
         */
        httpSecurity.csrf().disable(); // sayfanin benim sunucum tarafindan gonderilip gonderilmedigini
                                        // kontrol eder RestApilerde csrf yoktur o yuzden disavle ediyoruz

        httpSecurity.authorizeRequests()
                .antMatchers("/v3/api-docs/**","/swagger-ui/**","/v1/api/auth/dologin","/v1/api/auth/register").permitAll() // permitAll -> kimlik dogrulamasina tabi tutma
                /**
                 * 1- anyRequest -> gelen tum istekler
                 * 2- authenticated -> kimlik dogrulamasi yapilsin
                 */
                .anyRequest().authenticated();
//                .and()
                /**
                 * 1- Eger kimlik dogrulamasi gerekiyor ise bunu spring in login formu uzerinden yap.
                 */
//                .formLogin();
        /**
         * JWT ile gelen isteklerin dogrulamasini yapilanmasini talep ettigimiz kisim
         * burada gelen istegin cevabi verilmeden once filter araya sokularak
         * dogrulama mekanizmasi buraya islenmelidir
         */
        httpSecurity.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        /**
         * Gelen istegi yeni kurguladigimiz sekli ile spring e iletiyoruz.
         */
         return httpSecurity.build();
    }


}

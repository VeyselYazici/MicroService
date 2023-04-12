package com.vky.manager;

import com.vky.dto.request.NewUserCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Baska bir microservisteki end pointleri cagirmak icin kullanilir.
 * Ulasmak istediginiz controller in url bilgisini vermelisiniz.
 * Tum feign islemlerine benzersiz adlandirmalar yapilmalidir.
 */
@FeignClient(url = "${raceapplication.url.user}v1/api/user", name = "user-service-userprofile", decode404 = true )
public interface IUserManager {
    @PostMapping("/newcreateuser")
    ResponseEntity<Void> newUserCreate(NewUserCreateDto userCreateDto);

}

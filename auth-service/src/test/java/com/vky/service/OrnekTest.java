package com.vky.service;

import com.vky.repository.IAuthRepository;
import com.vky.repository.entity.Auth;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
//@ActiveProfiles("test") - Aktif profile i degistirmek icin yani application-test.yml i kullanmak icin yazabilirsiniz.
//@ExtendWith(MockitoExtension.class)
public class OrnekTest {
    /**
     * @Autowired ile kullanimda gercek nesne kullanilir. (True verir, Veri tabanina kayit yapar)
     * @InjectMocks ile kullanimda mock nesne kullanilir. (True verir, Veri tabanina kaydetmmez)
     */
    @InjectMocks
    AuthService authService;
    @Mock
    IAuthRepository authRepository;

    @Test
    public void test1()
    {
        /**
         * authService -> mock haline getirilmis sanal bir nesnedir.
         * DIKKAT !!! mocki verify gibi kullanimlar icin
         * import static org.mockito.Mockito.*; eklenmelidir.
         */
        AuthService authService = mock(AuthService.class);

        Auth auth = Auth.builder()
            .id(1L).userName("veysel").build();

        Auth auth1 = Auth.builder()
                .id(2L).userName("ali").build();

        Auth auth2 = Auth.builder()
                .id(3L).userName("veli").build();


        authService.save(auth);
        authService.save(auth2);
        authService.save(auth1);

        /**
         * authServis in yapmis oldugu islemler mock nesnesi tarafindan islenmektedir.
         * Bu islemlerin dogrulugunu bunun uzerinden kontrol edebilirsiniz.
         */
//        verify(authService).save(auth);
//        verify(authService).save(auth1);
        /**
         * times -> bir method un belli bir degisken ile kac kez cagirildigini kontrol eder.
         * Eger method un kac kez cagirildigi kontrol edilecek ise,anyObject denenebilir.
         * never -> method hic cagirilmadigini kontrol eder.
         */
//        verify(authService,times(2)).save(auth1);
//        verify(authService, times(5)).save(any(Auth.class));
//        verify(authService,times(2)).save(auth2);
//        verify(authService,never()).update(any());
        /**
         * en az bir kere cagirildi mi?
         */
//        verify(authService,atLeast(1)).update(any());
        /**
         * inOrder -> Bu siraylami cagrildilar
         */
//        InOrder inOrder = inOrder(authService);
//        inOrder.verify(authService).save(auth);
//        inOrder.verify(authService).save(auth2);
//        inOrder.verify(authService).save(auth1);


    }

    @Test
    public void test2()
    {
        AuthService authService = mock(AuthService.class);
        /**
         * when -> anyLong -> findById methodunu herhangi bir Long degerle cagirdigimiz zaman bu auth nesnesini don diyoruz
         */
        when(authService.findById(anyLong())).thenReturn(Auth.builder()
                .password("123")
                .userName("veysel")
                .id(1L).build());
        when(authService.findById(3L)).thenReturn(Auth.builder()
                .password("123123")
                .userName("velii")
                .id(3L).build());
        Auth auth3 = authService.findById(3L);

        System.out.println(auth3.toString());
    }
    @Test
    public void saveTest2()
    {
        /**
         * Auth Service kayit islemi icin -> injection -> @InjtectionMocks nesne yaratilmasi gerekli.(AuthService)
         * Auth servisin icermesi gereken bagimliliklar @Mock edilir.(AuthRepository)
         */
        when(authRepository.save(any())).thenReturn(
                Auth.builder()
                        .id(1L)
                        .userName("veysel")
                        .password("123")
                        .build()
        );
        Auth auth = authService.save(Auth.builder().id(123L).userName("veli").build());
        System.out.println(auth.toString());
    }
}

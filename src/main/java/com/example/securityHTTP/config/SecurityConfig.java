package com.example.securityHTTP.config;

import com.example.securityHTTP.controller.CustomAccessDeniedHandler;
import com.example.securityHTTP.controller.CustomSuccessHandle;
import com.example.securityHTTP.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IAppUserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService((UserDetailsService) userService);
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public CustomSuccessHandle customSuccessHandle() {
        return new CustomSuccessHandle();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(formLogin -> formLogin.successHandler(customSuccessHandle())
                )
                .authorizeHttpRequests(author -> author
                                .requestMatchers("/register**", "/dangky").permitAll()
                .requestMatchers("/user**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers("/admin**").hasRole("ADMIN")
                )
                .exceptionHandling(customizer -> customizer.accessDeniedHandler(customAccessDeniedHandler()));
        return http.build();
    }
}

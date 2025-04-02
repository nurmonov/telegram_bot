package com.uz.telegrambot.security;


import com.uz.telegrambot.filters.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    private final MyFilter myFilter;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, MyFilter myFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.myFilter = myFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .requestMatchers("/login", "/file/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/product", "/api/categories").permitAll()
                                .requestMatchers(HttpMethod.GET, "/order/**","/orderItem").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.POST, "/order/**").hasAnyRole("ADMIN","USER")
                                .requestMatchers(HttpMethod.POST, "/product/**", "/product" , "/category","/category/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/product/**", "/product" , "/category","/category/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/product/**", "/product" , "/category","/category/**").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .userDetailsService(customUserDetailsService)
                .addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        var authProvider = new DaoAuthenticationProvider(passwordEncoder());
        authProvider.setUserDetailsService(customUserDetailsService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManage(CustomUserDetailsService customUserDetailsService) {
        return new ProviderManager(authenticationProvider(customUserDetailsService));
    }

}


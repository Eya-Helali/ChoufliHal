package com.example.ChoufliHal.Security.Config;

import com.example.ChoufliHal.User.LoginAndRegistration.JWT.JwtRequestFilter;
import com.example.ChoufliHal.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
        private final UserService userService;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;
       // private final JwtRequestFilter jwtRequestFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/authenticate","/register","/verify").permitAll()

                    .anyRequest()
                    .authenticated();
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean () throws Exception {
            return super.authenticationManagerBean();
        }
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(daoAuthenticationProvider());
        }


        public DaoAuthenticationProvider daoAuthenticationProvider()
        {   DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setPasswordEncoder(bCryptPasswordEncoder);
            provider.setUserDetailsService(userService);
            return provider;}



    }


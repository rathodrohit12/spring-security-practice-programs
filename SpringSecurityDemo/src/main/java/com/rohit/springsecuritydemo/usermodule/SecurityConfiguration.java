//package com.rohit.springsecuritydemo.usermodule;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfiguration {
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User.withUsername("tara").password("password123").roles("USER").build();
////        UserDetails userDetails2 = User.withUsername("tara2").password("password12343").roles("ADMIN").build();
//        manager.createUser(userDetails);
//        return manager;
//    }
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance();
////    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
//    {
//        return httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/user/register")
//                .permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/user/**")
//                .authenticated()
//                .and()
//                //.formLogin()
//                .httpBasic()
//                .and()
//                .build();
//    }
//
//
//
//
//
//
//
//
//
//
//}
//
//
//
//
//
//

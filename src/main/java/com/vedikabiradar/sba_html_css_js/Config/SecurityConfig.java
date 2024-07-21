//package com.vedikabiradar.sba_html_css_js.Config;//package com.vedikabiradar.sba_html_css_js.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
////                                .requestMatchers("/index","/static/css/**","/static/images/**","/static/JS/**").permitAll()
//                                .requestMatchers("/static/css/**","/static/images/**","/static/JS/**").permitAll()
//                                .requestMatchers("/index").permitAll()
//                                .requestMatchers("/contact").permitAll()
//                                .requestMatchers("/about").permitAll()
//                                .requestMatchers("/loginparentadmin").permitAll()
//                                .requestMatchers("/contact/list").permitAll()
//                                .requestMatchers("/calculate").permitAll()
//                                .requestMatchers("/emailSubscription").permitAll()
//                                .requestMatchers("/emailSubscription/list").permitAll()
//                                .requestMatchers("/employeeRegistration","/employeeList").permitAll()
//                                .requestMatchers("register","/parent","/child/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//
//                                .defaultSuccessUrl("/index", true)
//
//
//                );
//        return http.build();
//    }
//}

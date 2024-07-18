//package org.example.test._core.config;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@RequiredArgsConstructor
//@Configuration
//public class FilterConfig {
//
//    @Value("${allow.host}")
//    private String host;
//
//    @Bean
//    public FilterRegistrationBean<org.example.test.filter.SpecialCharacterFilter> corsFilter(){
//        System.out.println("CORS 필터 등록");
//        FilterRegistrationBean<org.example.test.filter.SpecialCharacterFilter> bean = new FilterRegistrationBean<>(new org.example.test.filter.SpecialCharacterFilter(host));
//        bean.addUrlPatterns("/*");
//        bean.setOrder(0); // 낮은 번호부터 실행됨.
//        return bean;
//    }
//}
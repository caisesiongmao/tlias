//package com.tlias.config;
//
//import com.tlias.filter.LoginFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//
//@Configuration
//public class FilterConfig {
//
//    // 注册 LogFilter
//    @Bean
//    public FilterRegistrationBean<Filter> logFilterRegistration() {
//        // 1. 创建 Filter 注册器
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//
//        // 2. 设置自定义 Filter 实例
//        registrationBean.setFilter(new LoginFilter());
//
//        // 3. 配置拦截路径（支持 Ant 风格，如 /* 拦截所有请求）
//        registrationBean.addUrlPatterns("/*");
//        // 排除某些路径（可选）
//        registrationBean.addInitParameter("exclusions", "/login");
//
//        // 4. 设置过滤器名称（可选）
//        registrationBean.setName("LoginFilter");
//
//        // 5. 设置优先级（值越小，优先级越高，先执行）
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }
//
//    // 如需注册多个 Filter，可再定义一个 Bean
//    // @Bean
//    // public FilterRegistrationBean<Filter> anotherFilterRegistration() { ... }
//}
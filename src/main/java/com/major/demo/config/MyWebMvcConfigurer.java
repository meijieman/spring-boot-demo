package com.major.demo.config;

import com.major.demo.controller.interceptor.OneInterceptor;
import com.major.demo.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new TwoInterceptor())
                .addPathPatterns("/two/**")
                .addPathPatterns("/one/**"); // 拦截 one 路径下的所有请求
        registry.addInterceptor(new OneInterceptor())
                .addPathPatterns("/one/**");
//      .addPathPatterns("/*/**") // 拦截所有请求

        super.addInterceptors(registry);
    }

}

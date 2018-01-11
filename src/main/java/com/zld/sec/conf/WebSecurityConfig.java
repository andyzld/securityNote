package com.zld.sec.conf;

/**
 * Created by Administrator on 2018/1/11.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
<1> @EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持。
另外，WebSecurityConfig配置类同时集成了WebSecurityConfigurerAdapter，
重写了其中的特定方法，用于自定义Spring Security配置。
整个Spring Security的工作量，其实都是集中在该配置类，不仅仅是这个guides，
实际项目中也是如此。

<2> configure(HttpSecurity)定义了哪些URL路径应该被拦截，
如字面意思所描述：”/“, “/home”允许所有人访问，”/login”作为登录入口，
也被允许访问，而剩下的”/hello”则需要登陆后才可以访问。

<3> configureGlobal(AuthenticationManagerBuilder)在内存中配置一个用户，
admin/admin分别是用户名和密码，
这个用户拥有USER角色。
* */

@Configuration
@EnableWebSecurity//1
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {//2
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //3
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }
}

package ir.maktab25.quizmaker.base.seurity.config;

import ir.maktab25.quizmaker.base.seurity.serivce.impl.UserDetailServiceImpl;
import ir.maktab25.quizmaker.base.seurity.successurlhandler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    private final String loginPageUrl = "/form/login.html";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        swaggerPermit(http);
        formPermit(http);
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(loginPageUrl)
                .permitAll()
                .and()
                .formLogin()
                .successHandler(customSuccessHandler);
    }

    private void swaggerPermit(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/**"
                        , "/v2/**")
                .permitAll();
    }

    private void formPermit(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers(
                        "/form/**")
                .permitAll();
    }
}

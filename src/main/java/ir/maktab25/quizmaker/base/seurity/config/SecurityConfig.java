package ir.maktab25.quizmaker.base.seurity.config;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
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
        formPermit(http);

        swaggerPermit(http);
        adminPermit(http);

        http
                .authorizeRequests()
                .anyRequest().authenticated();

        http.csrf().disable()
                .formLogin()
                .loginPage(loginPageUrl)
                .permitAll()
                .usernameParameter("username").passwordParameter("password")
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
                        , "/v2/**").hasAuthority(RoleName.SUPER.toString()).anyRequest().authenticated();
//                .hasAuthority(RoleName.SUPER.toString());

    }

    private void formPermit(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/form/**")
                .permitAll();
    }

    private void adminPermit(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/redirect/admin.html")
                .hasAnyAuthority(RoleName.SUPER.toString(), RoleName.ADMIN.toString())
                .anyRequest().authenticated();
    }

}

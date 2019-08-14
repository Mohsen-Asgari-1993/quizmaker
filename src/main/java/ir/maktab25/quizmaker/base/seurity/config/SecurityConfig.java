package ir.maktab25.quizmaker.base.seurity.config;

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

    private final String loginPageUrl = "/login.html";

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
        permit(http);
        swaggerPermit(http);
        adminPermit(http);
        teacherPermit(http);

        http
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage(loginPageUrl)
                .permitAll()
                .usernameParameter("username").passwordParameter("password")
                .and()
                .formLogin()
                .successHandler(customSuccessHandler);

    }

    private void swaggerPermit(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/**"
                        , "/v2/**")
//                .permitAll();
                .hasAuthority(RoleName.SUPER.toString());

    }

    private void permit(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/templates/**")
                .permitAll()
                .antMatchers("/webapp/**","/static/**","/dist/**","/jquery/**","/plugins/**", "/jalali/**")
                .permitAll()
                .antMatchers("/register")
                .permitAll();
    }

    private void superUser(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/Course/**").hasAnyAuthority(RoleName.SUPER.toString());
    }

    private void adminPermit(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyAuthority(RoleName.SUPER.toString(), RoleName.ADMIN.toString());
    }

    private void teacherPermit(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/teacher/**")
                .hasAnyAuthority(RoleName.SUPER.toString(), RoleName.TEACHER.toString());
    }

}

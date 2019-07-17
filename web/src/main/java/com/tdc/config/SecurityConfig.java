package com.tdc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public Queue match() {
        return new Queue("match");
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("USER","ADMIN").and()
                .withUser("hm").password("{noop}hm").roles("USER").and()
                .withUser("tb").password("{noop}tb").roles("USER");
        //todo: change to jdbcAuthentication after finish register
//        auth.jdbcAuthentication()
//                .usersByUsernameQuery("select username, password, 1 from user where username=?")
//                .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_authority ur on(u.id=ur.user_id) inner join authority r on(ur.authority_id=r.id) where u.username=?")
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**", "/static/**", "/css/**", "/js/**", "/photo/**", "/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/logout", "/register", "/api/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin() //enable form login instead of basic login
//                .loginPage("/login")
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/")
                .and()
                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
        ;
    }

}

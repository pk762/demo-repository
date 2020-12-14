package whz.pti.eva.pizzaService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import whz.pti.eva.pizzaService.security.service.currentCustomer.CurrentUserDetailsService;

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CurrentUserDetailsService currentUserDetailsService;

    @Autowired
    public void setCurrentUserDetailsService(CurrentUserDetailsService currentUserDetailsService) {
        this.currentUserDetailsService = currentUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // add public available endpoints
                .authorizeRequests()
                .antMatchers("/signin", "/css/**", "/menu").permitAll()
                .anyRequest().authenticated()

                // add and configure login form
                .and()
                .formLogin()
                .loginPage("/signin")
                .defaultSuccessUrl("/menu", true)
                .failureUrl("/signin?error")
                .usernameParameter("loginName")

                // add logout page
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/logout.done")

                // should remember user
                .and()
                .rememberMe()
                .key("unique")
                .userDetailsService(currentUserDetailsService)
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
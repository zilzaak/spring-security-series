package EmployeTest.secrty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for simplicity (enable in production)
                .authorizeRequests()
                // Super Admin has access to everything
                .antMatchers("/applicant/**",
                        "/player/**" ,
                        "/worker/**").hasAuthority("SUPER_ADMIN")

                // Applicant Admin only has access to applicant-related endpoints
                .antMatchers("/applicant/**").hasAuthority("APPLICANT_ADMIN")

                // Player Admin only has access to player-related endpoints
                .antMatchers("/player/**").hasAuthority("PLAYER_ADMIN")
                // Worker  Admin only has access to player-related endpoints
                .antMatchers("/worker/**").hasAuthority("WORKER_ADMIN")
                // Super Admin has access to everything
                .antMatchers("/applicant/**", "/player/**", "/worker/**").hasAuthority("SUPER_ADMIN")
                // All other requests must be authenticated
                .anyRequest().authenticated()
                .and()
                .httpBasic();
//                .formLogin()
//                .loginPage("/login") // Custom login page
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }
}




package hh.sof03.harjoitustyo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(antMatcher("/bootstrap.min.css/**")).permitAll()
                        .requestMatchers(antMatcher("/")).permitAll()
                        .requestMatchers(antMatcher("/index")).permitAll()
                        .requestMatchers(antMatcher("/meikkilist")).permitAll()
                        .requestMatchers(antMatcher("/kategorialist")).permitAll()
                        .requestMatchers(antMatcher("/kynsilakkalist")).permitAll()
                        .requestMatchers(antMatcher("/admin/**")).hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/index", true)
                        .permitAll())
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/"));

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder aut) throws Exception {
        aut.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}

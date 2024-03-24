package com.pfa.ecommerce.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.ecommerce.entities.ERole;
import com.pfa.ecommerce.security.jwt.AuthEntryPointJwt;
import com.pfa.ecommerce.security.jwt.AuthTokenFilter;
import com.pfa.ecommerce.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//importation  pour auth2.0

//fin de l'importation
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    private final String gerantRole = ERole.ROLE_GERANT.name();
    private final String userRole = ERole.ROLE_USER.name();
    private final String adminRole = ERole.ROLE_ADMIN.name();

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //autorization de créer client à revoir
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*.configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("http://localhost:4200"));
            configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS"));
            configuration.setAllowCredentials(true);
            configuration.addExposedHeader("Message");
            configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
            return configuration;
        })*/
        http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/**/swagger-*/**").permitAll()
                .antMatchers("/**/api-docs/**").permitAll()
                .antMatchers("/agence/**").permitAll()
                .antMatchers("/employe/**")
                .hasAnyAuthority(gerantRole, adminRole)
                .antMatchers("/client/**")
                .permitAll().antMatchers("/compte/**")
                .hasAnyAuthority(userRole, adminRole)
                .antMatchers("/auth/**").permitAll()
                .antMatchers( "/article/**").permitAll()
                .antMatchers( "/avis/**").permitAll()
                .antMatchers("/social/**")
                .permitAll().anyRequest().authenticated();
       http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);


        /* http.cors().configurationSource(request -> {
            CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.applyPermitDefaultValues();
            corsConfig.setAllowCredentials(true);
            corsConfig.addAllowedOrigin("http://localhost:4200");// Allow credentials
            corsConfig.addAllowedMethod(HttpMethod.PUT); // Add allowed methods if needed
            corsConfig.addAllowedMethod(HttpMethod.DELETE);
            corsConfig.addAllowedMethod(HttpMethod.GET);
            corsConfig.addAllowedMethod(HttpMethod.POST);
            return corsConfig;
        });*/
    }


    //@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(new ObjectMapper());
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.addAll(converter.getSupportedMediaTypes());
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(converter);
    }
}

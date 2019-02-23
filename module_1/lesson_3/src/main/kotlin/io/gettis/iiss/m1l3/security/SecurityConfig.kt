package io.gettis.iiss.m1l3.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        //@formatter:off

        http
        //region Authentication
            .formLogin().and()
//            .httpBasic().and()
//            .anonymous().and()
//            .oauth2Client().and()
//            .oauth2Login().and()
//            .oauth2ResourceServer().and()
//            .openidLogin().and()
//            .rememberMe().alwaysRemember(true).and()
//            .x509().and()
        //endregion

        //region Authorization
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/coffeeShops**").hasRole("USER")
//                .mvcMatchers("/admin").access("hasRole('ADMIN')")
//                .regexMatchers("/public$").anonymous()
//                .requestMatchers(RequestMatcher { it.method == "POST" }).denyAll()
//                .anyRequest().authenticated()
//                .filterSecurityInterceptorOncePerRequest(true)
//                .accessDecisionManager(null)
//                .expressionHandler(null)
                .and()
        //endregion

        //region Configuring
//            .addFilterBefore({ request, response, chain ->  }, UsernamePasswordAuthenticationFilter::class.java)
//            .cors().and()
//            .csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .exceptionHandling().and()
//            .headers().and()
//            .portMapper().and()
//            .securityContext().and()
//            .servletApi().rolePrefix("R_").and()
        //endregion

        //@formatter:on
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER")
    }

    override fun configure(web: WebSecurity) {
        web.debug(true).ignoring().antMatchers("/error")
    }
}
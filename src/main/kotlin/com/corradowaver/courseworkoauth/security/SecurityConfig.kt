package com.corradowaver.courseworkoauth.security

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
  override fun configure(http: HttpSecurity) {
    http.authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .oauth2Login()
      .defaultSuccessUrl("/user")
  }
}

package com.corradowaver.courseworkoauth.utils

import com.corradowaver.courseworkoauth.service.auth.AuthenticationProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpClientConfig {
  @Bean
  fun getHttpClient() = HttpClient(Java) {
    engine {
      threadsCount = 4
      pipelining = true
    }
  }
}

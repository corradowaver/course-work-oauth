package com.corradowaver.courseworkoauth.service.github

import com.corradowaver.courseworkoauth.dto.GithubUser
import com.corradowaver.courseworkoauth.service.auth.AuthenticationProvider
import com.corradowaver.courseworkoauth.utils.JsonUtils.jsonTo
import io.ktor.client.HttpClient
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod.Companion.Get
import org.springframework.stereotype.Service

@Service
class GithubService(
  val httpClient: HttpClient,
  val authProvider: AuthenticationProvider
) {

  suspend fun getUserInfo() =
    httpClient.request("https://api.github.com/user") {
      method = Get
      bearerAuth(authProvider.getAccessToken())
    }
      .bodyAsText()
      .jsonTo(GithubUser::class.java)
      .toString()

}

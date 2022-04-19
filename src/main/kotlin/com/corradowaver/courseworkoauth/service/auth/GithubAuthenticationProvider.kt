package com.corradowaver.courseworkoauth.service.auth

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Service

@Service
class GithubAuthenticationProvider(
  private val clientService: OAuth2AuthorizedClientService
) : AuthenticationProvider {

  override fun getAccessToken(): String {
    val authentication = SecurityContextHolder.getContext().authentication
    val oauthToken = authentication as OAuth2AuthenticationToken
    val client: OAuth2AuthorizedClient = clientService.loadAuthorizedClient(
      oauthToken.authorizedClientRegistrationId,
      oauthToken.name
    )
    val accessToken = client.accessToken.tokenValue
    return accessToken
  }

}

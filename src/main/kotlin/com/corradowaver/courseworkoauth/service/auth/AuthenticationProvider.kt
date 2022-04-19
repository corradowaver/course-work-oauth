package com.corradowaver.courseworkoauth.service.auth

interface AuthenticationProvider {

  fun getAccessToken(): String

}

package com.corradowaver.courseworkoauth.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GithubUser(
  val login: String,
  val name: String,
  val location: String,
  val bio: String
)

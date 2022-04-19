package com.corradowaver.courseworkoauth.controller

import com.corradowaver.courseworkoauth.service.github.GithubService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GithubController(
  val githubService: GithubService
) {

  @GetMapping("/user")
  suspend fun getUserInfo(): String =
    githubService.getUserInfo()

}

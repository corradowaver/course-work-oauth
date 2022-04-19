package com.corradowaver.courseworkoauth.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JsonUtils {

  val mapper = ObjectMapper()
    .registerModule(
      KotlinModule.Builder().build()
    )

  fun String.jsonTo(clazz: Class<*>) =
    mapper.readValue(this, clazz)

}

package com.launchcodeconsulting.kotlingraphql.graphql.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.launchcodeconsulting.kotlingraphql.graphql.model.User
import com.launchcodeconsulting.kotlingraphql.service.UserService
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.stereotype.Component


@Component
class UserMutation(private val userService: UserService) : Mutation, Logging {
    fun updateUser(id: ID, name: String): User = userService.updateUser(id, name)
    fun createUser(name: String): User = userService.createUser(name)
    fun deleteUser(id: ID): Boolean {
        return try {
            userService.deleteUser(id)
            true
        } catch (e: Exception) {
            logger.error("Error deleting user", e)
            false
        }
    }
}

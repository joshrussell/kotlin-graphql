package com.launchcodeconsulting.kotlingraphql.graphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.launchcodeconsulting.kotlingraphql.graphql.model.User
import com.launchcodeconsulting.kotlingraphql.service.UserService
import org.springframework.stereotype.Component


@Component
class UserQuery(@GraphQLIgnore val userService: UserService) : Query {
    fun user(id: ID): User = userService.getUser(id)
}

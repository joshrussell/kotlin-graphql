package com.launchcodeconsulting.kotlingraphql.graphql.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.Schema
import org.springframework.stereotype.Component

@GraphQLDescription("User schema")
@Component
class UserSchema : Schema

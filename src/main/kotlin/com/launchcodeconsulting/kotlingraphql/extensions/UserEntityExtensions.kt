package com.launchcodeconsulting.kotlingraphql.extensions

import com.expediagroup.graphql.generator.scalars.ID
import com.launchcodeconsulting.kotlingraphql.domain.UserEntity
import com.launchcodeconsulting.kotlingraphql.graphql.model.User


fun UserEntity.toGraphQLModel() = User(id = ID(this.id.toString()), name = this.name)

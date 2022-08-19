package com.launchcodeconsulting.kotlingraphql.service

import com.expediagroup.graphql.generator.scalars.ID
import com.launchcodeconsulting.kotlingraphql.domain.UserEntity
import com.launchcodeconsulting.kotlingraphql.extensions.toGraphQLModel
import com.launchcodeconsulting.kotlingraphql.graphql.model.User
import com.launchcodeconsulting.kotlingraphql.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun getUser(id: ID): User {
        val userEntity = userRepository.findById(id.value.toLong()).orElseThrow{ NoSuchElementException("No UserEntity with id ${id.value}") }
        return userEntity.toGraphQLModel()
    }

    fun updateUser(id: ID, name: String): User {
        val userEntity = userRepository.findById(id.value.toLong()).orElseThrow{ NoSuchElementException("No UserEntity with id ${id.value}") }
        userEntity.name = name
        return userRepository.save(userEntity).toGraphQLModel()
    }

    fun createUser(name: String): User = userRepository.save(UserEntity(name)).toGraphQLModel()

    fun deleteUser(id: ID) = userRepository.deleteById(id.value.toLong())

}

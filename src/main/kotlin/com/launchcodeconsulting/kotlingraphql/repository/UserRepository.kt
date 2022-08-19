package com.launchcodeconsulting.kotlingraphql.repository

import com.launchcodeconsulting.kotlingraphql.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long>

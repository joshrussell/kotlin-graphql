package com.launchcodeconsulting.kotlingraphql.domain

import javax.persistence.*

@Entity
@Table(name = "user_entity")
data class UserEntity(
    var name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
)

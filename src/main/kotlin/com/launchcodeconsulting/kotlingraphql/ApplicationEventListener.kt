package com.launchcodeconsulting.kotlingraphql

import com.launchcodeconsulting.kotlingraphql.domain.UserEntity
import com.launchcodeconsulting.kotlingraphql.repository.UserRepository
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.context.event.SpringApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationEventListener(private val userRepository: UserRepository) : ApplicationListener<SpringApplicationEvent>, Logging {

    override fun onApplicationEvent(event: SpringApplicationEvent) {
        logger.debug("APPLICATION EVENT")
        if (event is ApplicationStartedEvent) {
            logger.debug("ApplicationStartedEvent")
            userRepository.save(UserEntity(name = "Test User"))
        }
    }
}

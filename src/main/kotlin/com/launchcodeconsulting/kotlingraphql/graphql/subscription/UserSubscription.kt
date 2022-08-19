package com.launchcodeconsulting.kotlingraphql.graphql.subscription

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Subscription
import com.launchcodeconsulting.kotlingraphql.graphql.model.User
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component


@Component
class UserSubscription : Subscription {
    fun userChanges(id: ID): Publisher<User> = Publisher { }
}

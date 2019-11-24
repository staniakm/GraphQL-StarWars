package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver
import com.sw.universe.film.Rating
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.transaction.Transactional
import kotlin.math.floor

@Component
class Subscription : GraphQLSubscriptionResolver {

    fun filmRatings(title: String): Publisher<Rating> {
        val observable = Observable.create<Rating> { emitter ->
            val executorService = Executors.newScheduledThreadPool(1)
            executorService.scheduleAtFixedRate({
                val rating = Rating(title, Integer.valueOf(floor(Math.random() * 10).toInt()))
                emitter.onNext(rating)
            }, 0, 2, TimeUnit.SECONDS)
        }

        val connectableObservable = observable.share().publish()
        connectableObservable.connect()
        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER)
    }
}

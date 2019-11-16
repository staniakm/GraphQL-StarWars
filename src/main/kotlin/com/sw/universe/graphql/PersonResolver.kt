package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import com.sw.universe.film.Film
import com.sw.universe.film.FilmService
import com.sw.universe.person.Person
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class PersonReslover(private val filmService: FilmService) : GraphQLResolver<Person> {

    fun personFilms(person: Person): MutableSet<Film>? {
        return filmService.findAllByPerson(person)
    }
}
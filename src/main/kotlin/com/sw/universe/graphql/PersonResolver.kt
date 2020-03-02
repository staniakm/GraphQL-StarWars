package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import com.sw.universe.film.Film
import com.sw.universe.film.FilmService
import com.sw.universe.person.Person
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class PersonResolver(private val filmService: FilmService) : GraphQLResolver<Person> {

    //dynamic fields available in schema
    fun personFilms(person: Person, limit: Int): Set<Film> =
            filmService.findAllByPerson(person, PageRequest.of(0, limit))

    fun surname(person: Person) : String? {
        return null;
    }

    fun nameAndGender(person: Person):String{
        return "${person.name} ${person.gender.name.toLowerCase()}"
    }
}

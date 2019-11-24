package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import com.sw.universe.film.Film
import com.sw.universe.person.Person
import com.sw.universe.person.PersonService
import org.springframework.stereotype.Component

@Component
class FilmResolver(private val personService: PersonService) : GraphQLResolver<Film> {

    fun filmCharacters(film: Film): Set<Person> = personService.getCharactersByFilm(film)

}

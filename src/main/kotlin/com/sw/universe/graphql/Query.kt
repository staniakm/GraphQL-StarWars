package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.sw.universe.film.FilmService
import com.sw.universe.person.PersonService
import org.springframework.stereotype.Component


@Component
class Query(val personService: PersonService, val filmService: FilmService) : GraphQLQueryResolver {
    
    fun allPersons() = personService.getAllPersons()
    fun personByName(name: String) = personService.personByName(name)

    fun allFilms() = filmService.getAllFilms()
    fun filmsWithCharacter(characterName: String) = filmService.filmsWithCharacter(characterName)
}
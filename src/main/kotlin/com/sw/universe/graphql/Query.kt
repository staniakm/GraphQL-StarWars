package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.sw.universe.film.FilmService
import com.sw.universe.person.PersonService
import com.sw.universe.species.SpeciesService
import org.springframework.stereotype.Component


@Component
class Query(val personService: PersonService, val filmService: FilmService, val speciesService: SpeciesService) : GraphQLQueryResolver {

    fun allPersons() = personService.getAllPersons()
    fun personByName(name: String) = personService.personByName(name)

    fun allFilms() = filmService.getAllFilms()
    fun filmsWithCharacter(characterName: String) = filmService.filmsWithCharacter(characterName)

    fun allSpecies() = speciesService.getAllSpecies()
    fun speciesByName(name: String) = speciesService.speciesByName(name)
}

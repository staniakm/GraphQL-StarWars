package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.sw.universe.exception.CustomException
import com.sw.universe.film.FilmService
import com.sw.universe.person.Person
import com.sw.universe.person.PersonService
import com.sw.universe.species.Species
import com.sw.universe.species.SpeciesService
import org.apache.commons.lang3.StringUtils.isBlank
import org.apache.commons.lang3.StringUtils.isNotBlank
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.util.*


@Component
class Query(val personService: PersonService, val filmService: FilmService, val speciesService: SpeciesService) : GraphQLQueryResolver {

    fun allPersons(page: Int, size: Int): List<Person> {
        val pageable = PageRequest.of(page, size)
        return personService.getAllPersons(pageable)
    }

    fun personByName(name: String) = personService.personByName(name)

    fun allFilms() = filmService.getAllFilms()
    fun filmsWithCharacter(characterName: String) = filmService.filmsWithCharacter(characterName)

    fun allSpecies() = speciesService.getAllSpecies()
    fun speciesBy(id: Long, name: String): Optional<Species> {
        return if (id == 0L && isNotBlank(name)) {
            speciesService.speciesByName(name)
        } else if (id > 0 && isBlank(name)) {
            speciesService.speciesById(id)
        } else if (id > 0 && isNotBlank(name)) {
            speciesService.speciesBy(id, name)
        } else {
            throw CustomException(400, "ID or Name must not be empty")
        }
    }
}

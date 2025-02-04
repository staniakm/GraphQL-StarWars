package com.sw.universe.film

import com.sw.universe.person.Person
import com.sw.universe.person.PersonRepository
import org.springframework.stereotype.Service

@Service
class FilmService(val filmRepository: FilmRepository, val personRepository: PersonRepository) {

    fun getAllFilms(): List<Film> = filmRepository.findAll()
    
    fun filmsWithCharacter(characterName: String): MutableSet<Film> {
        return personRepository.findByName(characterName)
                .map { it.films }
                .orElseGet { mutableSetOf() }
    }

    fun findAllByPerson(person: Person): MutableSet<Film>? {
        return person.id!!.let { filmRepository.findAllByPersonId(it) }
    }
}

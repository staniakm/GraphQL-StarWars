package com.sw.universe.film

import com.sw.universe.person.Person
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class FilmService(private val filmRepository: FilmRepository) {

    fun getAllFilms(): List<Film> = filmRepository.findAll()

    fun filmsWithCharacter(characterName: String): Set<Film> = filmRepository.findByPersonName(characterName)

    fun findAllByPerson(person: Person, pageRequest: PageRequest): Set<Film> {
        return filmRepository.findAllByPersonId(person.id!!, pageRequest).content.toSet()
    }
}

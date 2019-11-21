package com.sw.universe.film

import com.sw.universe.person.Person
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class FilmService(val filmRepository: FilmRepository) {

    fun getAllFilms(): List<Film> = filmRepository.findAll()

    fun filmsWithCharacter(characterName: String): Set<Film> {
        return filmRepository.findByPersonName(characterName)
    }

    fun findAllByPerson(person: Person, pageRequest: PageRequest): Set<Film> {
        
        return person.id!!.let { filmRepository.findAllByPersonId(it, pageRequest) }.content.toSet()
    }
}

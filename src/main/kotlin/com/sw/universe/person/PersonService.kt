package com.sw.universe.person

import com.sw.universe.film.Film
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(val personRepository: PersonRepository) {

    fun getAllPersons(pageable: Pageable): List<Person> = personRepository.findAll(pageable).content

    fun personByName(name: String): Optional<Person> = personRepository.findByName(name)

    fun getCharactersByFilm(film: Film): Set<Person> = personRepository.findByFilmId(film.id!!)
}

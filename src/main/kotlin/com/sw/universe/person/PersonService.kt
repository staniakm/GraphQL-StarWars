package com.sw.universe.person

import com.sw.universe.film.Film
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(val personRepository: PersonRepository) {

    fun getAllPersons(): List<Person> = personRepository.findAll()

    fun personByName(name: String): Optional<Person> = personRepository.findByName(name)

    fun getCharactersByFilm(film: Film): Set<Person> {
        return film.id!!.let { personRepository.findByFilmId(it) }
    }
}

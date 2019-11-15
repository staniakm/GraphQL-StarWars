package com.sw.universe.person

import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(val personRepository: PersonRepository) {

    fun getAllPersons(): List<Person> = personRepository.findAll()

    fun personByName(name: String): Optional<Person> = personRepository.findByName(name)
}
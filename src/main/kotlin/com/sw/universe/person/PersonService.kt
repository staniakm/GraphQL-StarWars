package com.sw.universe.person

import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {

    fun getAllPersons(): List<Person> = personRepository.findAll()
}
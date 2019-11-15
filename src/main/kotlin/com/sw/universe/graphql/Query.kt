package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.sw.universe.person.PersonService
import org.springframework.stereotype.Component


@Component
class Query(val personService: PersonService) : GraphQLQueryResolver {

    fun allPersons() = personService.getAllPersons()
}
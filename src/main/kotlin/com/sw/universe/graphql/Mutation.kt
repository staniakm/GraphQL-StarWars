package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.sw.universe.person.Gender
import com.sw.universe.person.Person
import com.sw.universe.person.PersonService
import com.sw.universe.species.Species
import com.sw.universe.species.SpeciesService
import org.springframework.stereotype.Component

@Component
class Mutation(private val personService: PersonService, private val speciesService: SpeciesService) : GraphQLMutationResolver {

    fun addSpecies(name: String, language: String) = speciesService.save(Species(name, language))

    fun addPerson(name: String, gender: Gender, existingSpeciesName: String): Person {

        val speciesFromRepo = speciesService.speciesByName(existingSpeciesName)
        require(speciesFromRepo.isPresent) { "Species name $existingSpeciesName does not exist in database, save it first..." }

        val personFromRepo = personService.personByName(name)
        require(!personFromRepo.isPresent) { "Person with $name already exists in database" }

        return personService.save(Person(name, gender, speciesFromRepo.get()))
    }

}

package com.sw.universe.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.sw.universe.exception.CustomException
import com.sw.universe.person.Gender
import com.sw.universe.person.Person
import com.sw.universe.person.PersonService
import com.sw.universe.species.Species
import com.sw.universe.species.SpeciesService
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
@Transactional
class Mutation(private val personService: PersonService, private val speciesService: SpeciesService) : GraphQLMutationResolver {

    fun addSpecies(name: String, language: String) = speciesService.save(Species(name, language))

    fun addPerson(name: String, gender: Gender, existingSpeciesName: String): Person {

        val speciesFromRepo = speciesService.speciesByName(existingSpeciesName)
        if (!speciesFromRepo.isPresent) {
            throw CustomException(400, "Species name $existingSpeciesName does not exist in database, save it first...")
        }

        val personFromRepo = personService.personByName(name)
        if (personFromRepo.isPresent) {
            throw CustomException(400, "Person with $name already exists in database")
        }

        return personService.save(Person(name, gender, speciesFromRepo.get()))
    }

    fun addPersonWithInput(personInput: PersonInput): Person {
        if (personService.personByName(personInput.name).isPresent) {
            throw CustomException(400, "Person with ${personInput.name} already exists in database")
        }


        return personService.save(Person(personInput.name, personInput.gender,
                Species(personInput.speciesInput.name, personInput.speciesInput.language)))
    }

}

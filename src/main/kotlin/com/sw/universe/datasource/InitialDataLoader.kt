package com.sw.universe.datasource

import com.sw.universe.Species.SpeciesRepository
import com.sw.universe.film.Film
import com.sw.universe.film.FilmRepository
import com.sw.universe.person.Gender
import com.sw.universe.person.Person
import com.sw.universe.person.PersonRepository
import com.sw.universe.species.Species
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class InitialDataLoader(
        val personRepository: PersonRepository,
        val filmRepository: FilmRepository,
        val speciesRepository: SpeciesRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val humanSpecies = Species("Human", "Common")
        val droidSpecies = Species("Droid", "n/a")

        val human = speciesRepository.save(humanSpecies)
        val droid = speciesRepository.save(droidSpecies)


        val lukeSkywalker = personRepository.save(Person("Luke Skywalker", Gender.MALE, humanSpecies))
        val c3p0 = personRepository.save(Person("C-3PO", Gender.UNKNOWN, droid))
        val r2d2 = personRepository.save(Person("R2-D2", Gender.UNKNOWN, droid))
        val darthVader = personRepository.save(Person("Darth Vader", Gender.MALE, human))
        val leia = personRepository.save(Person("Leia Organa", Gender.FEMALE, human))

        val starWars1 = filmRepository.save(Film("Star Wars", LocalDate.of(2017, 1, 12), "Director"))
        val newHope = filmRepository.save(Film("A New Hope", LocalDate.of(1977, 5,25), "George Lucas"))
        newHope.addCharacters(lukeSkywalker, c3p0, r2d2, darthVader, leia)

        lukeSkywalker.addFilms(starWars1, newHope)
        personRepository.save(lukeSkywalker)
    }

}

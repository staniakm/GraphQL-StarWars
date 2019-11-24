package com.sw.universe.species

import org.springframework.stereotype.Service
import java.util.*

@Service
class SpeciesService(val speciesRepository: SpeciesRepository) {

    fun getAllSpecies(): List<Species> = speciesRepository.findAll()

    fun speciesByName(name: String): Optional<Species> = speciesRepository.findByName(name)
    fun speciesById(id: Long) = speciesRepository.findById(id)
    fun speciesBy(id: Long, name: String): Optional<Species> = speciesRepository.findByIdAndName(id, name)

}

package com.sw.universe.species

import com.sw.universe.Species.SpeciesRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SpeciesService(val speciesRepository: SpeciesRepository) {

    fun getAllSpecies(): List<Species> = speciesRepository.findAll()

    fun speciesByName(name: String): Optional<Species> = speciesRepository.findByName(name)
}

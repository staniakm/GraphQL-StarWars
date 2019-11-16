package com.sw.universe.Species

import com.sw.universe.species.Species
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpeciesRepository : JpaRepository<Species, Long> {

    fun findByName(name: String): Optional<Species>

}

package com.sw.universe.species

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpeciesRepository : JpaRepository<Species, Long> {

    fun findByName(name: String): Optional<Species>

    fun findByIdAndName(id: Long, name: String): Optional<Species>
}

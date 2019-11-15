package com.sw.universe.person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    fun findByName(name: String): Optional<Person>
    
}
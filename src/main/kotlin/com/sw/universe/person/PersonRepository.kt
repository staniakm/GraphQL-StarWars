package com.sw.universe.person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    fun findByName(name: String): Optional<Person>

    @Query("select p from Film f join f.characters p where f.id = :filmId")
    fun findByFilmId(filmId: Long): Set<Person>
}
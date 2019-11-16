package com.sw.universe.film

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FilmRepository : JpaRepository<Film, Long> {

    @Query("select f from Person p join p.films f where p.id = :personId")
    fun findAllByPersonId(personId: Long): MutableSet<Film>
}
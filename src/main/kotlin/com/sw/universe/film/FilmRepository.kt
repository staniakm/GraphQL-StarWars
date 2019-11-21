package com.sw.universe.film

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FilmRepository : JpaRepository<Film, Long> {

    @Query("select f from Person p join p.films f where p.id = :personId order by f.id")
    fun findAllByPersonId(personId: Long, pageable: Pageable): Page<Film>

    @Query("select f from Person p join p.films f where p.name = :personName")
    fun findByPersonName(personName: String): Set<Film>
}
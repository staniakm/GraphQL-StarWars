package com.sw.universe.film

import org.springframework.data.jpa.repository.JpaRepository

interface FilmRepository : JpaRepository<Film, Long> 
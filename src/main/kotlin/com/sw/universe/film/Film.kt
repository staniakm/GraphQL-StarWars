package com.sw.universe.film

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sw.universe.person.Person
import java.time.LocalDate
import javax.persistence.*

@Entity
class Film(
        val title: String,

        val releaseDate: LocalDate,

        val director: String,

        @JsonIgnore
        @ManyToMany(mappedBy = "films", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
        val characters: MutableSet<Person> = mutableSetOf(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)
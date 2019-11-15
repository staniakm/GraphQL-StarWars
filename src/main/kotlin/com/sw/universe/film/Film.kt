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
) {

    fun addCharacters(vararg character: Person) {
        character.forEach {
            characters.add(it)
            it.films.add(this)
        }
    }

    fun getCharacters(): List<Person> = characters.sortedWith(compareBy { it.name })
}
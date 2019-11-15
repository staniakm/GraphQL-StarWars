package com.sw.universe.person

import com.sw.universe.film.Film
import javax.persistence.*

@Entity
class Person(
        val name: String,

        @Enumerated(EnumType.STRING)
        val gender: Gender,

        @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
        val films: MutableSet<Film> = mutableSetOf(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
) {
    fun addFilms(vararg film: Film) {
        film.forEach {
            films.add(it)
            it.characters.add(this)
        }
    }

    fun getFilms(): List<Film> = films.sortedWith(compareBy { it.title })
}
package com.sw.universe.species

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Species(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        
        val id: Long? = null,
        val name: String, 
        val language: String)

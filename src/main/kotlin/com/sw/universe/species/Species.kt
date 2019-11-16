package com.sw.universe.species

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Species( @Id val name: String, val language: String)

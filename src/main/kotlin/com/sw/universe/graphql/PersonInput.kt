package com.sw.universe.graphql

import com.sw.universe.person.Gender
import com.sw.universe.species.Species

class PersonInput (val name: String, val gender: Gender, val speciesInput: SpeciesInput)

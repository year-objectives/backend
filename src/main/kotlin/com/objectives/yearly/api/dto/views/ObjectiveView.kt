package com.objectives.yearly.api.dto.views

import java.util.*

data class ObjectiveView(val id: UUID, val name: String, val type: String,
                         val reversible: Boolean, val targetAmount: Int)



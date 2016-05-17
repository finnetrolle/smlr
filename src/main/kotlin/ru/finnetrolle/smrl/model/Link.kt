package ru.finnetrolle.smrl.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * This class is developed by maxsyachin on 17.05.16
 * for smlr in version ru.finnetrolle.smrl.model
 * under MIT license
 */

@Entity
@Table(name = "links")
data class Link(
        var text: String = "",
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO) var id: Long = 0
)
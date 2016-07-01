package ru.finnetrolle.smrl.model

import javax.persistence.*

/**
 * This class is developed by maxsyachin on 17.05.16
 * for smlr in version ru.finnetrolle.smrl.model
 * under MIT license
 */

@Entity
@Table(name = "links")
data class Link(
        var text: String = "",
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "links_sequence")
        @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
        var id: Long = 0
)
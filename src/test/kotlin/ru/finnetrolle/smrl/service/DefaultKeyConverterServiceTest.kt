package ru.finnetrolle.smrl.service

import org.junit.Test
import java.util.*

/**
 * This class is developed by maxsyachin on 03.05.16
 * for smlr in version ru.finnetrolle.smrl.service
 * under MIT license
 */
class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random()
        for(i in 0..1000L) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)
            org.junit.Assert.assertEquals(initialId, id)
        }
    }

}
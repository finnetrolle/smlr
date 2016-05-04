package ru.finnetrolle.smrl.service

/**
 * This class is developed by maxsyachin on 03.05.16
 * for smlr in version ru.finnetrolle.smrl.service
 * under MIT license
 */
interface KeyConverterService {
    fun idToKey(id: Long): String
    fun keyToId(key: String): Long
}
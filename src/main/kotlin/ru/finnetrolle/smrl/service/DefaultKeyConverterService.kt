package ru.finnetrolle.smrl.service

import org.springframework.stereotype.Component

/**
 * This class is developed by maxsyachin on 03.05.16
 * for smlr in version ru.finnetrolle.smrl.service
 * under MIT license
 */

@Component
class DefaultKeyConverterService: KeyConverterService {

    val chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890-_".toCharArray()
    val charToLong = (0..chars.size-1)
            .map { i -> Pair(chars[i], i.toLong()) }
            .toMap()

    override fun idToKey(id: Long): String {
        var n = id
        val builder = StringBuilder()
        while(n != 0L) {
            builder.append(chars[(n % chars.size).toInt()])
            n /= chars.size
        }
        return builder.reverse().toString()
    }

    override fun keyToId(key: String) = key
            .map { c -> charToLong[c]!! }
            .fold(0L, {a,b -> a * chars.size + b})
}
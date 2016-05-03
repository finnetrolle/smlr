package ru.finnetrolle.smrl.service

/**
 * This class is developed by maxsyachin on 25.04.16
 * for smlr in version ru.fnnetrolle.smrl.service
 * under MIT license
 */
interface KeyMapperService {
    interface Add {
        data class Success(val key: String, val link: String): Add
        data class AlreadyExist(val key: String): Add
    }

    interface Get {
        data class Link(val link: String): Get
        data class NotFound(val key: String): Get
    }

    fun add(key: String, link: String): Add

    fun getLink(key: String): Get
}
package ru.finnetrolle.smrl.service

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

/**
 * This class is developed by maxsyachin on 25.04.16
 * for smlr in version ru.fnnetrolle.smrl.service
 * under MIT license
 */
@Component
class DefaultKeyMapperService: KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()

    override fun add(key: String, link: String): KeyMapperService.Add {
        if (map.contains(key)) {
            return KeyMapperService.Add.AlreadyExist(key)
        } else {
            map.put(key, link)
            return KeyMapperService.Add.Success(key, link)
        }
    }

    override fun getLink(key: String) = if (map.contains(key)) {
        KeyMapperService.Get.Link(map.get(key)!!)
    } else {
        KeyMapperService.Get.NotFound(key)
    }
}
package ru.finnetrolle.smrl.conrtollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import ru.finnetrolle.smrl.service.KeyMapperService

/**
 * This class is developed by maxsyachin on 29.07.16
 * for smlr
 * under MIT license
 */

@Controller
@RequestMapping("add")
class AddController {

    @Autowired lateinit var service: KeyMapperService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun add(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)

}
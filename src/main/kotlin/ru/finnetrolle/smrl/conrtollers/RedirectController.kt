package ru.finnetrolle.smrl.conrtollers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.finnetrolle.smrl.service.KeyMapperService
import javax.servlet.http.HttpServletResponse

/**
 * This class is developed by maxsyachin on 23.04.16
 * for smlr in version ru.fnnetrolle.smrl.conrtollers
 * under MIT license
 */

@Controller
@RequestMapping
class RedirectController {

    @Autowired
    lateinit var service: KeyMapperService

    @RequestMapping("/")
    fun home() = "home"

    @RequestMapping("/{key}")
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse) {
        val result = service.getLink(key)
        when (result) {
            is KeyMapperService.Get.Link -> {
                response.setHeader(HEADER_NAME, result.link);
                response.status = 302
            }
            is KeyMapperService.Get.NotFound -> {
                response.status = 404
            }
        }
    }

    companion object {
        private val HEADER_NAME = "Location"
    }

}
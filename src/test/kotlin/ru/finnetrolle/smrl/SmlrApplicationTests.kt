package ru.finnetrolle.smrl

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@TestPropertySource(locations = arrayOf("classpath:repositories-test.properties"))
@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SmlrApplication::class))
@WebAppConfiguration
class SmlrApplicationTests {

	@Test
	fun contextLoads() {
	}

}

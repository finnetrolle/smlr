package ru.finnetrolle.smrl.model

import com.github.springtestdbunit.DbUnitTestExecutionListener
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import ru.finnetrolle.smrl.SmlrApplication

/**
 * This class is developed by maxsyachin on 17.05.16
 * for smlr in version ru.finnetrolle.smrl.model
 * under MIT license
 */

@TestPropertySource(locations = arrayOf("classpath:repositories-test.properties"))
@TestExecutionListeners(DbUnitTestExecutionListener::class)
@SpringApplicationConfiguration(classes = arrayOf(SmlrApplication::class))
@DirtiesContext
abstract class AbstractRepositoryTest : AbstractTransactionalJUnit4SpringContextTests() {
}
package ru.finnetrolle.smrl.service

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.argThat
import com.nhaarman.mockito_kotlin.capture
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ru.finnetrolle.smrl.model.Link
import ru.finnetrolle.smrl.model.repositories.LinkRepository
import java.util.*

/**
 * This class is developed by maxsyachin on 25.04.16
 * for smlr in version ru.fnnetrolle.smrl.service
 * under MIT license
 */
class DefaultKeyMapperServiceTest {

    @InjectMocks
    var service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "aAbBcCdD"
    private val LINK_A: String = "http://www.google.com"
    private val LINK_B: String = "http://www.yahoo.com"

    @Mock
    lateinit var converter: KeyConverterService

    @Mock
    lateinit var repo: LinkRepository

    private val KEY_A: String = "abc"

    private val KEY_B: String = "cde"

    private val ID_A: Long = 10000000L

    private val ID_B: Long = 10000001L

    private val LINK_OBJ_A: Link = Link(LINK_A, ID_A)
    private val LINK_OBJ_B: Link = Link(LINK_B, ID_B)


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        Mockito.`when`(converter.keyToId(KEY_A)).thenReturn(ID_A)
        Mockito.`when`(converter.idToKey(ID_A)).thenReturn(KEY_A)
        Mockito.`when`(converter.keyToId(KEY_B)).thenReturn(ID_B)
        Mockito.`when`(converter.idToKey(ID_B)).thenReturn(KEY_B)

        whenever(repo.findOne(Mockito.anyObject())).thenReturn(Optional.empty())
        whenever(repo.findOne(ID_A)).thenReturn(Optional.of(LINK_OBJ_A))
        whenever(repo.findOne(ID_B)).thenReturn(Optional.of(LINK_OBJ_B))
    }

    @Test
    fun clientCanAddLinks() {
        whenever(repo.save(any())).thenReturn(LINK_OBJ_A)
        val keyA = service.add(LINK_A)
        assertEquals(KeyMapperService.Get.Link(LINK_A), service.getLink(keyA))

        whenever(repo.save(any())).thenReturn(LINK_OBJ_B)
        val keyB = service.add(LINK_B)
        assertEquals(KeyMapperService.Get.Link(LINK_B), service.getLink(keyB))

        assertNotEquals(keyA, keyB)
    }


    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }

}



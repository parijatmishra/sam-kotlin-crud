package jackson

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MapperTest {
    val mapper = jacksonObjectMapper()

    @Test
    fun test_readTree() {
        val s = """{
                |"name": "Traveler"
                |}
        """.trimMargin()
        val node = mapper.readTree(s)
        val nameNode = node.get("name")
        assertTrue(nameNode.isTextual)
    }
}
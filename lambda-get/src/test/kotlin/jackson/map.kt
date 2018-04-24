package jackson

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

data class Person(val name: String)

class MapperTest {
    val mapper = jacksonObjectMapper()
    val s1 = """{
                |"name": "Traveler"
                |}
        """.trimMargin()

    @Test
    fun test_readTree() {
        val node = mapper.readTree(s1)
        val nameNode = node.get("name")
        assertTrue(nameNode.isTextual)
        assertEquals("Traveler", nameNode.textValue())
    }

    @Test
    fun test_readValue() {
        val value = mapper.readValue<Person>(s1)
        assertNotNull(value)
        assertEquals("Traveler", value.name)
    }

    @Test
    fun test_readValueEmpty() {
        val s2 = "{}"
        val exception = assertThrows<JsonMappingException> ("Should throw an exception") {
            mapper.readValue<Person>(s2)
        }
    }

    @Test
    fun test_readValueNull() {
        val s2 = """{"name": null}"""
        val exception = assertThrows<JsonMappingException> ("Should throw an exception") {
            mapper.readValue<Person>(s2)
        }
    }

}
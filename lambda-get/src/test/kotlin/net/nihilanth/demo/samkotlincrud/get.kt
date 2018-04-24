package net.nihilanth.demo.samkotlincrud

import net.nihilanth.demo.samkotlincrud.get.Handler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class ListFunctionTests {
    @Test
    fun test_SimpleInput() {
        val s = """{"who": "Traveler"}"""
        val bis = ByteArrayInputStream(s.toByteArray())
        val bos = ByteArrayOutputStream(1000)

        Handler().handler(bis, bos)

        val out = bos.toString("UTF-8")
        assertEquals("""{"message":"Hello, Traveler"}""", out)
    }
}
package net.nihilanth.demo.samkotlincrud.get

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.InputStream
import java.io.OutputStream

/**
 * A Lambda Function that handles a GET / from API GW
 */
data class HandlerInput(val who: String)
data class HandlerOutput(val message: String)

class Handler {
    fun handler(inputStream: InputStream, outputStream: OutputStream) {
        val inputString  = inputStream.bufferedReader().use { it.readText() }
        println("Input is ${inputString}")
    }
}

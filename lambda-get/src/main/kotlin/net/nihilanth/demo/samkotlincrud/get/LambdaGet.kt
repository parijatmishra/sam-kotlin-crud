package net.nihilanth.demo.samkotlincrud.get

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.InputStream
import java.io.OutputStream

/**
 * A Lambda Function that handles a GET / from API GW
 */
data class HandlerInput(val who: String)
data class HandlerOutput(val message: String)

class Handler {
    val mapper = jacksonObjectMapper()

    init {
        mapper.registerKotlinModule()
    }

    fun handler(inputStream: InputStream, outputStream: OutputStream) {
        val inputObj = mapper.readValue<HandlerInput>(inputStream)
        mapper.writeValue(outputStream, HandlerOutput("Hello, ${inputObj.who}"))

//        val inputString  = inputStream.bufferedReader().use { it.readText() }
//        println("Input String is [${inputString}]")
//        val tree = mapper.readTree(inputString)
//        val node = tree.get("who")
//        val text = node.asText()
//        println("node.who = $text")
    }
}

package org.iqw.bin

import java.io.IOException

/**
 * Execute a binary and store stdout and stderr
 */
class Executor {

    var output: String = ""
    var error: String = ""

    fun execute(path: String, vararg args: String){
        try {
            // Use ProcessBuilder to run the command
            val process = ProcessBuilder(path, *args).start()

            // This is blocking
            output = String(process.inputStream.readAllBytes());
            error = String(process.errorStream.readAllBytes());

            if (output.isEmpty() && error.isEmpty()){
                throw IOException("Command $path not found")
            }

            if (error.length != 0)
                throw IOException("Command returned an error: $error")

        } catch (exception: IOException) {
            "IOException occurred: ${exception.message}"
            throw exception
        }
    }
}
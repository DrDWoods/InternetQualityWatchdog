package iqw.bin

import java.io.File

/**
 * Execute a binary and store stdout and stderr
 */
class Executor() {

    var stdout: String = "empty"
    var stderr: String = "empty"

    fun execute(path: File, vararg args: String){
        try{

            // Use ProcessBuilder to run the command
            val processBuilder = ProcessBuilder(*args)

            // Redirect output and error streams to the console
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT)
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT)

            // Start the process
            val process = processBuilder.start()

            // Wait for the process to complete
            process.waitFor()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
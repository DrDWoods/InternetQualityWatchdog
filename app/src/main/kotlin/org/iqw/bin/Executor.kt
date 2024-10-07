package org.iqw.bin

import java.io.IOException

/**
 * Execute a binary and store stdout and stderr
 */
class Executor {

    var output: String = ""
    var error: String = ""

    /**
     * Execute and external process
     *
     * @param path Directory path to process
     * @param args arguments for process at [path]
     * @throws IOException If the external process fails
     */
    fun execute(path: String, vararg args: String){

        // Use ProcessBuilder to run the command
        val process = ProcessBuilder(path, *args).start()

        // This is blocking
        output = String(process.inputStream.readAllBytes());
        error = String(process.errorStream.readAllBytes());

        if(error.isNotEmpty()){
            throw IOException("External process failed.")
        }
    }
}
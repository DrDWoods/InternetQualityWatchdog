package org.iqw.bin

/**
 * Execute a binary and store stdout and stderr
 */
class Executor() {

    var output: String = ""
    var error: String = ""

    fun execute(path: String, vararg args: String){
        try {

            // Use ProcessBuilder to run the command
            val process = ProcessBuilder(path, *args).start()

            // This is blocking
            output = String(process.inputStream.readAllBytes());
            error = String(process.errorStream.readAllBytes());

            if (error.length != 0)
                throw Exception("Executable call failed.")

        } catch (e: Exception) {
            e.printStackTrace()
            print(error)
        }
    }
}
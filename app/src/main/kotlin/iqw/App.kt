/*
 * This source file was generated by the Gradle 'init' task
 */
package iqw

import iqw.bin.Executor
import java.io.File

class App {
    fun run(){
        //val binaryPath = File("./src/main/kotlin/iqw/bin")
        val binaryPath = File(".")
        //println("Speedtest path: $speedtestPath")

        /**
        val files = currentDir.listFiles()
        if (files != null) {
            println("Files and directories in the current directory:")
            for (file in files) {
                println(file.name)
            }
        }
        */

        val executor = Executor()
        //executor.execute(binaryPath, "./speedtest.exe --format=json-pretty")
        executor.execute(binaryPath, "java", "-version")
    }
}

fun main() {
    App().run()
}

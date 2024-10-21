package org.iqw.bin

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Asynchronously execute an external binary and store the output.
 */
class Executor private constructor(private val processBuilder: ProcessBuilder) {

    /**
     * Contain the output of [execute].
     */
    sealed class Result<out T> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error<out T>(val data: T) : Result<T>()
    }
    /**
     * Execute the external process described by [ProcessBuilder].
     * @return [Result] holding stdout or stderr on fail.
     */
    fun execute(): Result<String>{
        val process = processBuilder.start()

        val outputReader = process.inputStream.bufferedReader()
        val errorReader = process.errorStream.bufferedReader()

        process.waitFor() // External process is finished
        val output = outputReader.readText().trim()
        val error = errorReader.readText().trim()

        return if(error.isEmpty()){
            Result.Success(output)
        } else {
            // TODO: Log here that the external process failed.
            Result.Error(error)
        }
    }

    /**
     * Builder for [Executor].
     *
     * @param binaryPath path to external binary that will be executed. If
     * the binary is within the $PATH env var then an absolute path is not
     * required.
     */
    class ExecutorBuilder(private val binaryPath: String){
        private val args: MutableList<String> = mutableListOf()

        /**
         * Optionally supply arguments for external binary.
         *
         * @param args arguments supplied to [binaryPath].
         */
        fun addArgs(vararg args: String) = apply { this.args.addAll(args) }

        fun getArgs(): MutableList<String> {
            return this.args
        }

        fun build(): Executor{
            return Executor(ProcessBuilder(binaryPath, *args.toTypedArray()))
        }
    }
}
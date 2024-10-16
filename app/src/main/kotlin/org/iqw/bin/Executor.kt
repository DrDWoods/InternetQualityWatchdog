package org.iqw.bin

import java.io.IOException
import kotlin.collections.mutableListOf

/**
 * Execute a binary and store output and error.
 */
class Executor private constructor(private val binaryPath: String, private val args: MutableList<String>) {

    /**
     * Contain the output of the command executed by [execute]
     */
    sealed class Result<out T> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error<out T>(val data: T) : Result<T>()
    }

    /**
     * Execute the external process at [binaryPath]. Return true on success.
     */
    fun execute(): Result<String>{
        // Use ProcessBuilder to run the command
        val process = ProcessBuilder(binaryPath, args.joinToString()).start()

        // This is blocking
        val output = String(process.inputStream.readAllBytes()).trim();
        val error = String(process.errorStream.readAllBytes()).trim();

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

        fun build(): Executor{
            return Executor(binaryPath, args)
        }
    }
}
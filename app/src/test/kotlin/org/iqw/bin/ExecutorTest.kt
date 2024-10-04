/*
 * This source file was generated by the Gradle 'init' task
 */
package iqw

import org.iqw.bin.Executor
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import java.io.IOException


/**
 * Test class for [Executor] to verify its output handling.
 */
class ExecutorTest {


    /**
     * Tests that [Executor] can find basic system executables.
     *
     * Execute the echo command
     *
     * @throws IOException if the command "cmd" or "echo" cannot be found.
     */
    @Test fun executorCanFindBasicCommands() {
        val executor = Executor()
        executor.execute("cmd", "/c", "echo")
    }

    /**
     * Tests that [Executor] errors as predicted when commands can't be found.
     *
     * Execute a non-existent command and verify an [IOException] is thrown with
     * a predictable format.
     *
     */
    @Test fun executorFailsWhenCantFindCommand() {
        val executor = Executor()
        val command = "not_a_command"
        val exception = assertThrows<IOException> {
            executor.execute(command)
        }

        // Verify exception is formatted correctly
        val expectedExceptionMessage = "Cannot run program \"$command\": CreateProcess error=2, The system cannot find the file specified"
        assertEquals(expectedExceptionMessage, exception.message)
    }

    /**
     * Tests that [Executor] properly stores the output of a command.
     *
     * Execute an echo command and asserts that the output
     * stored in the object is as expected.
     *
     * @throws IOException if the command "cmd" or "echo" cannot be found.
     * @throws AssertionError if the stored output does not match the expected value.
     */
    @Test fun executorProperlyStoresOutput() {
        val executor = Executor()
        executor.execute("cmd", "/c", "echo", "somewords")
        assertEquals("somewords", executor.output.trim())
    }

    @Test fun executorProperlyStoresError() {
        val executor = Executor()
        executor.execute("cmd", "/c", "echo")
        assertEquals("I NEED TO CREATE THIS TEST", executor.error)
    }
}

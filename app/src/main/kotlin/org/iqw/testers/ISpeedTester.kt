package org.iqw.testers

import org.iqw.dto.SpeedDataDTO

/**
 * Primary tests for the service.
 *
 * @param binaryPath File path of external binary providing
 * internet speed test functionality.
 */
interface ISpeedTester {

    /**
     * Checks the internet quality by running a speed test.
     *
     * @param binaryPath The file path of the speed test binary to execute.
     * @return A [SpeedDataDTO] object containing the speed test results, or `null` if an error occurs.
     */
    fun speedTest(binaryPath: String) : SpeedDataDTO?
}
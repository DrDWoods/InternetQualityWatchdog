package org.iqw.testers

import org.iqw.dto.SpeedDataDTO

/**
 * Primary tests for the service.
 *
 * @param binaryPath File path of external binary providing
 * internet speed test functionality.
 */
interface ISpeedTester {
    fun speedTest(binaryPath: String) : SpeedDataDTO
}
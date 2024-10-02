package org.iqw.testers

import org.iqw.dto.SpeedDataDTO

/**
 * Primary tests for the service.
 */
interface ISpeedTester {
    fun speedTest() : SpeedDataDTO
}
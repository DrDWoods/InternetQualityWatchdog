package iqw.http

import iqw.dto.SpeedData

/**
 * Primary tests for the service.
 */
interface ISpeedTest {
    fun speedTest() : SpeedData
}
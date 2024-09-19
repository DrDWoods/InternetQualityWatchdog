package iqw.http

import iqw.dto.SpeedData
import java.io.File

/**
 * Implement ISpeedTest interface by directly calling the Ookla binary
 * from https://www.speedtest.net/apps/cli
 */
class Ookla : ISpeedTest {

    /**
     * Check the internet quality and translate the returned json into SpeedData DTO
     */
    override fun speedTest(): SpeedData {
        TODO("Not yet implemented")
    }
}
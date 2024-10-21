package org.iqw.testers

import kotlinx.serialization.json.Json
import org.iqw.bin.Executor
import org.iqw.dto.SpeedDataDTO
import org.iqw.dto.OoklaDTO
import java.time.Instant
import java.time.LocalDateTime

/**
 * Implement ISpeedTest interface by directly calling the Ookla binary
 * from https://www.speedtest.net/apps/cli
 */
class OoklaTester : ISpeedTester {

    /**
     * Checks the internet quality by running a speed test using the Ookla binary.
     *
     * @param binaryPath The file path of the speed test binary to execute.
     * @return A [SpeedDataDTO] object containing the speed test results, or `null` if an error occurs.
     */
    override fun speedTest(binaryPath: String): SpeedDataDTO? {
        val executor = Executor.ExecutorBuilder(binaryPath)
            .addArgs("--format=json-pretty")
            .build()

        return when(val result = executor.execute()){
            is Executor.Result.Success -> extractInformation(result.data)
            is Executor.Result.Error -> null
        }
    }

    /**
     * Deserialise data from Ookla binary into a standardised SpeedDataDTO object.
     */
    private fun extractInformation(output: String): SpeedDataDTO {
        val withUnknownKeys = Json { ignoreUnknownKeys = true }
        val ooklaData: OoklaDTO = withUnknownKeys.decodeFromString<OoklaDTO>(output)
        return SpeedDataDTO(
            localDateTime = LocalDateTime.now().withNano(0), // Ignore [ns] precision
            downloadSpeed = ooklaData.download.bytes,
            uploadSpeed = ooklaData.upload.bytes)
    }
}
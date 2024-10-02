package org.iqw.testers

import kotlinx.serialization.json.Json
import org.iqw.bin.Executor
import org.iqw.dto.SpeedDataDTO
import org.iqw.dto.OoklaDTO
import java.time.Instant

/**
 * Implement ISpeedTest interface by directly calling the Ookla binary
 * from https://www.speedtest.net/apps/cli
 */
class OoklaTester : ISpeedTester {

    /**
     * Check the internet quality and return information in storable SpeedDataDTO format.
     */
    override fun speedTest(): SpeedDataDTO {
        val executor = Executor()
        executor.execute("src/main/kotlin/org/iqw/bin/speedtest.exe", "--format=json-pretty")
        return extractInformation(executor.output)
    }


    /**
     * Deserialise data from Ookla into a standardised SpeedDataDTO object for storage.
     */
    private fun extractInformation(output: String): SpeedDataDTO {
        // TODO this can throw. "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys."
        // TODO Add exception handling and some tests
        val ooklaData: OoklaDTO = Json.decodeFromString<OoklaDTO>(output)
        return SpeedDataDTO(timestamp = Instant.parse(ooklaData.timestamp), downloadSpeed = ooklaData.download.bytes, uploadSpeed = ooklaData.upload.bytes)
    }
}
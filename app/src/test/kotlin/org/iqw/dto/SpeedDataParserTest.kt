package org.iqw.dto

import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.assertEquals

/**
 * test class for [SpeedDataParser] to verify helper functions
 * related to the [SpeedDataDTO] class.
 */
class SpeedDataParserTest {

    val speedDataDTO = SpeedDataDTO(
        LocalDateTime.of(LocalDate.of(2024,10,18), LocalTime.of(15, 30, 25,786400200)),
        100,
        10)

    /**
     * Test that [SpeedDataParser.parse] properly reads and formats
     * a [SpeedDataDTO] object
     */
    @Test fun test(){
        val output = SpeedDataParser.parse(speedDataDTO)

        val expectedFormat = "Speed Data:\n" +
                "Date & Time: 18 October 2024, 03:30:25 pm\n" +
                "Download Speed: ${speedDataDTO.downloadSpeed}\n" +
                "Upload Speed: ${speedDataDTO.uploadSpeed}\n"

        assertEquals(expectedFormat, output)
    }
}
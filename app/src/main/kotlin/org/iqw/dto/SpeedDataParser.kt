package org.iqw.dto

import java.time.format.DateTimeFormatter

/**
 * Store helper functions to parse a SpeedDataDTO object.
 */
object SpeedDataParser {

    /**
     * Create a String prettily displaying SpeedDataDTO information
     */
    fun parse(speedData: SpeedDataDTO): String {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm:ss a")
        val formattedDateTime = speedData.localDateTime.format(formatter)

        return "Speed Data:\n" +
                "Date & Time: $formattedDateTime\n" +
                "Download Speed: ${speedData.downloadSpeed}\n" +
                "Upload Speed: ${speedData.uploadSpeed}\n"
    }
}
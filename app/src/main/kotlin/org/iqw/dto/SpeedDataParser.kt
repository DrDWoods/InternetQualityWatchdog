package org.iqw.dto

import java.time.format.DateTimeFormatter

object SpeedDataParser {
    fun parse(speedData: SpeedDataDTO){
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm:ss a")
        val formattedDateTime = speedData.localDateTime.format(formatter)

        println("Speed Data:")
        println("Date & Time: $formattedDateTime")
        println("Download Speed: ${speedData.downloadSpeed} Mbps")
        println("Upload Speed: ${speedData.uploadSpeed} Mbps")
    }

}
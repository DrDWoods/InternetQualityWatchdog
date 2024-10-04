package org.iqw.dto

import java.time.LocalDateTime

/**
 * Record the internet connection speed in a format we can save to database
 * @param localDateTime local datetime value when measurement was taken
 * @param downloadSpeed Download connection (Bps)
 * @param uploadSpeed Upload connection (Bps)
 */
data class SpeedDataDTO(val localDateTime: LocalDateTime, val downloadSpeed: Int, val uploadSpeed: Int)

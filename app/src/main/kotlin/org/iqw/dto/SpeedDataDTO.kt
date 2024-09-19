package org.iqw.dto

import java.time.Instant

/**
 * Record the internet connection speed in a format we can save to database
 * @param timestamp Time when measurement was taken
 * @param downloadSpeed Download connection (Bps)
 * @param uploadSpeed Upload connection (Bps)
 */
data class SpeedDataDTO(val timestamp: Instant, val downloadSpeed: Int, val uploadSpeed: Int)

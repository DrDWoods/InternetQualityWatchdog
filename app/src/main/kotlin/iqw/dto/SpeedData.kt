package iqw.dto

import java.time.Instant

/**
 * Record the internet connection speed
 * @param timestamp Time when measurement was taken
 * @param downloadSpeed Download connection
 * @param uploadSpeed Upload connection
 */
data class SpeedData(val timestamp: Instant, val downloadSpeed: Float, val uploadSpeed: Float)

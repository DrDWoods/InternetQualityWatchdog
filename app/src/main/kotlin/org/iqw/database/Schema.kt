package org.iqw.database

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

/**
 * Record the internet connection speed in a format we can save to database
 * @param timestamp Time when measurement was taken
 * @param downloadSpeed Download connection (Bps)
 * @param uploadSpeed Upload connection (Bps)
 */
object Schema : IntIdTable() { // Automatically adds `id` as the primary key
    val timestamp = timestamp("time")
    val downloadSpeed = integer("download speed")
    val uploadSpeed = integer("upload speed")
}
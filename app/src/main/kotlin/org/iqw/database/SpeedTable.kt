package org.iqw.database

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

/**
 * Database table storing @see org.iqw.dto.SpeedDataDTO data
 * @param timestamp Time when measurement was taken
 * @param downloadSpeed Download connection (Bps)
 * @param uploadSpeed Upload connection (Bps)
 */
object SpeedTable : LongIdTable() { // LongIdTable automatically adds `id` as the primary key
    val timestamp = timestamp("time")
    val downloadSpeed = integer("download speed")
    val uploadSpeed = integer("upload speed")
}
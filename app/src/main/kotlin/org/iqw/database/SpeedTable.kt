package org.iqw.database

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

/**
 * Database table storing @see org.iqw.dto.SpeedDataDTO data
 * @param localDateTime Local datetime when measurement was taken
 * @param downloadSpeed Download connection (Bps)
 * @param uploadSpeed Upload connection (Bps)
 */
object SpeedTable : LongIdTable() { // LongIdTable automatically adds `id` as the primary key
    val localDateTime = datetime("datetime")
    val downloadSpeed = integer("download speed")
    val uploadSpeed = integer("upload speed")
}
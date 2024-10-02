package org.iqw.database

import org.iqw.dto.SpeedDataDTO
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant


object SpeedTableService {

    /**
     * Create a new table entry
     */
    fun createEntry(data: SpeedDataDTO): Unit {
        return transaction {
            val userId = SpeedTable.insertAndGetId {
                it[SpeedTable.timestamp] = data.timestamp
                it[SpeedTable.downloadSpeed] = data.downloadSpeed
                it[SpeedTable.uploadSpeed] = data.uploadSpeed
            }
        }
    }

    /**
     * Return latest entry
     */
    fun getLatest(): SpeedDataDTO? {
        return transaction {
            SpeedTable.selectAll()
                .orderBy(SpeedTable.timestamp, SortOrder.DESC)
                .limit(1)
                .mapNotNull { SpeedDataDTO(
                    timestamp = it[SpeedTable.timestamp],
                    downloadSpeed = it[SpeedTable.downloadSpeed],
                    uploadSpeed = it[SpeedTable.uploadSpeed]
                )
                 }
                .singleOrNull()
        }
    }


}
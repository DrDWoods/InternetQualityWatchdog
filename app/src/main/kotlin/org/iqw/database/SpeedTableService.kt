package org.iqw.database

import org.iqw.dto.SpeedDataDTO
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


object SpeedTableService {

    /**
     * Create a new table entry
     */
    fun createEntry(data: SpeedDataDTO): Unit {
        return transaction {
            SpeedTable.insertAndGetId {
                it[SpeedTable.localDateTime] = data.localDateTime
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
                .orderBy(SpeedTable.localDateTime, SortOrder.DESC)
                .limit(1)
                .mapNotNull { SpeedDataDTO(
                    localDateTime = it[SpeedTable.localDateTime],
                    downloadSpeed = it[SpeedTable.downloadSpeed],
                    uploadSpeed = it[SpeedTable.uploadSpeed]
                )
                 }
                .singleOrNull()
        }
    }


}
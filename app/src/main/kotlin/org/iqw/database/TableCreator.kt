package org.iqw.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Create table if they don't already exist
 * @param table table to create of type Table
 */
object TableCreator {
    fun createTables(table: Table){
        transaction {
            create(table)
        }
    }
}
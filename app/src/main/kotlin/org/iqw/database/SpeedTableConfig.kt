package org.iqw.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Setup functionality for database storage
 */
object SpeedTableConfig {

    /**
     * Create a database NEEDS CHANGING
     */
    fun create(database: Database){
        transaction(database){
            SchemaUtils.create(SpeedTable)
        }
    }

    /**
     * Connect the application to an existing database
     */
    fun connect(databaseName: String, username: String, password: String) {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/$databaseName",  // Replace with your MySQL URL
            driver = "com.mysql.cj.jdbc.Driver",
            user = username,
            password = password
        )
    }
}
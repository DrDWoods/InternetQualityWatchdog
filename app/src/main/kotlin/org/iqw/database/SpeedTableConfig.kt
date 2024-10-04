package org.iqw.database

import org.jetbrains.exposed.sql.Database

/**
 * Setup functionality for database storage
 */
object SpeedTableConfig {

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
package org.iqw.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Setup functionality for database storage
 */
object SpeedTableConfig {

    /**
     * Create a database
     */
    fun create(database: Database){
        transaction(database){
            SchemaUtils.create(SpeedTable)
        }
    }

    /**
     * Connect the application to an existing database
     */
    fun connect() {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/your_database_name",  // Replace with your MySQL URL
            driver = "com.mysql.cj.jdbc.Driver",
            user = "your_user",  // Replace with your MySQL user
            password = "your_password"  // Replace with your MySQL password
        )
    }
}
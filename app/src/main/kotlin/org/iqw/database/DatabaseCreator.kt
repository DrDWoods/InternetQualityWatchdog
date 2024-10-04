package org.iqw.database

import java.sql.Connection

/**
 * Create a database if it doesn't already exist using MySQL
 */
object DatabaseCreator {
    fun createDatabaseIfNotExists(connection: Connection, dbName: String) {

        // Connect to MySQL server, not a specific database
        val statement = connection.createStatement()

        // Create the database if it doesn't exist
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS $dbName")

        statement.close()
        connection.close()
    }
}
package org.iqw.database

import org.jetbrains.exposed.sql.Database

object DatabaseConfig {
    fun connect() {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/your_database_name",  // Replace with your MySQL URL
            driver = "com.mysql.cj.jdbc.Driver",
            user = "your_user",  // Replace with your MySQL user
            password = "your_password"  // Replace with your MySQL password
        )
    }
}
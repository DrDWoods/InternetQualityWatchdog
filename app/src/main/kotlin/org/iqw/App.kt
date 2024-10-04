package org.iqw

import org.iqw.database.DatabaseCreator
import org.iqw.database.SpeedTable
import org.iqw.database.SpeedTableConfig
import org.iqw.database.SpeedTableService
import org.iqw.database.TableCreator
import org.iqw.dto.SpeedDataDTO
import org.iqw.testers.ISpeedTester
import org.iqw.testers.OoklaTester
import java.sql.DriverManager
import java.time.LocalDateTime

class App {
    fun run(dbUser: String, dbPassword: String){
        val tester: ISpeedTester = OoklaTester()
        val testData = tester.speedTest()
        val localDateTime = testData.localDateTime
        val downloadSpeed = testData.downloadSpeed
        val uploadSpeed = testData.uploadSpeed
        println("localDateTime = $localDateTime")
        println("Download speed = $downloadSpeed")
        println("Upload speed = $uploadSpeed")

        // Create db
        val dbName = "SpeedDatabase"
        DatabaseCreator.createDatabaseIfNotExists( // Setup the background Database object used by transactions
            DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=$dbUser&password=$dbPassword"),
            dbName
        )

        // Connect to db
        SpeedTableConfig.connect(dbName, dbUser, dbPassword)

        // Create table
        TableCreator.createTables(SpeedTable)

        // Add entry to db
        SpeedTableService.createEntry(SpeedDataDTO(
            LocalDateTime.now(),
            100,
            10
        ))

        // Print latest entry
        println(SpeedTableService.getLatest())

    }
}

fun main() {
    App().run("root", "X")
}

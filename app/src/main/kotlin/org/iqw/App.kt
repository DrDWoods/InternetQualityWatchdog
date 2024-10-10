package org.iqw

import org.iqw.bin.Executor
import org.iqw.database.DatabaseCreator
import org.iqw.database.SpeedTable
import org.iqw.database.SpeedTableConfig
import org.iqw.database.SpeedTableService
import org.iqw.database.TableCreator
import org.iqw.dto.SpeedDataDTO
import org.iqw.dto.SpeedDataParser
import org.iqw.testers.ISpeedTester
import org.iqw.testers.OoklaTester
import java.sql.DriverManager
import java.time.LocalDateTime

class App {
    fun run(dbUser: String, dbPassword: String){
        val tester: ISpeedTester = OoklaTester()
        val testData = tester.speedTest("src/main/kotlin/org/iqw/bin/speedtest.exe")
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
        val data = SpeedTableService.getLatest()
        if(data != null)
            SpeedDataParser.parse(data)

    }
}

fun main() {
    val username = System.getenv("MySQLUsername")
    val password = System.getenv("MySQLPassword")
    App().run(username, password)
}

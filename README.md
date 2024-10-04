# InternetQualityWatchdog
Simple service that tracks internet quality over time.

# Data
Currently the Ookla speedtest binary is used for the download/upload measurement. This information
is deserialised into a DTO and stored in a MySQL database.

# Usage
1. Put the Ookla speedtest https://www.speedtest.net/apps/cli binary into the
src/main/kotlin/ikw/bin directory.
2. Change username and password in org.iqw.database.DatabaseConfig
3. ./gradlew build
4. ./gradlew run

The service can also be used as a docker container.

# Connecting to a database and basic MySQL parsing
1. Open a terminal and run 'mysqlsh'
2. Switch to SQL language with '\sql'
3. Connect to MySQL server running on localhost '\connect root@localhost:3306'
4. Display databases with 'SHOW DATABASES;'
5. Select database you want to use 'USE SPEEDDATABASE'
6. List all tables 'SHOW TABLES;'
7. Print information in table 'SELECT * FROM $table;'
8. Show columns of table with 'DESCRIBE $table;'
9. Delete a table with 'DROP TABLE $table'
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
# InternetQualityWatchdog
Simple service that tracks internet quality over time.

# Data
Currently the Ookla speedtest binary is used for the download/upload measurement. This information
is deserialised into a DTO and stored in a MySQL database.

# Usage
Must put the Ookla speedtest https://www.speedtest.net/apps/cli binary into the
src/main/kotlin/ikw/bin directory.

1. ./gradlew build
2. ./gradlew run

The service can also be used as a docker container.
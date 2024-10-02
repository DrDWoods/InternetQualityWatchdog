package org.iqw.dto

import kotlinx.serialization.Serializable

/**
 * Hold data that comes from the Ookla binary
 */
@Serializable
data class OoklaDTO(
    val type: String,
    val timestamp: String,
    val ping: Ping,
    val download: Download,
    val upload: Upload,
    val isp: String,
    val `interface`: NetworkInterface,
    val server: Server,
    val result: Result
)

@Serializable
data class Ping(
    val jitter: Double,
    val latency: Double,
    val low: Double,
    val high: Double
)

@Serializable
data class Download(
    val bandwidth: Int,
    val bytes: Int,
    val elapsed: Int,
    val latency: Latency
)

@Serializable
data class Upload(
    val bandwidth: Int,
    val bytes: Int,
    val elapsed: Int,
    val latency: Latency
)

@Serializable
data class Latency(
    val iqm: Double,
    val low: Double,
    val high: Double,
    val jitter: Double
)

@Serializable
data class NetworkInterface(
    val internalIp: String,
    val name: String,
    val macAddr: String,
    val isVpn: Boolean,
    val externalIp: String
)

@Serializable
data class Server(
    val id: Int,
    val host: String,
    val port: Int,
    val name: String,
    val location: String,
    val country: String,
    val ip: String
)

@Serializable
data class Result(
    val id: String,
    val url: String,
    val persisted: Boolean
)
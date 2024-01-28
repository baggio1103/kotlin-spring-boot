package com.javajedi.metricsobservability

import io.micrometer.core.annotation.Timed
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("/api/v1/coordinates")
class CoordinatesController {

    @Timed(value = "coordinates.live", description = "Time taken to calculate coordinate")
    @GetMapping("/live")
    fun coordinate(request: HttpServletRequest): Coordinate {
        Thread.sleep(Random.nextLong(50, 150))
        return Coordinate(54.54, 24.5)
    }

}

data class Coordinate(
    val latitude: Double,
    val longitude: Double
)
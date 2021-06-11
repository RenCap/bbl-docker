package org.rencap.bbldockerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BblDockerApiApplication

fun main(args: Array<String>) {
    runApplication<BblDockerApiApplication>(*args)
}

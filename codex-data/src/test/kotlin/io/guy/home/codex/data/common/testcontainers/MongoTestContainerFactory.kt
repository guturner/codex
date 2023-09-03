package io.guy.home.codex.data.common.testcontainers

import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName

fun buildMongoTestContainer(): MongoDBContainer {
    return MongoDBContainer(DockerImageName.parse("mongo:7.0.0")).withExposedPorts(27017)
}
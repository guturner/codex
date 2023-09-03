package io.guy.home.codex.data.common.testcontainers

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import io.guy.home.codex.data.common.logs.Logger
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.data.mongodb.core.MongoTemplate
import org.testcontainers.shaded.org.awaitility.Awaitility.await

abstract class CodexMongoTest {

    companion object {
        private val mongoContainer = buildMongoTestContainer()

        private val logger by Logger()

        @BeforeAll
        @JvmStatic
        fun setUpClass() {
            logger.trace("Starting MongoDB TestContainer...")

            mongoContainer.start()
            await().until { mongoContainer.isRunning }

            logger.trace("MongoDB TestContainer started!")
        }

        @AfterAll
        @JvmStatic
        fun tearDownClass() {
            logger.trace("Stopping MongoDB TestContainer...")

            mongoContainer.stop()
            await().until { !mongoContainer.isRunning }

            logger.trace("MongoDB TestContainer stopped!")
        }

        fun getMongoTemplate(): MongoTemplate {
            return MongoTemplate(buildMongoClient(mongoContainer.host, mongoContainer.firstMappedPort), "admin")
        }

        private fun buildMongoClient(hostName: String, port: Int): MongoClient {
            val clientSettings: MongoClientSettings.Builder = MongoClientSettings.builder()
                .applyConnectionString(ConnectionString("mongodb://$hostName:$port"))

            return MongoClients.create(clientSettings.build())
        }
    }
}
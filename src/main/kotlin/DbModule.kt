package org.example

import org.koin.dsl.module
import javax.sql.DataSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

val dbModule = module {
    single<Database> {
        val ds = get<DataSource>()
        val db = Database.connect(ds)

        db
    }
    single<DataSource> {
        val cfg = HikariConfig().apply {
            jdbcUrl = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/postgres"
            username = System.getenv("DB_USER") ?: "postgres"
            password = System.getenv("DB_PASSWORD") ?: "postgres"
            driverClassName = "org.postgresql.Driver"
        }
        HikariDataSource(cfg)
    }

    single {
        val ds = get<DataSource>()
        Flyway.configure()
            .dataSource(ds)
            .locations("classpath:db/migration")
            .baselineOnMigrate(true)
            .load()
    }
}
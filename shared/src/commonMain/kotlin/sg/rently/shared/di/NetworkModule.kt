package sg.rently.shared.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import sg.rently.shared.repositories.MarketplaceRepo

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        prettyPrint = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}

val appModule = module {
    single {
        MarketplaceAPI(get())
    }
    single {
        MarketplaceRepo(get())
    }
}


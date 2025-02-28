package sg.rently.shared.di

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import sg.rently.shared.models.MarketplaceResponse

class MarketplaceAPI(
    private val client: HttpClient
) {
    suspend fun getMarketplace(): MarketplaceResponse {
        return client.request {
            url("https://marketplace-api.rently.sg/api/v2/marketplace?pageNumber=1&pageSize=100")
            method = HttpMethod.Get
        }.body()
    }
}
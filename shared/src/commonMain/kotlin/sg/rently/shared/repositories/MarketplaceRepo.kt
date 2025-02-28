package sg.rently.shared.repositories

import sg.rently.shared.di.MarketplaceAPI
import sg.rently.shared.models.ListingResponse

class MarketplaceRepo(
    private val marketplaceAPI: MarketplaceAPI
) {

    suspend fun getMarketplace(): List<ListingResponse> {
        return marketplaceAPI.getMarketplace().listings
    }
}


package sg.rently.shared.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketplaceResponse(
    val totalCount: Int,
    @SerialName("data")
    val listings: List<ListingResponse>
)

@Serializable
data class ListingResponse(
    val id: String? = null,
    val marketplaceId: String? = null,
    val entityId: String? = null,
    val tenantId: String? = null,
    val landlordId: String? = null,
    val corporateId: String? = null,
    val pgAgentId: String? = null,
    val pgListingId: Int? = null,
    val agentId: String? = null,
    val agentName: String? = null,
    val title: String? = null,
    val thumbnail: String? = null,
    val imageUrlList: List<String?>? = null,
    val regionText: String? = null,
    val districtCode: String? = null,
    val districtText: String? = null,
    val fullAddress: String? = null,
    val longitude: Double? = null,
    val latitude: Double? = null,
    val paymentPeriod: String? = null,
    val price: PriceDTO? = null,
    val numberOfBedrooms: Int,
    val numberOfBathrooms: Int,
    val size: String? = null,
    val propertyType: Int? = null,
    val propertySubType: Int? = null,
    val furnitureStatus: Int? = null,
    val buildDate: String? = null,
    val isAvailable: Boolean? = null,
    val area: AreaDTO? = null,
    val expiryDate: String? = null,
    val updatedBy: String? = null,
    val createdBy: String? = null,
    val createdOn: String? = null,
    val address: PropertyAddressDTO? = null,
    val occupationStatus: Int? = null,
    val numberOfRoomsOccupied: Int? = null,
    val availableBy: String? = null,
    val description: String? = null,
    val offerThreshold: PropertyRentalAmountThreshold? = null,
    val imageAnalyzedInfo: ImageAnalyzedInfo? = null,
    val marketplaceExclusionReason: Int? = null,
    val amenities: List<Int>? = null,
    val rules: Map<String, String>? = null,
)

@Serializable
data class PriceDTO(
    val amount: Double,
    val currencyId: Int,
    val currencyName: String?
)

@Serializable
data class AreaDTO(
    val value: Int,
    val unit: Int,
    val description: String
)

@Serializable
data class PropertyAddressDTO(
    val block: String? = null,
    val building: String? = null,
    val floor: String? = null,
    val unit: String? = null,
    val street: String? = null,
    val postalCode: String? = null,
    val country: String? = null,
    val location: PropertyLocationDTO? = null,
    val displayAddress: String? = null,
    val districtCode: String? = null,
    val districtText: String? = null
)

@Serializable
data class PropertyLocationDTO(
    val longitude: Double? = null,
    val latitude: Double? = null,
)

@Serializable
data class PropertyRentalAmountThreshold(
    val amountToWarn: Double? = null,
    val amountToBlock: Double? = null,
)

@Serializable
data class ImageAnalyzedInfo(
    val status: Int? = null,
    val message: String? = null,
    val lastExecutedDate: String? = null,
)
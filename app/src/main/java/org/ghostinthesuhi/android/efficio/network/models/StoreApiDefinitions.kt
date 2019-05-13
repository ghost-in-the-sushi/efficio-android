package org.ghostinthesuhi.android.efficio.network.models

data class Store(val name: String, val store_id: String, val aisles: List<Aisle>)

data class Aisle(val name: String, val aisle_id: String, val sort_weight: Float, val products: List<Product>)

data class Product(
    val name: String,
    val product_id: String,
    val sort_weight: Float,
    val is_done: Boolean,
    val quantity: Int,
    val unit: ProductUnit
)

enum class ProductUnit(val type: Int) {
    UNIT(0), GRAM(1), ML(2)
}

data class StoreLight(val name: String, val store_id: String)
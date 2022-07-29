package ratanak.pek.core.data

data class Expense(
    var id: Int,
    var title: String,
    var amount: Double,
    var description: String,
    var createdDate: Long,
    var updateTime: Long,
) {
    var wordCount: Int = 0
}
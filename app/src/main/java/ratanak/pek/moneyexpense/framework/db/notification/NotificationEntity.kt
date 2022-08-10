package ratanak.pek.moneyexpense.framework.db.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ratanak.pek.core.data.Expense
import ratanak.pek.core.data.Notification

@Entity(tableName = "Notification")
data class NotificationEntity(
    val title: String,
    val desc: String,

    @ColumnInfo(name = "create_time")
    val createTime: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    companion object {
        fun fromNotification(note: Notification) = NotificationEntity(
            note.title,
            note.description,
            note.createdDate,
            note.id
        )
    }

    fun getNotification() = Notification(id, title, desc, createTime)
}
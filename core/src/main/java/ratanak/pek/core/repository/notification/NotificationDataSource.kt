package ratanak.pek.core.repository.notification

import ratanak.pek.core.data.Notification

interface NotificationDataSource {
    suspend fun create(notification: Notification)
    suspend fun get(id: Int): Notification?
    suspend fun getAll(): List<Notification>
    suspend fun remove(notification: Notification)
}
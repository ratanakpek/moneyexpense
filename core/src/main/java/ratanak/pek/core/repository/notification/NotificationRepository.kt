package ratanak.pek.core.repository.notification

import ratanak.pek.core.data.Notification

class NotificationRepository(var dataSource: NotificationDataSource) {
    suspend fun addExpense(note: Notification) = dataSource.create(note)
    suspend fun getExpense(id: Int) = dataSource.get(id)
    suspend fun getAll() = dataSource.getAll()
    suspend fun remove(note: Notification) = dataSource.remove(note)
}
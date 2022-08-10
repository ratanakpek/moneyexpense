package ratanak.pek.moneyexpense.framework.notification

import android.content.Context
import ratanak.pek.core.data.Expense
import ratanak.pek.core.data.Notification
import ratanak.pek.core.repository.expense.ExpenseDataSource
import ratanak.pek.core.repository.notification.NotificationDataSource
import ratanak.pek.moneyexpense.framework.db.DatabaseService
import ratanak.pek.moneyexpense.framework.db.expense.ExpenseEntity
import ratanak.pek.moneyexpense.framework.db.notification.NotificationEntity
import ratanak.pek.moneyexpense.framework.expense.RoomExpenseDatasource

class RoomNotificationDatasource(context: Context) : NotificationDataSource {
    val dao = DatabaseService.getInstance(context).notificationDao()

    override suspend fun create(notification: Notification) {
        dao.createNotification(NotificationEntity.fromNotification(notification))
    }

    override suspend fun get(id: Int): Notification? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Notification> {
        TODO("Not yet implemented")
    }

    override suspend fun remove(notification: Notification) {
        TODO("Not yet implemented")
    }


}
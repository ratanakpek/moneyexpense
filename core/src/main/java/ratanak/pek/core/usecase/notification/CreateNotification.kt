package ratanak.pek.core.usecase.notification

import ratanak.pek.core.data.Notification
import ratanak.pek.core.repository.notification.NotificationDataSource

class CreateNotification(private val repository: NotificationDataSource) {
    open suspend operator fun invoke(notification: Notification) = repository.create(notification)
}
package ratanak.pek.moneyexpense.framework.notification

import ratanak.pek.core.repository.notification.NotificationRepository
import ratanak.pek.core.usecase.notification.CreateNotification

data class NotificationUseCases(
    var createNotificationUseCase: NotificationRepository
)
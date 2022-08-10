package ratanak.pek.moneyexpense.framework.db.notification

import androidx.room.*

@Dao
interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNotification(entity: NotificationEntity)
}
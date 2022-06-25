package ratanak.pek.moneyexpense.service

import android.app.Activity
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SampleService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> {
                Log.e(TAG, ACTION_START)
                try {
                    val pendingIntent =
                        intent.getParcelableExtra<PendingIntent>(EXTRA_PENDING_INTENT)

                    val result = Intent().putExtra("result", "I love you")
                    pendingIntent?.send(
                        applicationContext,
                        Activity.RESULT_OK,
                        result
                    )
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }
            ACTION_PAUSE -> {
                Log.e(TAG, ACTION_PAUSE)
            }
            ACTION_STOP -> {
                stopSelf()
                Log.e(TAG, ACTION_STOP)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.e(TAG, "Destroy...")
    }

    companion object {
        private var TAG = SampleService::class.simpleName.orEmpty()
    }
}

const val ACTION_START = "action_start"
const val ACTION_STOP = "action_stop"
const val ACTION_PAUSE = "action_pause"

const val EXTRA_PENDING_INTENT = "extra_pending_intent"
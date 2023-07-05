package dsm.hackathon.dsmhackathon2023_team18.util

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dsm.hackathon.dsmhackathon2023_team18.MainActivity
import dsm.hackathon.dsmhackathon2023_team18.R

@SuppressLint("MissingPermission")
fun Context.sendNotification(
    title: String,
    content: String,
) {
    val intent = Intent(this, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        this, 0, intent, PendingIntent.FLAG_MUTABLE,
    )
    val name = "Tiger"
    val descriptionText = "Tiger gives you some advices"
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel("ch_onui_notification", name, importance).apply {
        description = descriptionText
    }
    val builder =
        NotificationCompat.Builder(this, "ch_onui_notification").setSmallIcon(R.drawable.ic_tiger)
            .setContentTitle(title).setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).setContentIntent(pendingIntent)
    // Register the channel with the system
    val notificationManager: NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
    with(NotificationManagerCompat.from(this)) {
        notify(System.currentTimeMillis().hashCode(), builder.build())
    }
}

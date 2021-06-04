package com.acelyaoguz.alarmmanager

import android.media.Ringtone
import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class AlarmActivity : AppCompatActivity() {

    lateinit var zilsesi: Ringtone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        var alarmUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if(alarmUri==null)
        {
            alarmUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        zilsesi=RingtoneManager.getRingtone(this,alarmUri)
        zilsesi.play()

    }

    fun btnAlarmDurdur_OnClick(view: View) {


        if(zilsesi.isPlaying)
            zilsesi.stop()
        Toast.makeText(this, "Alarm durduruldu", Toast.LENGTH_SHORT).show()
    }
}
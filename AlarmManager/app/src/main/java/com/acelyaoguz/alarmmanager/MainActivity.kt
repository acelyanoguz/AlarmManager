package com.acelyaoguz.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnAlarmOlustur_OnClick(view: View) {
        val calendar=Calendar.getInstance()

        var timePickerDialog=TimePickerDialog(this,onTimeSetListener,calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE],true)
        timePickerDialog.setTitle("Alarm Zamanı Seçiniz")
        timePickerDialog.show()
    }

    var onTimeSetListener=TimePickerDialog.OnTimeSetListener{
        view, saat, dakika->
        val secilenTakvim=Calendar.getInstance()
        secilenTakvim[Calendar.HOUR_OF_DAY]=saat
        secilenTakvim[Calendar.MINUTE]=dakika

        val intent= Intent(this,AlarmReceiver::class.java)
        val pendingIntent=PendingIntent.getBroadcast(this,0,intent,0)
        val alarmManager=getSystemService(Context.ALARM_SERVICE)as AlarmManager
        alarmManager[AlarmManager.RTC_WAKEUP,secilenTakvim.timeInMillis]=pendingIntent

    }


}
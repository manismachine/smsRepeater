package br.com.helpdev.smsreceiver

import android.Manifest
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import br.com.helpdev.smsreceiver.receiver.SMSReceiver
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var savePref: Preferences? = null

    lateinit  var saveButton : Button
    lateinit  var chatid : EditText
    lateinit  var chatidmsg : TextView


    companion object {
        private const val REQUEST_CODE_SMS_PERMISSION = 1
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*saveButton = findViewById<Button>(R.id.save)
        chatid     = findViewById<EditText>(R.id.chatidet)
        chatidmsg  = findViewById<TextView>(R.id.chatidmsg)*/

        savePref = Preferences(this)


        requestSmsPermission()
        registerSmsReceiver()
    }



    private fun registerSmsReceiver() {
       //
         val ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
        val myBroadCastReceiver: BroadcastReceiver = SMSReceiver()
        val filter = IntentFilter(ACTION_SMS_RECEIVED)
        registerReceiver(myBroadCastReceiver, filter)

    }

    private fun requestSmsPermission() {
        val permission = Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), REQUEST_CODE_SMS_PERMISSION)
        }
    }



}
/*https://github.com/gbzarelli/sms-received-sample*/
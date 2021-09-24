package br.com.helpdev.smsreceiver.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import br.com.helpdev.smsreceiver.Preferences
import java.net.HttpURLConnection
import java.net.URL


class SMSReceiver : BroadcastReceiver() {
    private val ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    var savePref: Preferences? = null


    companion object {
        private val TAG by lazy { SMSReceiver::class.java.simpleName }

    }

    override fun onReceive(context: Context?, intent: Intent?) {
        savePref = Preferences(context)

        val chatIdVal: String? = savePref?.getChatid()
        if (chatIdVal === "nochatid" ) {}else{

        //if (!intent?.action.equals(ACTION_SMS_RECEIVED)) return
        val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        extractMessages.forEach { smsMessage ->
            Log.e("smsreceived", smsMessage.displayMessageBody)

            //if (smsMessage.displayMessageBody . contains("test123")){

        }

            // }
        }
        //TODO
    }



}
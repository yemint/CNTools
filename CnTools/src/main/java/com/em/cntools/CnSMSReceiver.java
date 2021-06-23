package com.em.cntools;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 广播接收器
 */
public class CnSMSReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    private Handler handler;
    private int RECEIVERED_MSG;

    public CnSMSReceiver(Handler handler, int msgWhat) {
        this.handler = handler;
        RECEIVERED_MSG = msgWhat;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //判断广播消息
        if (action.equals(SMS_RECEIVED_ACTION)) {
            Bundle bundle = intent.getExtras();
            //如果不为空
            if (bundle != null) {

                Object[] object = (Object[]) intent.getExtras().get("pdus");
                StringBuilder sb = new StringBuilder();
                assert object != null;
                for (Object pdus : object) {
                    byte[] pdusMsg = (byte[]) pdus;
                    SmsMessage sms = SmsMessage.createFromPdu(pdusMsg);
                    String mobile = sms.getOriginatingAddress();//发送短信的手机号
                    String content = sms.getMessageBody();//短信内容
                    //下面是获取短信的发送时间
                    Date date = new Date(sms.getTimestampMillis());
                    @SuppressLint("SimpleDateFormat") String date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                    //追加到StringBuilder中
                    sb.append("短信发送号码：" + mobile + "\n短信内容：" + content + "\n发送时间：" + date_time + "\n\n");

                }

                Message msg1 = new Message();
                msg1.what = RECEIVERED_MSG;
                msg1.obj = sb.toString();
                handler.sendMessage(msg1);
            }
        }
    }
}
package com.lcmf.xll.soeasy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class EasyService extends Service implements EasyTouchView.ServiceListener {

	private Intent mIntent;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		new EasyTouchView(this, this).initTouchViewEvent();
	}

	@Override
	public int onStartCommand(Intent intent,int flags, int startId) {
		mIntent = intent;
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void OnCloseService(boolean isClose)
	{
		stopService(mIntent);
	}
}

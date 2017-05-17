package com.lcmf.xll.eazytouch;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lcmf.xll.eazytouch.EazyTouchView.ServiceListener;
import android.support.annotation.Nullable;


/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class AuxiliaryService extends Service implements ServiceListener {
	/**
	 * Return the communication channel to the service.  May return null if
	 * clients can not bind to the service.  The returned
	 * {@link IBinder} is usually for a complex interface
	 * that has been <a href="{@docRoot}guide/components/aidl.html">described using
	 * aidl</a>.
	 * <p>
	 * <p><em>Note that unlike other application components, calls on to the
	 * IBinder interface returned here may not happen on the main thread
	 * of the process</em>.  More information about the main thread can be found in
	 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
	 * Threads</a>.</p>
	 *
	 * @param intent The Intent that was used to bind to this service,
	 *               as given to {@link Context#bindService
	 *               Context.bindService}.  Note that any extras that were included with
	 *               the Intent at that point will <em>not</em> be seen here.
	 * @return Return an IBinder through which clients can call on to the
	 * service.
	 */
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		new EasyTouchView(this, this).initTouchViewEvent();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mIntent = intent;
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void OnCloseService(boolean isClose) {
		stopService(mIntent);
	}
}

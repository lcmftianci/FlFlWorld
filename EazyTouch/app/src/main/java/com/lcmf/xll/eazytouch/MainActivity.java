package com.lcmf.xll.eazytouch;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import static android.R.attr.key;
import static android.support.v7.appcompat.R.id.screen;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		lockScreen();
	}

	private void lockScreen() {
		DevicePolicyManager mDevicePolicyManager;
		ComponentName mComponentName;

		mDevicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mComponentName = new ComponentName(this, LockReceiver.class);

		// 判断是否有权限
		if (mDevicePolicyManager.isAdminActive(mComponentName)) {
			mDevicePolicyManager.lockNow();
			finish();
		} else {
			activeManager(mComponentName);
		}
	}

	/**
	 * 激活设备管理器获取权限
	 */
	private void activeManager(ComponentName componentName) {
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, One key lock the screen);
		startActivity(intent);
		finish();
	}
}

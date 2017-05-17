package com.lcmf.xll.soeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	private int getLayoutResID(){
		return R.layout.activity_main;
	}

	private Button mShowViewButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//这是搞毛线啊
		setContentView(getLayoutResID());
		initEvent();
	}

	private void initEvent() {
		initViews();
		setViews();
	}

	private void setViews() {
		mShowViewButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startAuxiliaryService(null);
			}
		});
	}

	private void initViews() {
		mShowViewButton = (Button)findViewById(R.id.activity_main_show_touchview_button);
	}

	public void startAuxiliaryService(View v) {
		startService(new Intent(this, EasyService.class));
		// new TableShowView(this).fun(); 如果只是在activity中启动
		// 当activity跑去后台的时候[暂停态，或者销毁态] 我们设置的显示到桌面的view也会消失
		// 所以这里采用的是启动一个服务，服务中创建我们需要显示到table上的view，并将其注册到windowManager上
		finish();
	}
}

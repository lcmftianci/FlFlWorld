package com.lcmf.xll.servicedemo;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

	private TextView text;
	public static final int UPDATA_TEXT = 1;

	//创建Handler
	private Handler handler = new Handler(){
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
				case UPDATA_TEXT:
					//执行UI线程
					text.setText("CHNIM");
					break;
				default:
					break;
			}-
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button)findViewById(R.id.id_btn);
		btn.setOnClickListener(this);

		text = (TextView)findViewById(R.id.id_text);
	}
	/**
	 * Called when a view has been clicked.
	 *
	 * @param v The view that was clicked.
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.id_btn:
				new Thread(new Runnable() {
					@Override
					public void run() {
						Message msg = new Message();
						msg.what = UPDATA_TEXT;
						handler.sendMessage(msg);//将消息发送出去
					}
				}).start();
				break;
			default:
				break;
		}
	}
}

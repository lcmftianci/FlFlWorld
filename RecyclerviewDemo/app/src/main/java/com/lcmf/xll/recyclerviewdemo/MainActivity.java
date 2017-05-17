package com.lcmf.xll.recyclerviewdemo;

import android.app.DownloadManager;
import android.icu.text.RelativeDateTimeFormatter;
import android.service.voice.VoiceInteractionSession;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout mDrawerLayout;

	//创建list
	private Fruit[] fruits = {new Fruit("Apple", R.drawable.apple), new Fruit("Banana", R.drawable.banana), new Fruit("orange", R.drawable.orange),
	new Fruit("Pear", R.drawable.pear), new Fruit("Grape", R.drawable.grape), new Fruit("Watermelon", R.drawable.watermelon), new Fruit("Pineapple", R.drawable.pineapple)};

	private List<Fruit> fruitList = new ArrayList<>();
	private FruitAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initFruits();
		RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
		GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new FruitAdapter(fruitList);
		recyclerView.setAdapter(adapter);
		recyclerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}

	private void initFruits() {
		fruitList.clear();
		for(int i = 0; i < 50; i++)
		{
			Random random = new Random();
			int index = random.nextInt(fruits.length);
			fruitList.add(fruits[index]);
		}
	}
}

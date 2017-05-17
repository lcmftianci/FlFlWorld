package com.lcmf.xll.recyclerviewdemo;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class Fruit {
	private String name;
	private int imageId;

	public Fruit(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}

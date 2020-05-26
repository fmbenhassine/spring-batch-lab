package com.example.demo;

import java.util.List;

public class OuterBean {
	
	private List<MyBean> beans;

	public OuterBean(List<MyBean> beans) {
		this.beans = beans;
	}

	public void sayHello() {
		for (MyBean bean : beans) {
			System.out.println("bean = " + bean.getName());
		}
	}
}
package com.imudges.musicCalculator;

class MyStackDouble {
	private int maxSize;// 栈的最大容量
	private double[] ch; // 栈的数据
	private int top; // 栈头标记

	public MyStackDouble(int s) {
		maxSize = s;
		ch = new double[s];
		top = -1;
	}

	public void push(double c) {// 入栈
		ch[++top] = c;
	}

	public double pop() {// 出栈
		return ch[top--];
	}

	public double top() {
		return ch[top];
	}

	public boolean empty() {//判断是否为空
		return top <= -1;
	}

	public boolean isFull() {
		return top == (maxSize - 1);
	}

	public int size() {
		return top + 1;
	}

	public double get(int index) {
		return ch[index];
	}

	public void display(String str) {
		System.out.print(str);
		System.out.print(" Stack (bottom-->top): ");
		for (int i = 0; i < size(); i++) { 
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}
}

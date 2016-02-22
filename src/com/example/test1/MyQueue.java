package com.example.test1;

class MyQueue {
	private int maxSize;// 列的最大容量
	private char[] ch; // 列的数据
	public int top; // 列头标记
	private int trail;

	public MyQueue(int s) {
		maxSize = s;
		ch = new char[s];
		top = 0;
		trail=-1;
	}

	public void push(char c) {// 入列
		ch[++trail] = c;
	}

	public char pop() {// 出列
		return ch[++top];
	}

	public char top() {
		return ch[top];
	}

	public boolean empty() {//判断是否为空
		return trail <=top;
	}

	public boolean isFull() {
		return trail == (maxSize - 1);
	}

	public int size() {
		return trail -top;
	}

	public char get(int index) {
		return ch[index];
	}

	public void display(String str) {
		System.out.print(str);
		System.out.print(" Stack (bottom-->trail): ");
		for (int i = 0; i < size(); i++) { 
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}
}

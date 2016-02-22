package com.imudges.musicCalculator;

public class calculator {
	private char[] text=new char[100];
	private String txt;
	private MyStack sign;
	private MyStackDouble number;
	private MyQueue equation;
	public String getTxt() {
		return txt;
	}
	public void setText(String txt) {
		this.txt = txt;
	}
	public void start(String ttt) {
		this.setText(ttt);
		this.sign=new MyStack(500);
		this.number=new MyStackDouble(500);
		this.equation=new MyQueue(500);
		this.txt.getChars(0, this.txt.length(), this.text, 0);
	}
	public String  zoo(){
		return (""+number.top());
	}
	/**
	 * 得到符号的相对大小
	 * @return 返回相对大小
	 * */
	public int value(char size){
		if (size == '+' || size == '-')
			return 1;
		if (size == '*' || size == '%')
			return 2;
		if (size == '^')
			return 3;
		if (size == '#')
			return 4;
		return -1;
	}
	public void pretreatment(){//预处理，区分符号和减号，用#代替负号
		for (int i = 0; i < txt.length(); i++)
		{
			if (text[i] == '(')
			{
				int j = i;
				int c = 0;
				while (text[j] != ')')
				{
					j++;
					if ((text[j] == '+' || text[j] == '-' || text[j] == '*' || text[j] == '/' || text[j] == '^') && j!=i+1)
						c++;
				}
				if (c == 0)
				{
					text[i] = '@';
					text[j] = '@';
				}
			}
			if (text[i] == '-')
			{
				if (i == 0)
				{
					equation.push('#');
				}
				else if (text[i - 1] == ')' || text[i - 1] >= '0'&&text[i - 1] <= '9')
				{
					equation.push('-');
				}
				else{
					equation.push('#');
				}
			}
			else if (text[i] == '+' || text[i] == '*' || text[i] == '/' || text[i] == '^' || text[i] == '(' || text[i] == ')')
			{
				equation.push(text[i]);
			}
			else if (text[i] >= '0'&&text[i] <= '9' || text[i] == '.')
			{
				equation.push(text[i]);
			}
		}
		equation.push('!');
	}
	public int size(char i)
	{
		if (i == ')'){
			return 0;
		}
		if (i == '+' || i == '-'){
			return 1;
		}
		if (i == '*' || i == '/'){
			return 2;
		}
		if (i == '^'){
			return 3;
		}
		return -1;
	}
	void method_toDouble()//将队列中的数字字符变为double压入数字栈
	{
		double d = 0;
		double t = 0;
		double k = 1;
		while (equation.top() >= '0'&&equation.top() <= '9' || equation.top() == '.' || equation.top() == '#')
		{
			if (equation.top() == '#')
			{
				equation.pop();
				k = -1;
			}
			else{}
			if (equation.top() == '.')
			{
				t = 10;
				equation.pop();
			}
			else
			{
				if (t == 0)
				{
					d = d * 10 + ((double)equation.top() - 48);
					equation.pop();
				} 
				else
				{
					d = d + ((double)equation.top() - 48) / t;
					t *= 10;
					equation.pop();
				}
			}
		}
		number.push(d*k);
	}
	public double calc(double x1, double x2, char ch)
	{
		if (ch == '+')
		{
			return x2 + x1;
		}
		if (ch == '-')
		{
			return x2 - x1;
		}
		if (ch == '*')
		{
			return x2 * x1;
		}
		if (ch == '/')
		{
			return x2 / x1;
		}
		if (ch == '^')
		{
			return Math.pow(x2, x1);
		}
		return 0;
	}
	void method()
	{
		while (true)
		{
			if(equation.size()==0)
				{break;}
			
			if (equation.top() >= '0'&&equation.top() <= '9' || equation.top() == '#')
			{
				method_toDouble();
			}
			else
			{
				if (sign.empty() || sign.top() == '(')
				{
					sign.push(equation.top());
				}
				else if (size(equation.top()) > size(sign.top()))
				{
					sign.push(equation.top());
				}
				else if (equation.top() != ')')
				{
					while (sign.top() != '('&&size(equation.top()) <= size(sign.top()))
					{
						double x1 = number.top();
						number.pop();
						double x2 = number.top();
						number.pop();
						char ch = sign.top();
						sign.pop();
						number.push(calc(x1, x2, ch));
						if (sign.size() == 0)
							break;
					}
					sign.push(equation.top());
				}
				else//---------------------------------------------------------------------------------------------------
				{
					while (true)
					{
						double x1 = number.top();
						number.pop();
						double x2 = number.top();
						number.pop();
						char ch = sign.top();
						sign.pop();
						number.push(calc(x1, x2, ch));
						if (sign.top() == '(')
							break;
					}
					sign.pop();
				}
				equation.pop();
			}
		}
		while (true)
		{
			if (number.size() == 0 || sign.size() == 0)
				break;
			double x1 = number.top();
			number.pop();
			double x2 = number.top();
			number.pop();
			char ch = sign.top();
			sign.pop();
			number.push(calc(x1, x2, ch));
		}
		
	}
}
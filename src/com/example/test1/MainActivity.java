package com.example.test1;

import java.util.HashMap;



import android.app.Activity;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
private Button[] button=new Button[21];
private int[] id={0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18,R.id.button19,R.id.button20};
private String s;
private TextView text;
private SoundPool mysPool;
private HashMap<Integer,Integer> spMap; 
private calculator cal;
private int music=1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cal=new calculator();
		mysPool=new SoundPool(10,AudioManager.STREAM_MUSIC,0); 
        spMap = new HashMap<Integer,Integer>(); 
        loadingMusic();
		text=(TextView)findViewById(R.id.test);
		clickListenner();
		touchListenner();
	}
	public void loadingMusic()
	{
		spMap.put(1, mysPool.load(this, R.raw.a, 1));
		spMap.put(2, mysPool.load(this, R.raw.b, 1));
		spMap.put(3, mysPool.load(this, R.raw.c, 1));
		spMap.put(4, mysPool.load(this, R.raw.d, 1));
		spMap.put(5, mysPool.load(this, R.raw.e, 1));
		spMap.put(6, mysPool.load(this, R.raw.f, 1));
		spMap.put(7, mysPool.load(this, R.raw.g, 1));
		spMap.put(16, mysPool.load(this, R.raw.h, 1));
		spMap.put(17, mysPool.load(this, R.raw.i, 1));
		spMap.put(18, mysPool.load(this, R.raw.j, 1));
		spMap.put(19, mysPool.load(this, R.raw.k, 1));
		spMap.put(12, mysPool.load(this, R.raw.g1, 1));
		spMap.put(13, mysPool.load(this, R.raw.g2, 1));
		spMap.put(14, mysPool.load(this, R.raw.g3, 1));
		spMap.put(15, mysPool.load(this, R.raw.g4, 1));
		spMap.put(8, mysPool.load(this, R.raw.g5, 1));
		spMap.put(9, mysPool.load(this, R.raw.g6, 1));
		spMap.put(10, mysPool.load(this, R.raw.g7, 1));
		spMap.put(11, mysPool.load(this, R.raw.g8, 1));
	}
	public void clickListenner(){
		for(int i=1;i<=20;i++)
		{
			button[i]=(Button)findViewById(id[i]);
		}
		View.OnClickListener mylClickListener=new View.OnClickListener() {
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.button1:
					if(music==1)
						{
							music=0;
							button[1].setText("¡ð");
						}
					else if(music==0)
						{
							music=1;
							button[1].setText("¡ñ");
						}
					break;
				case R.id.button2:
					s=(String) text.getText();
					text.setText(s+"^");
					break;
				case R.id.button3:
					s=(String) text.getText();
					if(s.length()==0)
					{}else{
						s = s.substring(0,s.length()-1);
						text.setText(s);
					}
					break;
				case R.id.button4:
					text.setText("");
					break;
				case R.id.button5:
					s=(String) text.getText();
					text.setText(s+"7");
					break;
				case R.id.button6:
					s=(String) text.getText();
					text.setText(s+"8");
					break;
				case R.id.button7:
					s=(String) text.getText();
					text.setText(s+"9");
					break;
				case R.id.button8:
					s=(String) text.getText();
					text.setText(s+"/");
					break;
				case R.id.button9:
					s=(String) text.getText();
					text.setText(s+"4");
					break;
				case R.id.button10:
					s=(String) text.getText();
					text.setText(s+"5");
					break;
				case R.id.button11:
					s=(String) text.getText();
					text.setText(s+"6");
					break;
				case R.id.button12:
					s=(String) text.getText();
					text.setText(s+"*");
					break;
				case R.id.button13:
					s=(String) text.getText();
					text.setText(s+"1");
					break;
				case R.id.button14:
					s=(String) text.getText();
					text.setText(s+"2");
					break;
				case R.id.button15:
					s=(String) text.getText();
					text.setText(s+"3");
					break;
				case R.id.button16:
					s=(String) text.getText();
					text.setText(s+"-");
					break;
				case R.id.button17:
					s=(String) text.getText();
					if(text.getText()=="")
						text.setText("0");
					s=(String) text.getText();
					text.setText(s+".");
					break;
				case R.id.button18:
					s=(String) text.getText();
					text.setText(s+"0");
					break;
				case R.id.button19:
					s=(String) text.getText();
					try {
						cal.start(s);
					cal.pretreatment();
					cal.method();
					s=cal.zoo();
					text.setText(""+s);
					} catch (Exception e) {
						text.setText("Error!\nÄãÊÖ»¬ÁË°É¡£¡£¡£");
					}
					break;
				case R.id.button20:
					s=(String) text.getText();
					text.setText(s+"+");
					break;
				default:
					break;
				}
			}
		};
		for(int i=1;i<=20;i++)
		{
			button[i].setOnClickListener(mylClickListener);
		}
	}
	public void touchListenner(){
		View.OnTouchListener mytTouchListener=new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				switch (v.getId()) {
				case R.id.button1:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(1);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(1);}  
					break;
				case R.id.button2:
					if(event.getAction() == MotionEvent.ACTION_UP){   Ushow(2);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){  show(2);}  
					break;
				case R.id.button3:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(3);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(3);}  
					break;
				case R.id.button8:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(8);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(8);}  
					break;
				case R.id.button12:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(12);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){  show(12);}  
					break;
				case R.id.button16:
					if(event.getAction() == MotionEvent.ACTION_UP){   Ushow(16);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(16);}  
					break;
				case R.id.button17:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(17);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){  show(17);}  
					break;
				case R.id.button19:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(19);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(19);}  
					break;
				case R.id.button20:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(20);}   
		            if(event.getAction() == MotionEvent.ACTION_DOWN){  show(20);}  
					break;
				case R.id.button5:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(5);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(5);}  
		            break;
				case R.id.button6:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(6);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(6);}  
		            break;
				case R.id.button7:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(7);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(7);}  
		            break;
				case R.id.button9:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(9);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(9);}  
		            break;
				case R.id.button10:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(10);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(10);}  
		            break;
				case R.id.button11:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(11);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(11);}  
		            break;
				case R.id.button13:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(13);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(13);}  
		            break;
				case R.id.button14:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(14);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){ show(14);}  
		            break;
				case R.id.button15:
					if(event.getAction() == MotionEvent.ACTION_UP){  Ushow(15);}  
		            if(event.getAction() == MotionEvent.ACTION_DOWN){show(15);}  
		            break;
				case R.id.button18:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(18); } 
		            if(event.getAction() == MotionEvent.ACTION_DOWN){show(18);}  
		            break;
				case R.id.button4:
					if(event.getAction() == MotionEvent.ACTION_UP){ Ushow(4); } 
		            if(event.getAction() == MotionEvent.ACTION_DOWN){show(4);}  
		            break;
				default:
					break;
				}
				return false;
			}
		};
		for(int i=1;i<=20;i++)
		{
			button[i].setOnTouchListener(mytTouchListener);
		}
	}
	public void show(int i)
	{
		if(i>1&&music==1)
			playSounds(i-1,1);
		int s,x,z,y;
		s=x=z=y=i;
		int r=(int)(Math.random()*135+120);
		int g=(int)(Math.random()*135+120);
		int b=(int)(Math.random()*135+120);
		for(int j=0;j<5;j++)
		{
			if (s>=1&&s<=20)
			{
				button[s].setBackgroundColor(Color.rgb(r, g, b));
				s-=4;
			}
			if(x>=1&&x<=20)
			{
				button[x].setBackgroundColor(Color.rgb(r, g, b));
				x+=4;
			}
			if((z-1)/4==(i-1)/4&&z>0)
			{
				button[z].setBackgroundColor(Color.rgb(r, g, b));
				z-=1;
			}
			if((y-1)/4==(i-1)/4&&y>0)
			{
				button[y].setBackgroundColor(Color.rgb(r, g, b));
				y+=1;
			}
			r-=30;
			g-=30;
			b-=30;
		}
	}
	public void Ushow(int i){
		int s,x,z,y;
		s=x=z=y=i;
		for(int j=0;j<5;j++)
		{
			if (s>=1&&s<=20)
			{
				button[s].setBackgroundColor(Color.rgb(55, 61, 67));
				s-=4;
			}
			if(x>=1&&x<=20)
			{
				button[x].setBackgroundColor(Color.rgb(55, 61, 67));
				x+=4;
			}
			if((z-1)/4==(i-1)/4&&z>0)
			{
				button[z].setBackgroundColor(Color.rgb(55, 61, 67));
				z-=1;
			}
			if((y-1)/4==(i-1)/4&&y>0)
			{
				button[y].setBackgroundColor(Color.rgb(55, 61, 67));
				y+=1;
			}
		}
	}
	public void playSounds(int sound, int number){ 
	        AudioManager am = (AudioManager)this.getSystemService(this.AUDIO_SERVICE); 
	        float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC); 
	        float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC); 
	        float volumnRatio = audioCurrentVolumn/audioMaxVolumn; 
	         
	        mysPool.play(spMap.get(sound), volumnRatio, volumnRatio, 1, number, 1); 
	    }
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

package com.imudges.musicCalculator;

import android.R.bool;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class about_us extends Activity {
	
	private static Toast mToast;

	private Button about_us_button[]=new Button[5];
	private int[] about_us_id ={R.id.about_us_button0,R.id.about_us_button1,R.id.about_us_button2};
	private TextView ttte;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.about_us); 
        
        ActionBar about_us_bar =getActionBar();
        about_us_bar.setTitle("¹ØÓÚ");
        
        
        touchListenner();
        clickListenner();
    }
    
    public void clickListenner(){
    	View.OnClickListener mycClickListener2=new View.OnClickListener() {
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.about_us_button0:
					Intent intent1 = new Intent();
		            intent1.setClass(about_us.this, Thanks.class);
		            startActivity(intent1);
					break;
				case R.id.about_us_button1:
					Intent intent2 = new Intent();
		            intent2.setClass(about_us.this, help.class);
		            startActivity(intent2);
					break;
				case R.id.about_us_button2:
					Intent intent3 = new Intent();
		            intent3.setClass(about_us.this, author_information.class);
		            startActivity(intent3);
					break;
				
				default:
					break;
				}
				
			}
		};
		for(int i=0;i<=2;i++)
		{
			about_us_button[i].setOnClickListener(mycClickListener2);
		}
    }
    
    public void touchListenner(){
    	for(int i=0;i<=2;i++)
		{
			about_us_button[i]=(Button)findViewById(about_us_id[i]);
		}
    	
    };
}
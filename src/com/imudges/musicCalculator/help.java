package com.imudges.musicCalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


public class help extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		 ActionBar about_us_bar =getActionBar();
	        about_us_bar.setTitle("°ïÖú");
	}
}

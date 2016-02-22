package com.imudges.musicCalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class author_information extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.author_information);
		
		 ActionBar about_us_bar =getActionBar();
	        about_us_bar.setTitle("关于作者");
	}
}

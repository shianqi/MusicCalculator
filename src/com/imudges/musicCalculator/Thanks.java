package com.imudges.musicCalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


public class Thanks extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thanks);
		
		ActionBar thanks_bar =getActionBar();
        thanks_bar.setTitle("°²È«Ô¤·À");
	}
}

package com.imudges.musicCalculator;

import com.imudges.musicCalculator.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * 
 * @{# SplashActivity.java Create on 2013-5-2 下午9:10:01
 * 
 *     class desc: 启动画面 (1)判断是否是首次加载应�?--采取读取SharedPreferences的方�?
 *     (2)是，则进入GuideActivity；否，则进入MainActivity (3)3s后执�?(2)操作
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>
 * 
 * 
 */
public class SplashActivity extends Activity {
	boolean isFirstIn = false;

	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;
	// 延迟3�?
	private static final long SPLASH_DELAY_MILLIS = 2000;

	private static final String SHAREDPREFERENCES_NAME = "first_pref";

	/**
	 * Handler:跳转到不同界�?
	 */
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				goGuide();
				break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		init();
	}

	private void init() {
		// 读取SharedPreferences中需要的数据
		// 使用SharedPreferences来记录程序的使用次数
		SharedPreferences preferences = getSharedPreferences(
				SHAREDPREFERENCES_NAME, MODE_PRIVATE);

		// 取得相应的�?�，如果没有该�?�，说明还未写入，用true作为默认�?
		isFirstIn = preferences.getBoolean("isFirstIn", true);

		// 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
		if (!isFirstIn) {
			// 使用Handler的postDelayed方法�?3秒后执行跳转到MainActivity
			mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
		}

	}

	private void goHome() {
		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
	}

	private void goGuide() {
		Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
	}
}

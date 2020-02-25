package com.menha.scews;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;

public class WelcomeArActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean connected = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private ProgressBar progressbar1;
	private TextView textview1;
	private TextView textview2;
	
	private TimerTask t;
	private Intent i = new Intent();
	private MediaPlayer mp;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.welcome_ar);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
	}
	private void initializeLogic() {
		if (sp.getString("Language", "").equals("")) {
			sp.edit().putString("Language", "en").commit();
		}
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						i.setClass(getApplicationContext(), HomepageArActivity.class);
						startActivity(i);
						finish();
					}
				});
			}
		};
		_timer.schedule(t, (int)(4000));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			String uri = "com.menha.scews";
			android.content.pm.PackageManager pm = getPackageManager(); try { android.content.pm.PackageInfo pInfo = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); String version = pInfo.versionName;textview1.setText("الإصدار: ".concat(version)); textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1); } catch (android.content.pm.PackageManager.NameNotFoundException e) { }
			textview2.setText("مؤسسة تكريم ");
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			mp = MediaPlayer.create(getApplicationContext(), R.raw.welcome_ar);
			mp.start();
		}
		if (sp.getString("Language", "").equals("en")) {
			String uri = "com.menha.scews";
			android.content.pm.PackageManager pm = getPackageManager(); try { android.content.pm.PackageInfo pInfo = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); String version = pInfo.versionName;textview1.setText("Version: ".concat(version)); textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1); } catch (android.content.pm.PackageManager.NameNotFoundException e) { }
			textview2.setText("TaqRim Foundation");
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			mp = MediaPlayer.create(getApplicationContext(), R.raw.welcome_en);
			mp.start();
		}
		if (sp.getString("Language", "").equals("bn")) {
			String uri = "com.menha.scews";
			android.content.pm.PackageManager pm = getPackageManager(); try { android.content.pm.PackageInfo pInfo = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); String version = pInfo.versionName;textview1.setText("সংস্করণ: ".concat(version)); textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0); textview1.setTextSize((float)21); } catch (android.content.pm.PackageManager.NameNotFoundException e) { }
			textview2.setText("তাকরিম ফাউন্ডেশন");
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview2.setTextSize((float)15);
			mp = MediaPlayer.create(getApplicationContext(), R.raw.welcome_en);
			mp.start();
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mp.release();
	}
	private void _networkConnected () {
		//Needs RequestNetwork to work!
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		connected = (netInfo != null && netInfo.isConnectedOrConnecting());
		if (connected) {
			
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Turn on your internet and try again!");
			finish();
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}

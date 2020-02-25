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
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
	
	
	private boolean connected = false;
	
	private LinearLayout main;
	private LinearLayout linear_heading;
	private LinearLayout linear_choose_lang;
	private LinearLayout linear_lang_button;
	private LinearLayout linear_app_version;
	private TextView textview_heading;
	private TextView txt_chos_lang_en_ar;
	private TextView txt_chos_lang_bn;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview_ar;
	private ImageView imageview_en;
	private ImageView imageview_bn;
	private TextView textview_app_version;
	
	private Intent i = new Intent();
	private SharedPreferences test;
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		main = (LinearLayout) findViewById(R.id.main);
		linear_heading = (LinearLayout) findViewById(R.id.linear_heading);
		linear_choose_lang = (LinearLayout) findViewById(R.id.linear_choose_lang);
		linear_lang_button = (LinearLayout) findViewById(R.id.linear_lang_button);
		linear_app_version = (LinearLayout) findViewById(R.id.linear_app_version);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		txt_chos_lang_en_ar = (TextView) findViewById(R.id.txt_chos_lang_en_ar);
		txt_chos_lang_bn = (TextView) findViewById(R.id.txt_chos_lang_bn);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview_ar = (ImageView) findViewById(R.id.imageview_ar);
		imageview_en = (ImageView) findViewById(R.id.imageview_en);
		imageview_bn = (ImageView) findViewById(R.id.imageview_bn);
		textview_app_version = (TextView) findViewById(R.id.textview_app_version);
		test = getSharedPreferences("abcd", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		req = new RequestNetwork(this);
		
		imageview_ar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("Language", "ar").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), WelcomeArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		imageview_en.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("Language", "en").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), WelcomeArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		imageview_bn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("Language", "bn").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), WelcomeArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	private void initializeLogic() {
		_net_check();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _net_check () {
		//Needs RequestNetwork to work!
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		connected = (netInfo != null && netInfo.isConnectedOrConnecting());
		if (connected) {
			if (!test.getString("view", "").contains("ok")) {
				test.edit().putString("view", "ok").commit();
			}
			else {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), SimpleActivity.class);
				startActivity(i);
				finish();
			}
			String uri = "com.menha.scews";
			android.content.pm.PackageManager pm = getPackageManager(); try { android.content.pm.PackageInfo pInfo = pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); String version = pInfo.versionName;textview_app_version.setText("Version: ".concat(version)); } catch (android.content.pm.PackageManager.NameNotFoundException e) { }
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			txt_chos_lang_en_ar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			txt_chos_lang_bn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_app_version.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
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

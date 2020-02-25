package com.menha.scews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class UniSelectContryArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private LinearLayout linear_scroll;
	private TextView textview1;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private Button saudi;
	private Button qatar;
	private Button turkey;
	private Button dubai;
	private Button egypt;
	private Button brunei;
	private Button malaysia;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.uni_select_contry_ar);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear_main = (LinearLayout) findViewById(R.id.linear_main);
		linear_heading = (LinearLayout) findViewById(R.id.linear_heading);
		linear_scroll = (LinearLayout) findViewById(R.id.linear_scroll);
		textview1 = (TextView) findViewById(R.id.textview1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		saudi = (Button) findViewById(R.id.saudi);
		qatar = (Button) findViewById(R.id.qatar);
		turkey = (Button) findViewById(R.id.turkey);
		dubai = (Button) findViewById(R.id.dubai);
		egypt = (Button) findViewById(R.id.egypt);
		brunei = (Button) findViewById(R.id.brunei);
		malaysia = (Button) findViewById(R.id.malaysia);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		
		saudi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), SaudiArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		qatar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), QatarArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		turkey.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), TurkeyArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		dubai.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		egypt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		brunei.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), BruneiArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		malaysia.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	private void initializeLogic() {
		dubai.setVisibility(View.GONE);
		egypt.setVisibility(View.GONE);
		malaysia.setVisibility(View.GONE);
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
	public void onBackPressed() {
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		i.setClass(getApplicationContext(), HomepageArActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			textview1.setText("الرجاء إختيار البلد");
			saudi.setText("المملكة العربية السعودية");
			qatar.setText("دولة قطر");
			turkey.setText("جمهورية التركيا");
			dubai.setText("الإمارات العربية المتحدة");
			egypt.setText("جمهورية مصر العربية");
			brunei.setText("اتحاد بروناي دار السلام");
			malaysia.setText("ماليزيا");
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			saudi.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			qatar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			turkey.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			dubai.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			egypt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			brunei.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			malaysia.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			for(int i = 0; i < _toolbar.getChildCount(); i++){
				
				View view = _toolbar.getChildAt(i);
				
				if(view instanceof TextView){
					TextView tv = (TextView) view;
					
					getSupportActionBar().setTitle("سكيوس - أخبار المنح الدراسية");{
						
						tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
						
						break;
					}
				}}
		}
		if (sp.getString("Language", "").equals("en")) {
			textview1.setText("Please select country");
			saudi.setText("Kingdom of Saudi Arabia");
			qatar.setText("State of Qatar");
			turkey.setText("Republic of Turkey");
			dubai.setText("United Arab Emirates");
			egypt.setText("Arab Republic of Egypt");
			brunei.setText("Nation of Brunei, the Abode of Peace");
			malaysia.setText("Malaysia");
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			saudi.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			qatar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			turkey.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			dubai.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			egypt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			brunei.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			malaysia.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			brunei.setTextSize((float)18);
			for(int i = 0; i < _toolbar.getChildCount(); i++){
				
				View view = _toolbar.getChildAt(i);
				
				if(view instanceof TextView){
					TextView tv = (TextView) view;
					
					if(tv.getText().equals(_toolbar.getTitle())){
						
						tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
						
						break;
					}
				}}
		}
		if (sp.getString("Language", "").equals("bn")) {
			textview1.setText("দেশ নির্বাচন করুন");
			saudi.setText("সৌদি আরব সম্রাজ্য");
			qatar.setText("কাতার রাষ্ট্র");
			turkey.setText("তুরস্ক প্রজাতন্ত্র");
			dubai.setText("সংযুক্ত আরব আমিরাত");
			egypt.setText("মিশর আরব প্রজাতন্ত্র");
			brunei.setText("ব্রুনাই, শান্তির আবাস");
			malaysia.setText("মালয়েশিয়া");
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			saudi.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			qatar.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			turkey.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			dubai.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			egypt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			brunei.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			malaysia.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview1.setTextSize((float)30);
			saudi.setTextSize((float)25);
			qatar.setTextSize((float)25);
			turkey.setTextSize((float)25);
			dubai.setTextSize((float)25);
			egypt.setTextSize((float)25);
			brunei.setTextSize((float)25);
			malaysia.setTextSize((float)25);
			for(int i = 0; i < _toolbar.getChildCount(); i++){
				
				View view = _toolbar.getChildAt(i);
				
				if(view instanceof TextView){
					TextView tv = (TextView) view;
					
					getSupportActionBar().setTitle("স্কিউস - শিক্ষাবৃত্তির খবরাখবর");{
						
						tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
						tv.setTextSize((float)25);
						
						break;
					}
				}}
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

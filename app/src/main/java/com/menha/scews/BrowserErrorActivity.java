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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class BrowserErrorActivity extends AppCompatActivity {
	
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private ScrollView vscroll1;
	private TextView textview_heading;
	private LinearLayout linear_error;
	private ImageView imageview1;
	private TextView textview1;
	private Button button_try;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences spbr;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.browser_error);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear_main = (LinearLayout) findViewById(R.id.linear_main);
		linear_heading = (LinearLayout) findViewById(R.id.linear_heading);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		linear_error = (LinearLayout) findViewById(R.id.linear_error);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		button_try = (Button) findViewById(R.id.button_try);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		spbr = getSharedPreferences("Browser", Activity.MODE_PRIVATE);
		req = new RequestNetwork(this);
		
		button_try.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				req.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "a", _req_request_listener);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), BrowserActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	private void initializeLogic() {
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
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			SketchwareUtil.showMessage(getApplicationContext(), "خطأ!");
			textview_heading.setText("خطأ!");
			textview1.setText("الأسباب المحتملة (على سبيل المثال لا الحصر):\n\n• يستغرق الخادم وقتًا طويلاً للتحميل.\n• قد يكون الموقع غير متاح مؤقتًا.\n• قد يكون الموقع مشغولا.\n\nإذا لم تتمكن من تحميل أي صفحات ، فتحقق من اتصال الشبكة أو واي-فاي وحاول مرة أخرى في غضون لحظات قليلة.");
			button_try.setText("حاول مجددا");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_try.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
		}
		if (sp.getString("Language", "").equals("en")) {
			SketchwareUtil.showMessage(getApplicationContext(), "ERROR!");
			textview_heading.setText("ERROR!");
			textview1.setText("Possible causes (but not limited to) are:\n\n• The server is taking too much time to respond.\n• The site could be temporarily unavailable.\n• The site could be busy.\n\nIf you are unable to load any pages, check your Data or Wi-Fi connection and Try again in a few moments.");
			button_try.setText("Try again");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_try.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
		}
		if (sp.getString("Language", "").equals("bn")) {
			SketchwareUtil.showMessage(getApplicationContext(), "এরর!");
			textview_heading.setText("এরর!");
			textview1.setText("সম্ভাব্য কারণ সমূহ (তবে শুধু এগুলোই নয়):\n\n• সার্ভার লোড হতে খুব বেশি সময় নিচ্ছে।\n• সাইটটি সাময়িকভাবে অপ্রাপ্য হতে পারে।\n• সাইটটি ব্যস্ত হতে পারে।\n\nআপনি যদি কোনও পৃষ্ঠা লোড করতে না পারেন তবে আপনার ডেটা বা ওয়াই-ফাই সংযোগটি পরিক্ষা করুন এবং একটু পর আবার চেষ্টা করুন।");
			button_try.setText("আবার চেষ্টা করুন");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_try.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)30);
			textview1.setTextSize((float)19);
			button_try.setTextSize((float)23);
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

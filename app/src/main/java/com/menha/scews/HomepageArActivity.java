package com.menha.scews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.HashMap;
import android.view.View;
import android.graphics.Typeface;

public class HomepageArActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	private String title_n = "";
	private String message_n = "";
	
	private LinearLayout linear_main;
	private LinearLayout linear1;
	private TextView textview1;
	private Button running;
	private Button universities;
	private Button news;
	private Button need2know;
	private LinearLayout _drawer_linear1;
	private Button _drawer_main;
	private Button _drawer_update;
	private Button _drawer_share;
	private Button _drawer_about;
	private Button _drawer_apply_by_us;
	
	private Intent i = new Intent();
	private Intent in = new Intent();
	private AlertDialog.Builder dn;
	private SharedPreferences data;
	private DatabaseReference n = _firebase.getReference("n");
	private ChildEventListener _n_child_listener;
	private SharedPreferences sp;
	private SharedPreferences test;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.homepage_ar);
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
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomepageArActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		linear_main = (LinearLayout) findViewById(R.id.linear_main);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		running = (Button) findViewById(R.id.running);
		universities = (Button) findViewById(R.id.universities);
		news = (Button) findViewById(R.id.news);
		need2know = (Button) findViewById(R.id.need2know);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_main = (Button) _nav_view.findViewById(R.id.main);
		_drawer_update = (Button) _nav_view.findViewById(R.id.update);
		_drawer_share = (Button) _nav_view.findViewById(R.id.share);
		_drawer_about = (Button) _nav_view.findViewById(R.id.about);
		_drawer_apply_by_us = (Button) _nav_view.findViewById(R.id.apply_by_us);
		dn = new AlertDialog.Builder(this);
		data = getSharedPreferences("n", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		test = getSharedPreferences("abcd", Activity.MODE_PRIVATE);
		
		running.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), RunningApplyArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		universities.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), UniSelectContryArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		news.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), NewsArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		need2know.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Need2knowArActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_n_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				title_n = _childValue.get("Title").toString();
				message_n = _childValue.get("Message").toString();
				if (!data.getString("data", "").equals(_childValue.get("Message").toString())) {
					dn.setTitle(title_n);
					dn.setMessage(message_n);
					dn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							data.edit().putString("data", message_n).commit();
						}
					});
					dn.setCancelable(false);
					dn.create().show();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				title_n = _childValue.get("Title").toString();
				message_n = _childValue.get("Message").toString();
				if (!data.getString("data", "").equals(_childValue.get("Message").toString())) {
					dn.setTitle(title_n);
					dn.setMessage(message_n);
					dn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							data.edit().putString("data", message_n).commit();
						}
					});
					dn.setCancelable(false);
					dn.create().show();
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		n.addChildEventListener(_n_child_listener);
		
		_drawer_main.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				test.edit().remove("view").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_drawer_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.menha.scews"));
				startActivity(i);
			}
		});
		
		_drawer_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), AppShareArActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				test.edit().putString("abcd", "Details").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), AboutUsArActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_apply_by_us.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				test.edit().putString("abcd", "Contact").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), AboutUsArActivity.class);
				startActivity(i);
			}
		});
	}
	private void initializeLogic() {
		textview1.setText("https://play.google.com/store/apps/details?id=com.menha.scews");
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
			running.setText("التقديم الجاري");
			universities.setText("الجامعات والتقديم");
			news.setText("لوحة الإعلان المهمة");
			need2know.setText("العلم الضروري");
			running.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			universities.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			news.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			need2know.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_main.setText("اللغة");
			_drawer_about.setText("المعلومات عنا");
			_drawer_apply_by_us.setText("الاتصال للتسجيل");
			_drawer_share.setText("مشاركة التطبيق");
			_drawer_update.setText("تحديث التطبيق");
			_drawer_main.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_apply_by_us.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_update.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			running.setText("Ongoing Application");
			universities.setText("Universities & Application");
			news.setText("Important Notice");
			need2know.setText("Need to Know");
			running.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			universities.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			news.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			need2know.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_main.setText("Language");
			_drawer_about.setText("About Us");
			_drawer_apply_by_us.setText("Contact for Apply");
			_drawer_share.setText("Share the App");
			_drawer_update.setText("App Update");
			_drawer_main.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_apply_by_us.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			_drawer_update.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			running.setText("চলমান আবেদন");
			universities.setText("বিশ্ববিদ্যালয় এবং আবেদন");
			news.setText("জরুরি বিজ্ঞপ্তি");
			need2know.setText("জেনে রাখা ভালো");
			running.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			universities.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			news.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			need2know.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			running.setTextSize((float)30);
			universities.setTextSize((float)30);
			news.setTextSize((float)30);
			need2know.setTextSize((float)30);
			_drawer_main.setText("ভাষা");
			_drawer_about.setText("আমাদের সম্পর্কে");
			_drawer_apply_by_us.setText("আবেদনের জন্য যোগাযোগ");
			_drawer_share.setText("অ্যাপটি শেয়ার করুন");
			_drawer_update.setText("অ্যাপ হালনাগাদ");
			_drawer_main.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			_drawer_about.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			_drawer_apply_by_us.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			_drawer_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			_drawer_update.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			_drawer_main.setTextSize((float)23);
			_drawer_about.setTextSize((float)23);
			_drawer_apply_by_us.setTextSize((float)23);
			_drawer_share.setTextSize((float)23);
			_drawer_update.setTextSize((float)23);
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
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
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

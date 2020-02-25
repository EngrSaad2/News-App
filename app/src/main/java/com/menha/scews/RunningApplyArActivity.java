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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Typeface;

public class RunningApplyArActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private String a = "";
	
	private ArrayList<HashMap<String, Object>> m = new ArrayList<>();
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private TextView share_linkk;
	private LinearLayout linear_frbs_running;
	private TextView textview_heading;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView loading;
	private Button share;
	
	private Intent i = new Intent();
	private RequestNetwork n;
	private RequestNetwork.RequestListener _n_request_listener;
	private DatabaseReference running_apply_ar = _firebase.getReference("running_apply_ar");
	private ChildEventListener _running_apply_ar_child_listener;
	private SharedPreferences sp;
	private DatabaseReference running_apply_en = _firebase.getReference("running_apply_en");
	private ChildEventListener _running_apply_en_child_listener;
	private DatabaseReference running_apply_bn = _firebase.getReference("running_apply_bn");
	private ChildEventListener _running_apply_bn_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.running_apply_ar);
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
		share_linkk = (TextView) findViewById(R.id.share_linkk);
		linear_frbs_running = (LinearLayout) findViewById(R.id.linear_frbs_running);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		loading = (TextView) findViewById(R.id.loading);
		share = (Button) findViewById(R.id.share);
		n = new RequestNetwork(this);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("Language", "").equals("ar")) {
					a = loading.getText().toString().concat("\n\n\n\n\nللحصول على التطبيق: ".concat(share_linkk.getText().toString()));
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"مشاركة عبر"));
					SketchwareUtil.showMessage(getApplicationContext(), "نقل");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", loading.getText().toString().concat("\n\n\n\n\nللحصول على التطبيق: ".concat(share_linkk.getText().toString()))));
				}
				if (sp.getString("Language", "").equals("en")) {
					a = loading.getText().toString().concat("\n\n\n\n\nTo get the app: ".concat(share_linkk.getText().toString()));
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"Share via"));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", loading.getText().toString().concat("\n\n\n\n\nTo get the app: ".concat(share_linkk.getText().toString()))));
				}
				if (sp.getString("Language", "").equals("bn")) {
					a = loading.getText().toString().concat("\n\n\n\n\nঅ্যাপটি পেতে: ".concat(share_linkk.getText().toString()));
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"শেয়ার করুন"));
					SketchwareUtil.showMessage(getApplicationContext(), "কপি করা হয়েছে");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", loading.getText().toString().concat("\n\n\n\n\nঅ্যাপটি পেতে: ".concat(share_linkk.getText().toString()))));
				}
			}
		});
		
		_n_request_listener = new RequestNetwork.RequestListener() {
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
		
		_running_apply_ar_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		running_apply_ar.addChildEventListener(_running_apply_ar_child_listener);
		
		_running_apply_en_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		running_apply_en.addChildEventListener(_running_apply_en_child_listener);
		
		_running_apply_bn_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		running_apply_bn.addChildEventListener(_running_apply_bn_child_listener);
	}
	private void initializeLogic() {
		if (sp.getString("Language", "").equals("ar")) {
			running_apply_ar.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					m = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							m.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					loading.setText(m.get((int)0).get("running_apply_ar").toString());
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
		if (sp.getString("Language", "").equals("en")) {
			running_apply_en.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					m = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							m.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					loading.setText(m.get((int)0).get("running_apply_en").toString());
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
		if (sp.getString("Language", "").equals("bn")) {
			running_apply_bn.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					m = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							m.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					loading.setText(m.get((int)0).get("running_apply_bn").toString());
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
		share_linkk.setText("https://play.google.com/store/apps/details?id=com.menha.scews");
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
			textview_heading.setText("التقديم الجاري");
			share.setText("المشاركة");
			share_linkk.setText(share_linkk.getText().toString());
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			loading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("Ongoing Application");
			share.setText("Share");
			share_linkk.setText(share_linkk.getText().toString());
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			loading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("চলমান আবেদন");
			share.setText("শেয়ার");
			share_linkk.setText(share_linkk.getText().toString());
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			loading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)30);
			share.setTextSize((float)21);
			loading.setTextSize((float)23);
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

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
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Typeface;

public class AppShareArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	private String a = "";
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private TextView share_linkk;
	private LinearLayout linear_button;
	private TextView textview_heading;
	private Button button_apk_share;
	private Button button_link_share;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.app_share_ar);
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
		linear_button = (LinearLayout) findViewById(R.id.linear_button);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		button_apk_share = (Button) findViewById(R.id.button_apk_share);
		button_link_share = (Button) findViewById(R.id.button_link_share);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		
		button_apk_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("Language", "").equals("ar")) {
					shareApplicationa();
				}
				if (sp.getString("Language", "").equals("en")) {
					shareApplicatione();
				}
				if (sp.getString("Language", "").equals("bn")) {
					shareApplicationb();
				}
			}
		});
		
		button_link_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("Language", "").equals("ar")) {
					a = "للحصول على التطبيق: ".concat(share_linkk.getText().toString());
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"مشاركة عبر"));
					SketchwareUtil.showMessage(getApplicationContext(), "نقل");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "للحصول على التطبيق: ".concat(share_linkk.getText().toString())));
				}
				if (sp.getString("Language", "").equals("en")) {
					a = "To get the app: ".concat(share_linkk.getText().toString());
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"Share via"));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "To get the app: ".concat(share_linkk.getText().toString())));
				}
				if (sp.getString("Language", "").equals("bn")) {
					a = "অ্যাপটি পেতে: ".concat(share_linkk.getText().toString());
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"শেয়ার করুন"));
					SketchwareUtil.showMessage(getApplicationContext(), "কপি করা হয়েছে");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "অ্যাপটি পেতে: ".concat(share_linkk.getText().toString())));
				}
			}
		});
	}
	private void initializeLogic() {
		button_apk_share.setVisibility(View.GONE);
			StrictMode.VmPolicy.Builder builder = 
				new StrictMode.VmPolicy.Builder(); 
				StrictMode.setVmPolicy(builder.build());
				if(Build.VERSION.SDK_INT>=24){ 
					    try{
								java.lang.reflect.Method m = 
						        StrictMode.class.getMethod(
								"disableDeathOnFileUriExposure"); 
						        m.invoke(null); 
							}
						catch(Exception e){ 
								showMessage(e.toString()); 
							} 
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
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			textview_heading.setText("مشاركة التطبيق");
			button_apk_share.setText("مشاركة نسخة APK");
			button_link_share.setText("مشاركة رابط APK");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_apk_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_link_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("App Share");
			button_apk_share.setText("Share APK file");
			button_link_share.setText("Share APK Link");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_apk_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_link_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("অ্যাপ শেয়ার");
			button_apk_share.setText("APK ফাইল শেয়ার");
			button_link_share.setText("APK লিংক শেয়ার");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_apk_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_link_share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)30);
			button_apk_share.setTextSize((float)23);
			button_link_share.setTextSize((float)23);
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
	private void _share_ar () {
	}
	private void shareApplicationa() { 
						android.content.pm.ApplicationInfo app = 
						getApplicationContext().getApplicationInfo(); 
						String filePath = app.sourceDir;
						Intent i = new Intent(Intent.ACTION_SEND); 
						i.setType("*/*"); 
						java.io.File originalApk = new java.io.File(filePath); 
						try {  
								java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
						 		if (!tempFile.isDirectory()) 
									if (!tempFile.mkdirs()) 
									return; 
									tempFile = new java.io.File(tempFile.getPath() + "/" + 
									"scEWS - Scholarship News.apk");
									if (!tempFile.exists()) 
										{
											try{
													if (!tempFile.createNewFile()) { 
															return; }
												}
											catch (java.io.IOException e){} 
										} 
									java.io.InputStream in = new java.io.FileInputStream (originalApk);
									java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
									byte[] buf = new byte[1024];
									int len; 
									while ((len = in.read(buf)) > 0) { 
												out.write(buf, 0, len); 
									} 
									in.close(); 
									out.close(); 
									i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
									startActivity(Intent.createChooser(i, "مشاركة APK عبر"));
						} 
						catch (java.io.IOException e) 
						{ showMessage(e.toString()); 
						} 
			}
	{
	}
	
	
	private void _share_en () {
	}
	private void shareApplicatione() { 
						android.content.pm.ApplicationInfo app = 
						getApplicationContext().getApplicationInfo(); 
						String filePath = app.sourceDir;
						Intent i = new Intent(Intent.ACTION_SEND); 
						i.setType("*/*"); 
						java.io.File originalApk = new java.io.File(filePath); 
						try {  
								java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
						 		if (!tempFile.isDirectory()) 
									if (!tempFile.mkdirs()) 
									return; 
									tempFile = new java.io.File(tempFile.getPath() + "/" + 
									"scEWS - Scholarship News.apk");
									if (!tempFile.exists()) 
										{
											try{
													if (!tempFile.createNewFile()) { 
															return; }
												}
											catch (java.io.IOException e){} 
										} 
									java.io.InputStream in = new java.io.FileInputStream (originalApk);
									java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
									byte[] buf = new byte[1024];
									int len; 
									while ((len = in.read(buf)) > 0) { 
												out.write(buf, 0, len); 
									} 
									in.close(); 
									out.close(); 
									i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
									startActivity(Intent.createChooser(i, "Share APK via"));
						} 
						catch (java.io.IOException e) 
						{ showMessage(e.toString()); 
						} 
			}
	{
	}
	
	
	private void _share_bn () {
	}
	private void shareApplicationb() { 
						android.content.pm.ApplicationInfo app = 
						getApplicationContext().getApplicationInfo(); 
						String filePath = app.sourceDir;
						Intent i = new Intent(Intent.ACTION_SEND); 
						i.setType("*/*"); 
						java.io.File originalApk = new java.io.File(filePath); 
						try {  
								java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
						 		if (!tempFile.isDirectory()) 
									if (!tempFile.mkdirs()) 
									return; 
									tempFile = new java.io.File(tempFile.getPath() + "/" + 
									"scEWS - Scholarship News.apk");
									if (!tempFile.exists()) 
										{
											try{
													if (!tempFile.createNewFile()) { 
															return; }
												}
											catch (java.io.IOException e){} 
										} 
									java.io.InputStream in = new java.io.FileInputStream (originalApk);
									java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
									byte[] buf = new byte[1024];
									int len; 
									while ((len = in.read(buf)) > 0) { 
												out.write(buf, 0, len); 
									} 
									in.close(); 
									out.close(); 
									i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
									startActivity(Intent.createChooser(i, "APK শেয়ার করুন"));
						} 
						catch (java.io.IOException e) 
						{ showMessage(e.toString()); 
						} 
			}
	{
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

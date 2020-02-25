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

public class SaudiArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private LinearLayout linear_scroll;
	private TextView textview_heading;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private Button iu;
	private Button kau_m;
	private Button kau_h;
	private Button ksu;
	private Button uqu;
	private Button imamu;
	private Button nu;
	private Button pnu;
	private Button tu;
	private Button mu;
	private Button nbu;
	private Button ju;
	private Button uhb;
	private Button taibahu;
	private Button jazanu;
	private Button ut;
	private Button iau;
	private Button kku;
	private Button isdb;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences spbr;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.saudi_ar);
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
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		iu = (Button) findViewById(R.id.iu);
		kau_m = (Button) findViewById(R.id.kau_m);
		kau_h = (Button) findViewById(R.id.kau_h);
		ksu = (Button) findViewById(R.id.ksu);
		uqu = (Button) findViewById(R.id.uqu);
		imamu = (Button) findViewById(R.id.imamu);
		nu = (Button) findViewById(R.id.nu);
		pnu = (Button) findViewById(R.id.pnu);
		tu = (Button) findViewById(R.id.tu);
		mu = (Button) findViewById(R.id.mu);
		nbu = (Button) findViewById(R.id.nbu);
		ju = (Button) findViewById(R.id.ju);
		uhb = (Button) findViewById(R.id.uhb);
		taibahu = (Button) findViewById(R.id.taibahu);
		jazanu = (Button) findViewById(R.id.jazanu);
		ut = (Button) findViewById(R.id.ut);
		iau = (Button) findViewById(R.id.iau);
		kku = (Button) findViewById(R.id.kku);
		isdb = (Button) findViewById(R.id.isdb);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		spbr = getSharedPreferences("Browser", Activity.MODE_PRIVATE);
		
		iu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Iu_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		kau_m.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), KauMActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		kau_h.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), KauHActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		ksu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), KsuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		uqu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), UquActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		imamu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), ImamuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		nu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Nu_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		pnu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), PnuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		tu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Tu_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		mu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Mu_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		nbu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), NbuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		ju.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Ju_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		uhb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), UhbActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		taibahu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), TaibahuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		jazanu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), JazanuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		ut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), Ut_Activity.class);
				startActivity(i);
				finish();
			}
		});
		
		iau.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), IauActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		kku.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), KkuActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		isdb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), IsdbActivity.class);
				startActivity(i);
				finish();
			}
		});
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
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		i.setClass(getApplicationContext(), UniSelectContryArActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			textview_heading.setText("الجامعات للمنح الدراسية للخارجيين");
			iu.setText("الجامعة الإسلامية بالمدينة المنورة");
			kau_m.setText("جامعة الملك عبدالعزيز (المعهد)");
			kau_h.setText("جامعة الملك عبدالعزيز (البكالوريوس)");
			ksu.setText("جامعة الملك سعود");
			uqu.setText("جامعة أم القرى");
			imamu.setText("جامعة الإمام محمد بن سعود الإسلامية");
			nu.setText("جامعة نجران");
			pnu.setText("جامعة الأميرة نورة بنت عبدالرحمن");
			tu.setText("جامعة الطائف");
			mu.setText("جامعة المجمعة");
			nbu.setText("جامعة الحدود الشمالية");
			ju.setText("جامعة الجوف");
			uhb.setText("جامعة حفر الباطن");
			taibahu.setText("جامعة طيبة");
			jazanu.setText("جامعة جازان");
			ut.setText("جامعة تبوك");
			iau.setText("جامعة الإمام عبد الرحمن بن فيصل");
			kku.setText("جامعة الملك خالد");
			isdb.setText("البنك الإسلامي للتنمية");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			iu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kau_m.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kau_h.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ksu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			uqu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			imamu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			nu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			pnu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			tu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			mu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			nbu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ju.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			uhb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			taibahu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			jazanu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ut.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			iau.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kku.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			isdb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("Universities for foreigners scholarship");
			iu.setText("ISLAMIC UNIVERSITY OF MADINAH");
			kau_m.setText("KING ABDULAZIZ UNIVERSITY (DCAFL)");
			kau_h.setText("KING ABDULAZIZ UNIVERSITY (GAPOL)");
			ksu.setText("KING SAUD UNIVERSITY");
			uqu.setText("UMM AL-QURA UNIVERSITY");
			imamu.setText("IMAM MOHAMMAD IBN SAUD\nISLAMIC UNIVERSITY");
			nu.setText("NAJRAN UNIVERSITY");
			pnu.setText("PRINCESS NOURAH BINT\nABDULRAHMAN UNIVERSTY");
			tu.setText("TAIF UNIVERSITY");
			mu.setText("MAJMAAH UNIVERSITY");
			nbu.setText("NORTHERN BORDER UNIVERSITY");
			ju.setText("JOUF UNIVERSITY");
			uhb.setText("UNIVERSITY OF HAFR AL BATIN");
			taibahu.setText("TAIBAH UNIVERSITY");
			jazanu.setText("JAZAN UNIVERSITY");
			ut.setText("UNIVERSITY OF TABUK");
			iau.setText("IMAM ABDULRAHMAN\nBIN FAISAL UNIVERSITY");
			kku.setText("KING KHALID UNIVERSITY");
			isdb.setText("ISLAMIC DEVELOPMENT BANK");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			iu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kau_m.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kau_h.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ksu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			uqu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			imamu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			nu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			pnu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			tu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			mu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			nbu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ju.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			uhb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			taibahu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			jazanu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			ut.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			iau.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			kku.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			isdb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_heading.setTextSize((float)21);
			kau_m.setTextSize((float)18);
			kau_h.setTextSize((float)18);
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
			textview_heading.setText("বিদেশীদের বৃত্তির জন্য বিশ্ববিদ্যালয় সমূহ");
			iu.setText("মদিনা ইসলামি বিশ্ববিদ্যালয়");
			kau_m.setText("বাদশাহ আবদুল আজিজ বিশ্ববিদ্যালয় (ডিপ্লোমা)");
			kau_h.setText("বাদশাহ আবদুল আজিজ বিশ্ববিদ্যালয় (অনার্স)");
			ksu.setText("বাদশাহ স‌উদ বিশ্ববিদ্যালয়");
			uqu.setText("উম্মুল কুরা বিশ্ববিদ্যালয়");
			imamu.setText("ইমাম মুহাম্মাদ ইবনে স‌উদ ইসলামি বিশ্ববিদ্যালয়");
			nu.setText("নাজরান বিশ্ববিদ্যালয়");
			pnu.setText("প্রিন্সেস নূরা বিনতে আব্দুর রহমান বিশ্ববিদ্যালয়");
			tu.setText("তায়েফ বিশ্ববিদ্যালয়");
			mu.setText("মাজমা'হ বিশ্ববিদ্যালয়");
			nbu.setText("নর্দান বর্ডার বিশ্ববিদ্যালয়");
			ju.setText("জাউফ বিশ্ববিদ্যালয়");
			uhb.setText("হাফরুল বাতিন বিশ্ববিদ্যালয়");
			taibahu.setText("তাইবাহ বিশ্ববিদ্যালয়");
			jazanu.setText("জাযান বিশ্ববিদ্যালয়");
			ut.setText("তাবুক বিশ্ববিদ্যালয়");
			iau.setText("ইমাম আব্দুর রহমান বিন ফয়সাল বিশ্ববিদ্যালয়");
			kku.setText("বাদশাহ খালিদ বিশ্ববিদ্যালয়");
			isdb.setText("ইসলামি উন্নয়ন ব্যাংক");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			iu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			kau_m.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			kau_h.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			ksu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			uqu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			imamu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			nu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			pnu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			tu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			mu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			nbu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			ju.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			uhb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			taibahu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			jazanu.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			ut.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			iau.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			kku.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			isdb.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)30);
			iu.setTextSize((float)25);
			kau_m.setTextSize((float)25);
			kau_h.setTextSize((float)25);
			ksu.setTextSize((float)25);
			uqu.setTextSize((float)25);
			imamu.setTextSize((float)25);
			nu.setTextSize((float)25);
			pnu.setTextSize((float)25);
			tu.setTextSize((float)25);
			mu.setTextSize((float)25);
			nbu.setTextSize((float)25);
			ju.setTextSize((float)25);
			uhb.setTextSize((float)25);
			taibahu.setTextSize((float)25);
			jazanu.setTextSize((float)25);
			ut.setTextSize((float)25);
			iau.setTextSize((float)25);
			kku.setTextSize((float)25);
			isdb.setTextSize((float)25);
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

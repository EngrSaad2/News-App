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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class AboutUsArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout heading;
	private LinearLayout linear_tnx;
	private LinearLayout linear_akarim;
	private LinearLayout linear_taqui;
	private LinearLayout linear_md;
	private LinearLayout linear_contact;
	private LinearLayout linear_credit;
	private TextView textview_heading;
	private TextView textview_tnx;
	private ProgressBar progressbar1;
	private TextView textview_akarim_name;
	private TextView textview_akarim_dtls;
	private ProgressBar progressbar2;
	private TextView textview_taqui_name;
	private TextView textview_taqui_dtls;
	private ProgressBar progressbar3;
	private TextView textview_md_name;
	private TextView textview_md_dtls;
	private ProgressBar progressbar4;
	private TextView textview_contacthead;
	private TextView text_contact_email;
	private TextView text_contact_fbpg;
	private TextView textview_credit;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences test;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about_us_ar);
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
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		heading = (LinearLayout) findViewById(R.id.heading);
		linear_tnx = (LinearLayout) findViewById(R.id.linear_tnx);
		linear_akarim = (LinearLayout) findViewById(R.id.linear_akarim);
		linear_taqui = (LinearLayout) findViewById(R.id.linear_taqui);
		linear_md = (LinearLayout) findViewById(R.id.linear_md);
		linear_contact = (LinearLayout) findViewById(R.id.linear_contact);
		linear_credit = (LinearLayout) findViewById(R.id.linear_credit);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		textview_tnx = (TextView) findViewById(R.id.textview_tnx);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview_akarim_name = (TextView) findViewById(R.id.textview_akarim_name);
		textview_akarim_dtls = (TextView) findViewById(R.id.textview_akarim_dtls);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		textview_taqui_name = (TextView) findViewById(R.id.textview_taqui_name);
		textview_taqui_dtls = (TextView) findViewById(R.id.textview_taqui_dtls);
		progressbar3 = (ProgressBar) findViewById(R.id.progressbar3);
		textview_md_name = (TextView) findViewById(R.id.textview_md_name);
		textview_md_dtls = (TextView) findViewById(R.id.textview_md_dtls);
		progressbar4 = (ProgressBar) findViewById(R.id.progressbar4);
		textview_contacthead = (TextView) findViewById(R.id.textview_contacthead);
		text_contact_email = (TextView) findViewById(R.id.text_contact_email);
		text_contact_fbpg = (TextView) findViewById(R.id.text_contact_fbpg);
		textview_credit = (TextView) findViewById(R.id.textview_credit);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		test = getSharedPreferences("abcd", Activity.MODE_PRIVATE);
		
		text_contact_email.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				text_contact_email.setTextIsSelectable(true);
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("mailto:help.menha@gmail.com"));
				startActivity(i);
			}
		});
		
		text_contact_fbpg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("android-app://com.facebook.katana"));
					i.setData(Uri.parse("fb://page/106610167441482"));
					startActivity(i);
				} catch(Exception e){
					i.setAction(Intent.ACTION_VIEW);
					i.setData(Uri.parse("https://www.facebook.com/scews.scholarship.news/"));
					startActivity(i);
				}
			}
		});
		
		textview_credit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://icons8.com"));
				startActivity(i);
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
		test.edit().remove("abcd").commit();
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			textview_heading.setText("المعلومات عنا");
			textview_tnx.setText("اسم التطبيق: سكيوس - أخبار المنح الدراسية\nإصدار التطبيق: 1.0.010\n\nالسلام عليكم ورحمة الله وبركاته.\nهدفنا هو توفير فرص الدراسات العليا للراغبين وجعل العالم أفضل 💞.\n\n\n\nشكرا خاصا لـ:\n★ عبد الكريم بن سروج (مخطط الرئيسي)\n\n★ تقي حسن (إجمالي)\n\n★ محمد كافي (مترجم)");
			textview_akarim_name.setText("★ عبد الكريم بن سروج ★");
			textview_akarim_dtls.setText("طالب في:\n١. مدرسة الحديث بناظر بازار، داكا، بنغلاديش.\n٢. جامعة اناندو موهان بمومن شاهي، بنغلاديش (قسم الدراسات الإسلامية).");
			textview_taqui_name.setText("★ تقي حسن ★");
			textview_taqui_dtls.setText("طالب في الجامعة الإسلامية، بنغلاديش (قسم القرآن والدراسات الإسلامية).\nو\nطالب سابق في مدرسة الحديث بناظر بازار، داكا، بنغلاديش.");
			textview_md_name.setText("★ محمد كافي ★");
			textview_md_dtls.setText("طالب في كلية المسجد النبوي، السعودية (قسم الشريعة).\nو\nطالب سابق في معهد المسجد النبوي، السعودية.");
			textview_contacthead.setText("للتسجيل في جامعات مختلفة، يمكنك التواصل معنا.");
			text_contact_email.setText("البريد الإلكتروني: mma.abdulkarim@gmail.com");
			text_contact_fbpg.setText("صفحة الفيسبوك: Scews - Scholarship News");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_tnx.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_akarim_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_akarim_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_taqui_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_taqui_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_md_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_md_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_contacthead.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			text_contact_email.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			text_contact_fbpg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
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
			textview_heading.setText("About Us");
			textview_tnx.setText("App name: scEWS - Scholarship News\nApp version: 1.0.010\n\n\nAssalamu alaikum wa rahmatullah.\nOur mission is to offer an opportunity to those who are eager to higher education and make the world a better place 💞. \n\n\n\nSpecial Thanks to\n★ Abdul Karim Bin Suruj (Role planner)\n\n★ Taqui Hasan (Overall)\n\n★ Muhammad Kafi (Translator)");
			textview_akarim_name.setText("★ Abdul Karim Bin Suruj ★");
			textview_akarim_dtls.setText("Student of:\n1. Madrasatul Hadis at Nazir Bazar, Dhaka, Bangladesh.\n\n2. Ananda Mohan college at Mymensingh, Bangladesh (Department of Islamic Studies).");
			textview_taqui_name.setText("★ Taqui Hasan ★");
			textview_taqui_dtls.setText("Student of Islamic University, Bangladesh (Department of Al-Quran & Islamic Studies).\n&\nFormer student of Madrasatul Hadis at Nazir Bazar, Dhaka, Bangladesh.");
			textview_md_name.setText("★ Muhammad Kafi ★");
			textview_md_dtls.setText("Student of College of Masjid An-Nabawi, KSA (Department of Shar'iyah).\n&\nFormer student of School of Masjid An-Nabawi, KSA.");
			textview_contacthead.setText("To apply in different universities you can contact with us.");
			text_contact_email.setText("Email: mma.abdulkarim@gmail.com");
			text_contact_fbpg.setText("Facebook Page: Scews - Scholarship News");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_tnx.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_akarim_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_akarim_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_taqui_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_taqui_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_md_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_md_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			textview_contacthead.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			text_contact_email.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
			text_contact_fbpg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 0);
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
			textview_heading.setText("আমাদের সম্পর্কে");
			textview_tnx.setText("অ্যাপের নাম: স্কিউস - শিক্ষাবৃত্তির খবরাখবর\nঅ্যাপের সংস্করণ: 1.0.010\n\nআসসালামু আলাইকুম ওয়া রহমাতুল্লাহ\nআমাদের লক্ষ্য হল উচ্চ শিক্ষায় আগ্রহীদের সুযোগ তৈরি করে দেওয়া এবং বিশ্বকে আরও উন্নত স্থান হিসেবে গড়ে তোলা।\n\n\n\nবিশেষ কৃতজ্ঞতা:\n★ আব্দুল কারীম বিন সুরুজ (প্রধান পরিকল্পক)\n\n★ তাক্বী হাসান (সম্যক)\n\n★ মুহাম্মাদ কাফী (অনুবাদক)");
			textview_akarim_name.setText("★ আব্দুল কারীম বিন সুরুজ ★");
			textview_akarim_dtls.setText("অধ্যয়নরত:\n১. মাদরাসাতুল হাদীস, নাজির বাজার, ঢাকা, বাংলাদেশ।\n২. আনন্দ মোহন কলেজ, ময়মনসিংহ, বাংলাদেশ (ইসলাম শিক্ষা বিভাগ)।");
			textview_taqui_name.setText("★ তাক্বী হাসান ★");
			textview_taqui_dtls.setText("ইসলামী বিশ্ববিদ্যালয়, বাংলাদেশ (আল-কুরআন এণ্ড ইসলামিক স্টাডিজ বিভাগ) এর ছাত্র।\nএবং\nমাদরাসাতুল হাদীস, নাজির বাজার, ঢাকা, বাংলাদেশ এর সাবেক ছাত্র।");
			textview_md_name.setText("★ মুহাম্মাদ কাফী ★");
			textview_md_dtls.setText("কুল্লিয়াতুল মাসজিদ আন-নববী, সৌদি আরব (শারি'আহ বিভাগ) এর ছাত্র।\nএবং\nমা'হাদুল মাসজিদ আন-নববী, সৌদি আরব এর সাবেক ছাত্র।");
			textview_contacthead.setText("বিভিন্ন বিশ্ববিদ্যালয়ে আবেদনের জন্য আমাদের সাথে যোগাযোগ করতে পারেন।");
			text_contact_email.setText("ইমেইল: mma.abdulkarim@gmail.com");
			text_contact_fbpg.setText("ফেসবুক পেজ: Scews - Scholarship News");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_tnx.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_akarim_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_akarim_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_taqui_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_taqui_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_md_name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_md_dtls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_contacthead.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			text_contact_email.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			text_contact_fbpg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)25);
			textview_tnx.setTextSize((float)23);
			textview_akarim_name.setTextSize((float)21);
			textview_akarim_dtls.setTextSize((float)23);
			textview_taqui_name.setTextSize((float)21);
			textview_taqui_dtls.setTextSize((float)23);
			textview_md_name.setTextSize((float)21);
			textview_md_dtls.setTextSize((float)23);
			textview_contacthead.setTextSize((float)21);
			text_contact_email.setTextSize((float)19);
			text_contact_fbpg.setTextSize((float)19);
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
		if (test.getString("abcd", "").equals("Details")) {
			textview_contacthead.setVisibility(View.GONE);
			text_contact_email.setVisibility(View.GONE);
			text_contact_fbpg.setVisibility(View.GONE);
		}
		if (test.getString("abcd", "").equals("Contact")) {
			textview_contacthead.setVisibility(View.VISIBLE);
			text_contact_email.setVisibility(View.VISIBLE);
			text_contact_fbpg.setVisibility(View.VISIBLE);
			linear_tnx.setVisibility(View.GONE);
			linear_akarim.setVisibility(View.GONE);
			linear_taqui.setVisibility(View.GONE);
			linear_md.setVisibility(View.GONE);
			linear_credit.setVisibility(View.GONE);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		test.edit().remove("abcd").commit();
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

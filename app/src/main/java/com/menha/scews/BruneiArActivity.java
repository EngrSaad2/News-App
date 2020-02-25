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

public class BruneiArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private LinearLayout linear_details;
	private TextView textview_heading;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview_details;
	private Button button_apply;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences spbr;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.brunei_ar);
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
		linear_details = (LinearLayout) findViewById(R.id.linear_details);
		textview_heading = (TextView) findViewById(R.id.textview_heading);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview_details = (TextView) findViewById(R.id.textview_details);
		button_apply = (Button) findViewById(R.id.button_apply);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		spbr = getSharedPreferences("Browser", Activity.MODE_PRIVATE);
		
		button_apply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				spbr.edit().putString("Browser", "brn_gov").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), BrowserActivity.class);
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
	public void onStart() {
		super.onStart();
		if (sp.getString("Language", "").equals("ar")) {
			textview_heading.setText("منحة بروناي دار السلام - ٢٠٢٠");
			textview_details.setText("⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩ منحة مقدمة من حكومة بروناي دار السلام لدراسة البكالوريوس والماجستير (ممولة بالكامل) ⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩\n\n\nتدعو حكومة بروناي دار السلام الطلبة من مختلف دول منظمة التعاون الإسلامي إلى التقدم بطلب للحصول على منحة للدراسة في بروناي دار السلام ، حيث إن هذه المنحة ممولة بالكامل ومفتوحة بالنسبة لمرحلة الدبلوم والماجستير والبكالوريوس.\n\nتعتبر هذه المنحة من الفرص المتميزة  بالنسبة  لطلبة دول غرب آسيا ودول منظمة التعاون الإسلامي.\n\n★ تفاصيل منحة حكومة بروناي دار السلام للعام 2020 ★\n\nالبلد المضيف:  بروناي\n\nالمنحة ممولة من خلال : وزارة الشئون الخارجية\n\nمستوى المقرر :\n• شهادة دبلوم\n• البكالوريوس\n• درجة الماجستير للدراسات العليا\n\n\nمدة المنحة الدراسية:\n • دبلوم: 3 سنوات\n • درجة البكالوريوس: (4 سنوات دوام كامل)\n • درجة الماجستير: 12 شهرًا / 24 شهرًا\n\n\nالمؤسسات المضيفة:\n• جامعة بروني دار السلام (UBD)\n• جامعة إسلام سلطان شريف علي (UNISSA)\n• جامعة تكنولوني بروناي (UTB)\n• جامعة بروناي التقنية  (PB)\n\n\n\n★ التمويل المقدم من خلال منحة حكومة بروناي دار السلام ★\n\nمنحة حكومة بروناي دار السلام  هي منحة دراسية دولية ممولة بالكامل للطلاب الدوليين. حيث ستشمل المنحة:\n• الإعفاء من دفع الرسوم الدراسية بما في ذلك رسوم القبول والفحص والتسجيل والتوجيه طوال مدة البرنامج.\n• تذكرة سفر على الدرجة الاقتصادية (تذكرة العودة الجوية).\n• مصروف شخصي شهري.\n• مصروف شهري للوجبات.\n• مصروف ثمن كتب سنوي.\n• الإقامة في في السكن الحكومي.\n\n\n★ معايير الأهلية للتقدم إلى منحة بروناي دار السلام ★\n\n• الطلبات مفتوحة لمواطني دول رابطة أمم جنوب شرق آسيا ودول الكومنولث ودول منظمة التعاون الإسلامي (جميع الدول العربية مؤهلة للتقديم).\n• يجب أن يتجاورز سن المتقدمون  25 عامًا بالنسبة لبرامج البكالوريوس والدبلوم.\n• يجب ألا يتجاوز سن المتقدمون 35 عامًا لبرامج درجة الماجستير في الدراسات العليا في 31 يوليو 2020.\n• المنحة ليست متاحة بالنسبة للمقيمين الدائمين في بروناي دار السلام.\n\n\n★ كيف يمكن تقديم الطلب إلى منحة بروناي دار السلام ★\n\nيجب ملء استمارات الطلب وتصديقها من قبل وزارة الخارجية أو جهة التنسيق الوطنية للمنح الدراسية في بلد مقدم الطلب.\n\nيُطلب من المتقدمين أيضًا تقديم بيان تصريح أمني بخلو سجلهم الجنائي من أية أحكام جنائية سابقة.\n\n# آخر موعد للتسجيل:\n• آخر موعد لتقديم طلب الحصول على منحة بروناي دار السلام 2020 للطلاب الأجانب هو 14 فبراير 2020.");
			button_apply.setText("قدم الآن!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("Brunei Darussalam Scholarship - 2020");
			textview_details.setText("⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩ Grant from the Government of Brunei Darussalam to study Bachelor's and Master's degree (fully funded) ⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩\n\nThe Government of Brunei Darussalam Scholarship 2020 is now open for the applications. The Brunei Government Scholarships for international students are offered by the Ministry of Foreign Affairs.\n\nThe Brunei Scholarship is available for Diploma, Undergraduate Degree and Postgraduate Master’s Degree. Selected students will be studying in top universities of Brunei. The academic year commences July/August 2020.\n\nA scholarship recipient is not permitted to undertake any paid employment or to serve on the staff of any country’s representative mission in Brunei Darussalam during the duration of the scholarship.\n\n★ BRUNEI DARUSSALAM SCHOLARSHIP 2020 DETAILS ★\n\nHOST COUNTRY: Brunei\n\nSCHOLARSHIP BY: Ministry of Foreign Affairs\n\nCOURSE LEVEL:\n• Diploma\n• Undergraduate\n• Postgraduate Master’s Degree\n\nSCHOLARSHIP DURATION:\n• Diploma: 3 Years\n• Undergraduate Degree:  (4 Year Full Time)\n• Master Degree: 12 Months/24 Months\n\nHOST INSTITUTIONS:\nThe Government of Brunei Scholarships 2020 Provides Applicants with the Opportunity to Undertake Diploma, Undergraduate Degree and Postgraduate Master’s Degree at any one of the Following Institutions of Higher Education.\n\n• University Brunei Darussalam (UBD)\n• University Islam Sultan Sharif Ali (UNISSA)\n• University Teknologi Brunei (UTB)\n• Politeknik Brunei (PB)\n\n\n★ SCHOLARSHIP VALUE ★\n\n• The Government of Brunei Darussalam Scholarship under the above Scholarship Award Scheme for 2020/2021 is a fully-funded international scholarship for international students.\n• Exemption From paying tuition fees including acceptance, examination, registration and orientation fees for the duration of the program.\n• An economy class air-ticket (Return Air-Ticket).\n• A monthly personal allowance of BND$500.00.\n• A monthly meals allowance of BND$150.00.\n• An annual book allowance of BND$600.00.\n• Accommodation at the residential college of the University/ Polytechnic.\n• Baggage Allowance for shipment of the scholarship recipient’s personal effects to his country of origin/country of domicile upon completion of the program, at a maximum amount of:\nBND$250.00 to a country within the ASEAN region.\nor\nBND$500.00 to a country outside the ASEAN region.\n\nComprehensive insurance cover for the whole duration of the Scholarship.\n\n\n★ ELIGIBILITY CRITERIA ★\n\nApplications are open to citizens of, but not limited to, ASEAN, Commonwealth, and OIC Member Countries.\n\nApplicants must be, between the ages of 18-25 for Undergraduate and Diploma programs.\n\nMust not exceed the age of 35 for Postgraduate Master’s Degree programs on the 31st of July 2020.\n\nThe award is NOT eligible to Brunei Darussalam Permanent Residents.\n\n\n★ HOW TO GET BRUNEI SCHOLARSHIPS ★\n\nApplication forms must be duly completed and endorsed by the Ministry of Foreign Affairs or the National Focal Point for scholarships of the applicant’s country.\n\nApplicants are required to also submit a security clearance statement from their National Security Agency(ies)/ Police Station (i.e. a statement/ report certifying that applicants are clear from any civil and criminal charges).\n\n# APPLICATION DEADLINE:\n• The application deadline for the Brunei Darussalam Scholarship 2020 for Foreign Student is 14th February 2020.");
			button_apply.setText("Apply Now!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("ব্রুনাই দারুসসালাম বৃত্তি - ২০২০");
			textview_details.setText("⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩ ⁦ব্রুনাই দারুসসালাম সরকারের স্নাতক এবং স্নাতকোত্তর পর্যায়ে বৃত্তি (সম্পূর্ণ অর্থায়িত) 🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩⁦🇧🇳⁩\n\nব্রুনাই দারুসসালাম বৃত্তি ২০২০ এখন আবেদনের জন্য উন্মুক্ত। আন্তর্জাতিক শিক্ষার্থীদের জন্য ব্রুনাই পররাষ্ট্র মন্ত্রণালয় সরকারী বৃত্তি দিয়ে থাকে।\n\nডিপ্লোমা, স্নাতক এবং স্নাতকোত্তর ডিগ্রির জন্য ব্রুনাই বৃত্তি দিয়ে থাকে। নির্বাচিত শিক্ষার্থীরা ব্রুনাইয়ের শীর্ষ বিশ্ববিদ্যালয়গুলিতে অধ্যয়নের সুযোগ পেয়ে থাকে। ২০২০ সালের জুলাই/আগস্টে শিক্ষাবর্ষ শুরু হয়।\n\nবৃত্তিপ্রাপ্ত শিক্ষার্থীদের কোনও বেতনভুক্ত চাকুরী করার বা ব্রুনাই দারুসসালামে কোনও দেশের প্রতিনিধি মিশনের কর্মীদের জন্য বৃত্তির সময়কালে কাজ করার অনুমতি নেই।\n\n★ ব্রুনাই দারুসসালাম বৃত্তি ২০২০ এর বিবরণ ★\n\nআয়োজক দেশ: ব্রুনাই\n\nবৃত্তি প্রদান: পররাষ্ট্র মন্ত্রণালয়\n\nকোর্স পর্যায়:\n• ডিপ্লোমা।\n• স্নাতক ডিগ্রি।\n• স্নাতকোত্তর ডিগ্রি।\n\nকোর্সের মেয়াদ:\n• ডিপ্লোমা: ৩ বছর।\n• স্নাতক ডিগ্রি: সম্পূর্ণ ৪ বছর।\n• স্নাতকোত্তর ডিগ্রি: ১২/২৪ মাস।\n\nপ্রতিষ্ঠান:\n• ব্রুনাই দারুসসালাম বিশ্ববিদ্যালয় (UBD)।\n• সুলতান শরিফ আলী ইসলাম বিশ্ববিদ্যালয় (UNISSA)।\n• ব্রুনাই প্রযুক্তি বিশ্ববিদ্যালয় (UTB)।\n• ব্রুনাই পলিটেকনিক (PB)\n\n★ সুযোগ সুবিধা ★\n• উপরোক্ত বৃত্তি প্রকল্পের আওতায় 2020/2021 এর জন্য ব্রুনাই দারুসসালাম সরকার বৃত্তি আন্তর্জাতিক শিক্ষার্থীদের জন্য একটি সম্পূর্ণ অর্থায়িত বৃত্তি।\n• প্রোগ্রাম চলাকালীন টিউশন ফি সহ ভর্তি, পরীক্ষা, নিবন্ধণ ও ওরিয়েন্টেশন ফি প্রদান থেকে ছাড়।\n• ইকোনমি শ্রেণির বিমান টিকিট (ফিরতি বিমান টিকিট)।\n• মাসিক ৫০০.০০ ব্রুনাই ডলার ব্যক্তিগত ভাতা।\n• মাসিক ১৫০.০০ ব্রুনাই ডলার খাদ্য ভাতা।\n• বাৎসরিক ৬০০.০০ ব্রুনাই ডলার পুস্তক ভাতা।\n• বিশ্ববিদ্যালয়/পলিটেকনিকের আবাসিক কলেজে বাসস্থান।\n• প্রোগ্রামটি শেষ হওয়ার পরে বৃত্তিপ্রাপ্ত শিক্ষার্থীর নিজ উৎস/দেশে তার ব্যক্তিগত মালামাল প্রেরণের জন্য লাগেজ ভাতা, সর্বোচ্চ:\nএশিয়ান অঞ্চলের কোনো দেশের জন্য ২৫০.০০ ব্রুনাই ডলার।\nঅথবা\nএশিয়ান অঞ্চলের বাইরের কোনো দেশের জন্য ৫০০.০০ ব্রুনাই ডলার।\n• প্রোগ্রামের পুরো সময়কালের জন্য বিস্তৃত বীমা কভার।\n\n★ নির্বাচিত হ‌ওয়ার যোগ্যতা ★\n\nআবেদনগুলি এশিয়ান, কমনওয়েলথ এবং ওআইসির সদস্য দেশগুলির (তবে সীমাবদ্ধ নয়) নাগরিকদের জন্য উন্মুক্ত।\n\nস্নাতক এবং ডিপ্লোমা প্রোগ্রামগুলির জন্য আবেদনকারীদের বয়স ১৮-২৫ বছরের মধ্যে হতে হবে।\n\nস্নাতকোত্তর ডিগ্রি প্রোগ্রামগুলির জন্য ২০২০ সালের ৩১ জুলাই অবধি বয়স ৩৫ বছরের বেশি  হওয়া চলবে না।\n\nএই বৃত্তি ব্রুনাই দারুসসালাম এর স্থায়ী বাসিন্দাদের জন্য প্রযোজ্য নয়।\n\n★ কীভাবে ব্রুনাই দারুসসালাম বৃত্তি পাবেন? ★\n\nআবেদন ফর্মগুলি অবশ্যই যথাযথভাবে পূরণ করতে হবে এবং আবেদনকারীর নিজ দেশের পররাষ্ট্র মন্ত্রণালয় অথবা বৃত্তির জাতীয় ফোকাল পয়েন্ট দ্বারা অনুমোদিত হতে হবে।\n\nআবেদনকারীদের তাদের জাতীয় নিরাপত্তা সংস্থা/থানা থেকে একটি ছাড়পত্র বিবরণও জমা দিতে হবে (অর্থাৎ কোনও বিবৃতি/রিপোর্ট যাচাই করে যে আবেদনকারীরা কোনও দেওয়ানী ও ফৌজদারি অভিযোগ থেকে মুক্ত)।\n\n# আবেদনের শেষ তারিখ:\nবিদেশি শিক্ষার্থীর জন্য ব্রুনাই দারুসসালাম বৃত্তি ২০২০ এর আবেদনের সময়সীমা ১৪ ফেব্রুয়ারী ২০২০ পর্যন্ত।");
			button_apply.setText("এখন‌ই আবেদন করুন!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)25);
			textview_details.setTextSize((float)23);
			button_apply.setTextSize((float)23);
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
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		i.setClass(getApplicationContext(), UniSelectContryArActivity.class);
		startActivity(i);
		finish();
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

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
import android.widget.ProgressBar;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;

public class TurkeyArActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout linear_main;
	private LinearLayout linear_heading;
	private LinearLayout linear_details;
	private TextView textview_heading;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview_tr_gov_head;
	private TextView textview_gov_details;
	private Button button_gov_apply;
	private ProgressBar progressbar1;
	private TextView txtv_tr_diyanat_head;
	private TextView txtv_diyanat_details;
	private Button button_diyanat_apply;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences spbr;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.turkey_ar);
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
		textview_tr_gov_head = (TextView) findViewById(R.id.textview_tr_gov_head);
		textview_gov_details = (TextView) findViewById(R.id.textview_gov_details);
		button_gov_apply = (Button) findViewById(R.id.button_gov_apply);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		txtv_tr_diyanat_head = (TextView) findViewById(R.id.txtv_tr_diyanat_head);
		txtv_diyanat_details = (TextView) findViewById(R.id.txtv_diyanat_details);
		button_diyanat_apply = (Button) findViewById(R.id.button_diyanat_apply);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		spbr = getSharedPreferences("Browser", Activity.MODE_PRIVATE);
		
		button_gov_apply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				spbr.edit().putString("Browser", "tur_gov").commit();
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), BrowserActivity.class);
				startActivity(i);
			}
		});
		
		button_diyanat_apply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				spbr.edit().putString("Browser", "tur_diyanat").commit();
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
			textview_heading.setText("المنح الدراسية في تركيا (٢)");
			textview_tr_gov_head.setText("١. منحة الحكومية");
			textview_gov_details.setText("⁦🇹🇷⁩⁦🇹🇷⁩⁦🇹🇷⁩⁦🇹🇷⁩ أعلنت المنحة التركية بشكل رسمي عن موعد إفتتاح التقديم للعام ٢٠٢٠ ⁦🇹🇷⁩⁦🇹🇷⁩⁦🇹🇷⁩⁦🇹🇷⁩\n\nالمنحة ستفتتح التسجيل بتاريخ\n15-01-2020\n\nوينتهي التسجيل في :\n20-02-2020\n\nلجميع المستويات الأكاديمية ( بكالوريوس، ماجستير ، دكتوراه )\n\n\nمميزات المنحة التركية:\n\nميزات المنحة أنها ممولة بالكامل وتغطي كافة التكاليف من أقساط الجامعة إلى بدل سكن وتأمين صحي، وتغطية تكاليف السفر والفيزا للمتقدمين من خارج تركيا، بالإضافة إلى راتب شهري.\n\n• المعاش الشهري :\nالبكالوريوس ٨٠٠ ليرة تركي\nالماجستير ١١٠٠ ليرة تركي\nالدكتوراة ١٦٠٠ ليرة تركي\n• يحصل الطالب المقبول في المنحة على تذاكر سفر مدفوعة من قبل الدولة من البلد الذي يقيم فيه إلى تركيا ومن تركيا إلى بلده بعد إنتهاء الدراسة بشكل نهائي.\n• يحصل الطالب على إقامة طالب طول مدة الدراسة مدفوعة من قبل الدولة.\n• توفر الدولة للطالب السكن المجاني طول فترة الدراسة مع مصاريف السكن.\n• تقدم الدولة للطالب تأمين صحي مجاني طول فترة الدراسة.\n• سيحصل الطلاب الحاصلين على المنحة على سنة كاملة لدراسة اللغة التركية دون أي رسوم. مع العلم أن الطلاب الملتحقين بالدراسة بلغة أخرى (غير اللغة التركية) يتوجب عليهم حضور السنة.\n• الكاملة لتعلم اللغة التركية أيضاً.\n• سيحصل الطلاب الحاصلون على المنحة على بطاقة تمنحهم حق التنقل، بسعر مدعوم من الدولة مخفض جدا.\n\n\nشرط العمر :\n\nالبكالوريوس اقل من 21 سنة\nالماجستير اقل من 30 سنة\nالدكتوراة اقل من 35 سنة\nالبحوث أقل من 45 سنة\n\n\nالأوراق المطلوبة :\n\n١) شهادة المؤهل التعليمي:\nشهادة الثانوية للمتقدمين للبكالوريوس, أو شهادة الجامعة للمتقدمين للماجستير, أو شهادة الجامعة والماجستير للمتقدمين للدكتوراه.\nفي حال عدم وجود شهادة التخرج جاهزة أو تبقى على تخرج المتقدم عدة أشهر, فيمكن تقديم إفادة رسمية مختومة تفيد بذلك ترفع إلى الموقع عوضًا عًن شهادة التخرج.\n\n٢) كشف الدرجات التعليمي يوضح درجات الطالب في المواد:\nبالنسبة لخرجيي الثانوية هو نفسه شهادة الثانوية.\nوبالنسبه لخرجيي الجامعة والماجستير.\nفهو الكشف التفصيلي لدرجات المواد خلال سنوات الدراسة.\n\n٣) رسالة توصية (واحدة أو اكثر) من مدرس أو مدير في العمل أو من مؤسسة : ترفع رسالة التوصية إلى الموقع بالإضافة إلى ضرورة إدخال البريد الإلكتروني للشخص الكاتب للتوصية, حيث ستصل إليه رسالة تطلب منه التأكيد بأنه الشخص الذي قام بكتابة التوصية.\n\n٤) وثيقة إثبات هوية كجواز سفر أو بطاقة شخصية أو شهادة ميلاد أو رقم جلوس.\n\n٥) صورة شخصية حديثة واضحة.\n\n٦) ترجمة كافة الأوراق (بعد تلقي رسالة القبول وتحديد موعد المقابلة).\n\nوثائق مطلوبة لبعض الجامعات أو التخصصات فقط:\n\n١) شهادة امتحان معتمد للغة الإنجليزية, في حال كانت الجامعة التي تم اختيارها تطلب شهادة اللغة\nالشهادات المعتمدة هي شهادة التوفل TOEFL.\n\nتكن شهادة اللغة متوفرة اثناء التقديم, فيجب تجهيزها حتى موعد المقابلة.\n\n٢) شهادة امتحان كفاءة [ مهارات ] معتمد, في حال كانت الجامعة التي تم اختيارها تتطلب ذلك.\nتطلب هذه الشهادة GMAT أو GRE  وفي الغالب للطلاب المتقدمين للدراسات العليا, كشهادة امتحان.\n\nفي حال كانت الشهادة المطلوبة غير متوفرة أثناء فترة التقديم, فيجب تجهيزها حتى موعد المقابلة.\n\n١) شهادات خبرة في أعمال سابقة انتظم فيها المتقدم.\n\n٢) شهادات مشاركة في دورات تدريب أو تأهيل أو ندوات.\n\n٣) شهادات تكريم في أي مجال.\n\n٤) شهادات مشاركة في أنشطة تطوعية خدمية.\n\n٥) أي شهادة أو وثيقة أو جائزة أخرى حصل عليها المتقدم سوى في المدرسة أو العمل.\n\n\nالمعدلات المطلوبة:\n\nدرجة البكالوريوس: يجب أن لا يقل المجموع عن 70% و يجب ان لا يقل مجموع الطلاب الراغبين في دراسة الطب عن 90%\n\nدرجة الماجستير والدكتوراه: يجب ان لا يقل المجموع عن 75%\n\n\nملحوظة :\n\nشهادة اليوس والسات ليست شرطاً للتقديم.\n \nالأوراق المرفقة لا تحتاج إلى ترجمة أو تعديل إذا كانت باللغة الإنجليزية وشكرا.");
			button_gov_apply.setText("قدم الآن!");
			txtv_tr_diyanat_head.setText("٢. منح الديانة");
			txtv_diyanat_details.setText("تم جدولة تسجيل على برنامج المنح الديانة التركية.\n\n آخر موعد للتقديم: من ١ فبراير، ٢٠٢٠م إلى ١٥ مارس ٢٠٢٠م.\n\n المنح الدراسية لمؤسسة ديانات التركية هي فقط لأولئك الذين يرغبون في تكريم في المدارس الثانوية والدراسات الإسلامية.\n\n لا توجد فرصة للدراسة في أي قسم آخر.  لا توجد منحة دراسية لدرجة الماجستير أو الدكتوراه.");
			button_diyanat_apply.setText("قدم الآن!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_tr_gov_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_gov_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_gov_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			txtv_tr_diyanat_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			txtv_diyanat_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_diyanat_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("Scholarships in Turkey (2)");
			textview_tr_gov_head.setText("1. Government Scholarship");
			textview_gov_details.setText("🇹🇷🇹🇷🇹🇷🇹🇷 The Turkish grant has officially announced the opening date of the application for the year 2020 🇹🇷🇹🇷🇹🇷🇹🇷\n\nThe scholarship will open registration on:\n15-01-2020 and\n\nRegistration ends in:\n20-02-2020\n\nFor all academic levels (Bachelor, Master, PhD)\n\n\nTurkish Grant Benefits:\n\nGrant benefits are fully funded and cover all costs from university premiums to housing and health insurance allowance, travel and visa costs for applicants from outside Turkey, in addition to a monthly salary.\n\n• Monthly pension:\nBachelor's degree - 800 Turkish lira.\nMaster's - 1100 Turkish lira.\nPhD - 1600 Turkish lira.\n• The student accepted in the scholarship receives travel tickets paid by the country from the country in which he resides to Turkey and from Turkey to his country after the completion of the study permanently.\n• The student gets a student residency for the length of the study period paid by the state.\n• The state provides the student with free housing for the duration of the study period with housing expenses.\n• The state provides the student with free health insurance throughout the study period.\n• Students awarded the scholarship will have a full year of studying the Turkish language without any fees. Note that students enrolled in studies in another language (other than Turkish) must attend the year.\n• Complete course to learn Turkish as well.\n• Students awarded the scholarship will receive a card granting them the right to mobility, at a very reduced rate, supported by the country.\n\n\nAge condition:\n\nBachelor's degree is under 21 years old.\nThe master is less than 30 years old.\nPhD less than 35 years old.\nResearch is less than 45 years old.\n\n\nPaperwork :\n\n1) Certificate of educational qualification:\nA high school diploma for undergraduate applicants, a university certificate for masters applicants, or a university certificate and masters degree for PhD applicants.\nIn the event that the graduation certificate is not ready or remains on the graduation of the applicant for several months, an official stamped statement can be submitted stating that it is submitted to the site instead of the graduation certificate.\n\n2) The transcript reveals the student's grades in the subjects:\nFor high school graduates, it is the same high school diploma.\nAnd for university graduates and masters,\nIt is the detailed disclosure of subject grades during the school years.\n\n3) A recommendation letter [one or more] from a teacher or manager at work or from an institution: The recommendation message is submitted to the site in addition to the need to enter the email of the person writing the recommendation, where a message will be sent to him requesting confirmation that he is the person who wrote the recommendation.\n\n4) An identity document, such as a passport, identity card, birth certificate, or seat number.\n\n5) A clear, recent personal photo.\n\n6) Translate all papers (after receiving the acceptance letter and fixing the date of the interview)\n\nDocuments are required for some universities or majors only\n\n1) An accredited English language test certificate, if the chosen university requires a language certificate.\nAccredited certificates are TOEFL certificates.\n\nThe language certificate is available during application, and it must be prepared until the date of the interview.\n\n2) Certified Competency Examination Certificate (Skills), in case the chosen university requires it.\nThis certificate requires GMAT or GRE and is mostly for students applying for postgraduate studies, as an exam certificate.\n\nIf the required certificate is not available during the application period, it must be prepared until the date of the interview.\n\n1) Certificates of experience in previous work in which the applicant was enrolled.\n\n2) Certificates of participation in training or qualification courses or seminars.\n\n3) Honor's certificates in any field.\n\n4) Certificates of participation in voluntary service activities.\n\n5) Any certificate, document or other award obtained by the applicant except in school or work.\n\n\nThe required marks:\n\nBachelor's degree: Total must not be less than 70% The total number of students wishing to study medicine must not be less than 90%\n\nMaster's and PhD degrees: Total must not be less than 75%\n\n\nNoticeable :\n \nThe attached papers do not need translation or amendment if they are in English. Thank you.");
			button_gov_apply.setText("Apply Now!");
			txtv_tr_diyanat_head.setText("2. Diyanat Scholarship");
			txtv_diyanat_details.setText("The Diyanat Scholarship application has been scheduled.\n\nApplication Deadline: 1 February, 2020 - 15 March, 2020.\n\nThe Turkish Diyanat Foundation's scholarship is only for those who want to honors in high school level and Islamic studies.\n\nThere is no opportunity to study in any other department. The scholarship is not for Masters or PhD.");
			button_diyanat_apply.setText("Apply Now!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_tr_gov_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			textview_gov_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_gov_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			txtv_tr_diyanat_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			txtv_diyanat_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			button_diyanat_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
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
			textview_heading.setText("তুরস্কে বৃত্তি (২)");
			textview_tr_gov_head.setText("১. সরকারি বৃত্তি");
			textview_gov_details.setText("🇹🇷🇹🇷🇹🇷🇹🇷 তুর্কিতে বৃত্তি নিয়ে পড়াশুনার খুঁটিনাটি 🇹🇷🇹🇷🇹🇷🇹🇷\n\nতুরস্কে ফুল-ফ্রী সরকারী স্কলারশিপ এর আবেদন প্রক্রিয়া শুরু হয়েছে। চলবে ১০ জানুয়ারি থেকে ২০ ফেব্রুয়ারি পর্যন্ত।\n\n\nতুরস্ক সরকার প্রতি বছর সারা বিশ্বের পাঁচ হাজার শিক্ষার্থীকে ফুল ফান্ডেড স্কলারশিপ দিয়ে থাকে। তুর্কি সরকারের এই স্কলারশিপ সম্পর্কে বিস্তারিত:\n\nএই স্কলারশিপকে তুর্কি ভাষায় 'তুর্কিয়ে বুরসলারি' (TÜRKİYE BURSLARI) বলে।\n\n\n১. কাদের জন্য এই স্কলারশিপ?\nবাংলাদেশী শিক্ষার্থীসহ বিশ্বের সকল দেশের শিক্ষার্থীদের জন্য উন্মুক্ত এই স্কলারশিপ।\n\n\n২. যা যা থাকছে স্কলারশিপে:\n• সম্পূর্ণ টিউশন ফি।\n• মাসিক বৃত্তি (অনার্সের জন্য ৮০০ লিরা, মাস্টার্সের জন্য ১১০০ লিরা এবং পিএইচডির জন্য ১৬০০ লিরা)।\n• মূল কোর্স শুরু হওয়ার আগে এক বছরের ফ্রি তুর্কি ভাষা শিক্ষা কোর্স।\n• সরকারি/বেসরকারি ডর্মিটরিতে বিনামূল্যে থাকার ব্যবস্থা (সকাল ও রাতের খাবারসহ)।\n• প্রথমবার আসা ও কোর্স শেষে নিজদেশে যাওয়ার বিমান টিকেট (টার্কিশ এয়ারলাইন্সে)।\n• স্বাস্থ্যবীমা।\n\n\n৩. আবেদনকারীর যোগ্যতা:\n• আপনি তুরস্কের নাগরিক নন।\n• তুরস্কের কোন বিশ্ববিদ্যালয়ে এখনো ভর্তি হন নাই।\n• আপনি স্নাতক, স্নাতকোত্তর, পিএইচডি কিংবা রিসার্চ প্রোগ্রামের জন্য আবেদন করতে ইচ্ছুক।\n• আপনার যদি এসএসসি/দাখিল, এইএইচসি/আলিম পরীক্ষায় ৭০% মার্ক থাকে তাহলে অনার্সের জন্য, আর উল্লিখিত পরীক্ষাগুলো এবং অনার্সে ৭৫% মার্ক থাকে তাহলে মাস্টার্সের জন্য, আর মাস্টার্সসহ সকল পরীক্ষায় ৭৫% মার্ক থাকে তাহলে পিএইচডির জন্য আবেদন করতে পারবেন, তবে মেডিকেল ছাত্রদের বেলায় ৯০% মার্ক থাকতে হবে। \n• বয়স: \n - স্নাতকের জন্য আবেদন করতে বয়স হতে হবে ২১ বছরের নিচে।\n - স্নাতকোত্তরের জন্য আবেদন করতে বয়স হতে হবে ৩০ বছরের নিচে।\n - পিএইচডির জন্য আবেদন করতে বয়স হতে হবে ৩৫ বছরের নিচে।\n - রিসার্চ প্রোগ্রামের জন্য আবেদন করতে বয়স হতে হবে ৪৫ বছরের নিচে।\n\nবি: দ্র: সাধারণত টার্কিশ স্কলারশিপে আবেদন করার জন্য IELTS/TOFEL এর দরকার হয় না, তবে আপনি যে সকল ইউনিভার্সিটিতে আবেদন করবেন, যদি ঐ সকল  ইউনিভার্সিটির রিকোয়ারমেন্টে IELTS/TOFEL চেয়ে থাকে তাহলে IELTS/TOFEL স্কোর লাগবে। তবে আপনার যদি ইতিমধ্যে IELTS/TOFEL, GRE, GMAT ইত্যাদি করা থাকে তাহলে তা অবশ্যই আবেদনের সময় তার স্কোর ও সার্টিফিকেট সাবমিট করবেন।\n\n\n৪. আবেদনের সময়কাল:\nপ্রতি বছর জানুয়ারিতে আবেদন প্রক্রিয়া শুরু হয়ে ফেব্রুয়ারিতে শেষ হয়। ২০১৯ সালে জানুয়ারির ১৫ তারিখ থেকে ফেব্রুয়ারির ২৪ তারিখ পর্যন্ত আবেদন গ্রহণ করা হয়েছে।\n\n\n৫. আবেদনের জন্য প্রয়োজনীয় কাগজপত্র:\n• জাতীয় পরিচয়পত্র অথবা পাসপোর্ট বা জন্ম সনদের ইংরেজি কপি। (পাসপোর্ট দেওয়াই ভালো)\n• প্রাতিষ্ঠানিক সকল পরীক্ষার সনদপত্র।\n• প্রাতিষ্ঠানিক সকল পরীক্ষার ট্রান্সক্রিপ্ট।\n• সদ্যতোলা এক কপি পাসপোর্ট সাইজ ছবি।\n• IELTS/TOFEL, GRE, GMAT ইত্যাদির সার্টিফিকেট। (যদি আপনার আবেদনকৃত বিশ্ববিদ্যালয় সেগুলো চেয়ে থাকে)\n• ২ টি রেফারেন্স লেটার।\nউপরোক্ত সকল ডকুমেন্ট স্ক্যান করে পিডিএফ ফাইল বানিয়ে আপলোড করতে হবে।\nএবং Statement of Purpose (SOP) এবং  কিছু প্রশ্নের উত্তরের উপর ভিত্তি করে Letter of Intent. (এগুলো আবেদনের সময় সরাসরি লিখতে হবে, আলাদা কাগজে লিখে আপলোড করতে হবে না)\n\n\n৬. আবেদন পদ্ধতি:\nআবেদন প্রক্রিয়া সম্পূর্ণ অনলাইনে সম্পন্ন করতে হবে। এই প্রক্রিয়া খুবই সহজ, তবে একটু দীর্ঘ সময়ের কাজ। তুর্কিয়ে বুরসলারির ওয়েবসাইটে গিয়ে আপনার সচল একটি ইমেইল দিয়ে একাউন্ট খুলে একে একে সকল তথ্যাবলি দিয়ে পূরণ করতে থাকুন। এক স্টেপ শেষ করে সেভ দিয়ে আরেক স্টেপে চলে যাবেন। খুবই সহজ পদ্ধতি। \n\nআর হ্যাঁ, আপনাকে কিন্তু একবারেই সমস্তটা পূরণ করতে হবে না। যখনই সময় হবে, ঠান্ডা মাথায় একাউন্টে লগ ইন করে একে একে সমস্ত তথ্য পূরণ করতে পারেন। যত খুশি ততবার লগ ইন করতে পারবেন। সুতরাং খুব জলদি করতে হবে, একদিনেই করতে হবে এমন কিন্তু না। সকল সার্টিফিকেট, মার্কশীট, রেফারেন্স লেটার, অন্যান্য সার্টিফিকেট পিডিএফ করে আপলোড করবেন।\n\nহাতে সময় নিয়ে করুন, আবেদনের শেষ সময়ে করবেন না। ওখানে Statement of Purpose এবং Letter Intent লেখার অপশন থাকবে, ধীরে ধীরে এগুলো পূরণ করবেন। আপনার Extra-Curricular Activities, Social Works, Award কিংবা Volunteering কার্যক্রমের সার্টিফিকেট থাকলে তা আপলোড করার অপশন থাকবে এবং সেগুলোর ছোট বর্ণনাও লিখতে হবে। \n\nসকল ডকুমেন্ট আপলোড করার পর আপনার আপলোডকৃত তথ্যের ওপর ভিত্তি করে আপনাকে সাবজেক্ট ও ইউনিভার্সিটির লিস্ট দেওয়া হবে। আপনি সেখান থেকে সর্বোচ্চ ১২টি ইউনিভার্সিটিতে আবেদন করতে পারবেন। অবশ্যই আপনি গুগলে সার্চ করে সরবরাহকৃত ইউনিভার্সিটিগুলোর র‍্যাঙ্কিংসহ বিস্তারিত জেনে নিবেন। মনে রাখবেন আপনি প্রথম পছন্দ যে ইউনিভার্সিটি দিবেন, সেটাকেই অথোরিটি বেশি প্রায়োরিটি দিবে। তবে ব্যতিক্রমও হয়।\n\nসম্পূর্ণ পূরণ করার পর আপনি ফাইনাল চেক করার সুযোগ পাবেন এবং প্রয়োজনীয় এডিট করে সাবমিট করবেন।\n\n\n৭. স্কলারশিপ প্রাপ্তির জন্য সহায়ক কার্যক্রম:\nএখানে একটা বিষয় পরিষ্কারভাবে জেনে রাখুন, টার্কিশ স্কলারশিপ কেবলমাত্র রেজাল্টের উপর ভিত্তি করে দেয়া হয় না। রেজাল্ট অবশ্যই একটা বিবেচ্য বিষয়, তবে স্কলারশিপ কমিটি আপনার রেজাল্টের পাশাপাশি আপনার এক্সট্রা কারিকুলার এক্টিভিটিস, ভলান্টিয়ারিং কার্যক্রমের উপর বেশ নজর দিবে। এখানে Extra-Curricular Activities বলতে কনফারেন্স, সেমিনার, ওয়ার্কশপ, সোশ্যাল ওয়ার্ক, সামার ক্যাম্প, ভলান্টিয়ারিং কার্যক্রম ইত্যাদিতে অংশগ্রহণ।\n\nঅনেকের প্রশ্ন থাকে, এমন সহায়ক কতটি সার্টিফিকেট লাগবে? উত্তর, এর কোনো সীমাবদ্ধতা নেই। বাঁধাধরা নিয়মও নেই। আপনি যতগুলোতে অংশগ্রহণ করেছেন সকল সার্টিফিকেট আপলোড করবেন। তবে এখানে বলে রাখা ভালো আপনি যে সাবজেক্টের জন্য আবেদন করেছেন সেই সাবজেক্ট রিলেটেড প্রোগ্রামে অংশগ্রহণের সার্টিফিকেট দিতে পারলেই বেশি ভালো। \n\nতবে আপনার যদি কোনো সার্টিফিকেটই না থাকে তাহলে কি আপনি এপ্লাই করবেন না? আপনি তবুও এপ্লাই করুন। তবে অবশ্যই এক্সট্রা কারিকুলার এক্টিভিটিস আপনাকে স্কলারশিপ পাওয়ার ক্ষেত্রে অন্যদের থেকে এগিয়ে রাখবে।\n\n\n৮. Letter of Intent কি?\nতুর্কি সরকারি স্কলারশিপ পাওয়ার জন্য গুরুত্বপূর্ণ ভূমিকা পালন করে এই লেটার অফ ইন্টেন্ট। এবার আসুন জেনে নিই আসলে লেটার অফ ইন্টেন্ট কি জিনিস। লেটার অফ ইন্টেন্ট চাকরির ক্ষেত্রে এক রকম আর স্কলারশিপের ক্ষেত্রে আরেক রকম। তবে টার্কিশ স্কলারশিপের ক্ষেত্রে Letter of Intent বলতে বুঝায়, এই অপশনে ৫/৬টি প্রশ্ন থাকবে। যেগুলো আপনি কি নিয়ে থিসিস করতে চান এই সম্পর্কিত। \n\nপ্রতিটি প্রশ্নে আপনার বিষয় সম্পর্কিত কিংবা আপনার পছন্দের টপিকে থিসিসের বিস্তারিত জানতে চাওয়া হয়। এই যেমন আপনার থিসিসের নাম, অবজেক্টিভ, রিসার্স মেথড, লিটারেচার রিভিউ, কন্ট্রিবিউশন ইত্যাদি নিয়ে প্রশ্ন থাকবে। অবশ্যই প্রতিটা প্রশ্নের উত্তরের জন্য শব্দের সীমাবদ্ধতা (Word Limit) থাকবে। (এটা অবশ্য মাস্টার্স ও পিএইচডিতে আবেদনকারীদের ক্ষেত্রে প্রযোজ্য)\n\n\n৯. Statement of Purpose (SOP) এ কি লিখবেন?\nতুর্কি স্কলারশিপ পাওয়ার জন্য আরেকটি অত্যন্ত গুরুত্বপূর্ণ বিষয় হচ্ছে SOP। এখানে বলে রাখা ভালো, অনার্সের আবেদনের ক্ষেত্রে Letter of Intent বা Personal Essay মানেই SOP। তাই সকল আবেদনকারীর জন্য এটা খুবই গুরুত্বপূর্ণ। কি কি বিষয় লিখবেন তা স্কলারশিপ অথোরিটি আপনাকে হিন্টস দিয়ে দিবে। \n\nযেমন- আপনি যে বিষয়ের জন্য আবেদন করছেন সে বিষয় সম্পর্কিত আপনার একাডেমিক এবং সামাজিক অভিজ্ঞতা, উচ্চ শিক্ষার জন্য তুরস্ককে পছন্দের কারণ, আপনার ডিগ্রি বা শিক্ষা এবং তুরস্কের বৃত্তির জন্য আপনার ভবিষ্যৎ পরিকল্পনার গুরুত্ব ইত্যাদি বিষয়ে একটি রচনা লিখবেন।\n\nআপনাকে নির্দিষ্ট কোনো ফরম্যাট ফলো করে লিখতে হবে না। নিজের মতো করে লিখবেন, তবে তা যেন আবার আপনার সমগ্র জীবনের বৃত্তান্ত না হয়ে যায়। তাহলে লেখা খুব বেশি বড় হয়ে যাবে। আবার একেবারে ছোটও লিখবেন না। মোটামুটি ৫০০ শব্দ ৩০০০ ক্যারেক্টারের মধ্যে লিখে ফেলবেন।\n\nএখানে একটা কথা ভালোভাবে মাথায় রাখুন, কখনোই এটা আপনি আপনার কোনো বন্ধু, বড় ভাই, শিক্ষক বা অন্য কাউকে দিয়ে লিখিয়ে নিবেন না। খুব শক্ত, কঠিন ইংরেজি শব্দ ব্যবহার করবেন না। আপনার নিজের ভাষায় সহজ করে লিখুন। এটাই সেরা অপশন। মনে রাখবেন আপনি স্কলারশিপ অথোরিটিকে ফাঁকি দিতে পারবেন না।\n\n\n১০. Reference Letter কার থেকে নিবেন?\nএই স্কলারশিপের জন্য দুইটি রেফারেন্স লেটার বা রিকমেন্ডেশন লেটার বাধ্যতামূলক। এখন প্রশ্ন হচ্ছে আপনি কাদের থেকে নিবেন এই রেফারেন্স লেটার? সবচেয়ে ভালো হচ্ছে আপনার শিক্ষকের থেকে নিলে, যেখানে আপনার শিক্ষক আপনার সম্পর্কে লিখবে, আপনার আবেদনকৃত বিষয়ের সাথে সঙ্গতিপূর্ণ কোনো শিক্ষক থেকে নিবেন। \n\nঅথবা যিনি আপনার থিসিসের এডভাইজার ছিলেন কিংবা আপনার সম্পর্কে ভালো জানেন। তাঁদের থেকেই নিন। মনে রাখবেন আপনি যাদের থেকে রেফারেন্স লেটার নিয়েছেন, তাদের নাম্বার ও ইমেইল আবেদনের সময় একটা অপশনে জমা দিতে হবে। স্কলারশিপ অথোরিটি তাদের সাথে পরবর্তীতে যোগাযোগ করবে। সাধারণত তারা রেফারিকে মেইল দেয়।\n\n\n১১. ইন্টারভিউ:\nতুর্কি স্কলারশিপ প্রক্রিয়া অনেক দীর্ঘ। আবেদন করার প্রায় ২ থেকে ৩ মাস পর ভাইভার জন্য ডাকে। অবশ্য এর কারণও আছে। প্রতি বছর প্রায় লক্ষাধিক এপ্লিকেশন জমা পড়ে, সেখান থেকে খুবই সতর্কতার সাথে স্কলারশিপ কমিটি বাছাইকৃতদের ভাইভাতে ডাকে। মনে রাখা দরকার ভাইভাতে ডাক পাওয়া মানেই চান্স পাওয়া নয়। ভাইভায় টার্কিশ প্রফেসররা আপনাকে কিছু প্রশ্ন করবে এবং আবেদনের সময় আপনার সরবরাহকৃত সকল ডকুমেন্টসের মূলকপিগুলো দেখবে। ভাইভা স্বাভাবিকভাবে ইংরেজিতেই হবে, তবে আপনি চাইলে বাংলাতেও দিতে পারবেন, সেখানে দোভাষী থাকে।\n\nইন্টার্ভিউ দিতে যাওয়ার আগে আপনি যে সকল ইউনিভার্সিটিতে যে সকল সাবজেক্টের জন্য এপ্লাই করেছেন সেগুলো সম্পর্কে মোটামুটি প্রস্তুতি নিয়ে যাবেন। আপনাকে আপনার আবেদনকৃত সাবজেক্ট সম্পর্কে এবং তুরস্ক সম্পর্কে প্রাথমিক কিছু বিষয়ে জিজ্ঞেস করবে। কেন তুরস্কতে পড়তে চান? কেন এই সাবজেক্টে আপনার আগ্রহ? তুর্কি ভাষায় পড়তে চান কিনা? অন্য কোথাও আবেদন করেছেন কিনা? আপনার এই সাবজেক্ট আপনার দেশের কি উপকারে লাগেব?  আপনার ফিউচার প্লান কি? দেশে ফিরে যাবেন কিনা? ইত্যাদি প্রশ্ন করবে। \n\nএক্সাক্ট আপনাকে কি জিজ্ঞেস করবে সেটা কেউ বলতে পারবে না। তবে ভয় পাওয়ার কিছু নেই। উনারা খুবই আন্তরিক ও হেল্পফুল। আপনার সাথে খুব মজা করে কথা বলবে, খুব সহজ ইংরেজিতে। আপনার কেবল কনফিডেন্স রাখলেই হবে।\n\n\n১২. তুর্কি ভাষা শেখা কি বাধ্যমূলক?\nআপনি যে স্তরের জন্যই তুর্কি স্কলারশিপ পান, আপনাকে প্রথমে এক বছরের ভাষা কোর্স করতে হবে। এটা সবার জন্য বাধ্যতামূলক। এমনকি আপনি যদি ইংরেজি মাধ্যমে পড়ার জন্য স্কলারশিপ পান তবুও। তবে কিছু ব্যতিক্রম আছে, যদি আপনি যে ইউনিভার্সিটিতে স্কলারশিপ পেয়েছেন, সে ইউনিভার্সিটির সাথে স্কলারশিপ অথোরিটির (YTB) চুক্তি থাকে যে ইংরেজি মাধ্যমে হলে ভাষা কোর্স করা লাগবে না, তাহলে আপনি সরাসরি মূল কোর্সে চলে যেতে পারবেন।\n\nতবে আপনি ফ্রিতে বিশ্বের বিভিন্ন দেশের শিক্ষার্থীদের সাথে নতুন একটি ভাষা শিখবেন, নতুন এক অভিজ্ঞতা হবে, এটা মন্দ কিসের?\n\n\n১৩. কোনো এজেন্টের সহয়তা নিবেন কি?\nএখানে একবাক্যে বলবো ‘না’। আপনি কোনো এজেন্ট থেকে কোনো প্রকার সহায়তা নিবেন না। সব নিজে নিজে করবেন। এপ্লাই করার জন্য কোনো টাকা লাগে না। অনেকে অফার করবে এত টাকা দিলে এপ্লাই করে দিবো, নিশ্চিত স্কলারশিপ পাইয়ে দিবো, এমন কোনো ফাঁদে পা দিবেন না।\n\n\n১৪. বাংলাদেশ থেকে প্রতিবছর টার্কিশ স্কলারশিপ পাওয়ার হার কেমন?\n২০১৯ সালে বিশ্বের ১৭৫ টি দেশের ৫০০০ জন শিক্ষার্থী এই স্কলারশিপ পেয়েছে। তারমধ্যে বাংলাদেশ থেকে ৬৩ জন চান্স পেয়েছে। বাংলাদেশ থেকে প্রায় ৬০০০ আবেদনকারীর মধ্যে ১৫৩ জন ভাইভা দিয়েছিলো। প্রতিবছরই ৫০+ শিক্ষার্থী বাংলাদেশ থেকে এই স্কলারশিপ পেয়ে আসছে। সুতরাং বুঝাই যাচ্ছে যেমন তীব্র প্রতিযোগিতা হয় তেমনই স্কলারশিপ পাওয়ার হারও খারাপ নয়।\n\nতুরস্ক আন্তর্জাতিক শিক্ষার্থীদের জন্য খুব পছন্দের একটি গন্তব্য। সব ধরনের মানুষের আনাগোনা এখানে। তাহলে আর কি, আপনার উচ্চশিক্ষার ঠিকানাও হোক তুরস্ক। সুতরাং এখন থেকেই শুরু করুন প্রস্তুতি। অবশ্যই আপনি সফল হবেন ইনশা-আল্লাহ।");
			button_gov_apply.setText("এখন‌ই আবেদন করুন!");
			txtv_tr_diyanat_head.setText("২. দিয়ানাত বৃত্তি");
			txtv_diyanat_details.setText("তুর্কি দিয়ানাত স্কলারশিপ আবেদনের সময় নির্ধারণ করা হয়েছে।\n\nআবেদনের সময়সীমা: ০১ ফেব্রুয়ারি, ২০২০ থেকে ১৫ মার্চ, ২০২০ পর্যন্ত।\n\nতুর্কি দিয়ানাত ফাউন্ডেশনের স্কলারশিপ শুধুমাত্র হাইস্কুল লেভেল এবং ইসলামিক স্টাডিজে যারা অনার্স করতে চান তাদের জন্য। \n\nঅন্য কোন ডিপার্টমেন্টে পড়ার সুযোগ এখানে নেই। মাস্টার্স অথবা পিএইচডির জন্য ও স্কলারশিপ নেই। \n\nযারা মাদরাসা থেকে দাখিল এবং আলিম শেষ করেছেন তারা আবেদন করতে পারেন।");
			button_diyanat_apply.setText("এখন‌ই আবেদন করুন!");
			textview_heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_tr_gov_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_gov_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_gov_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			txtv_tr_diyanat_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			txtv_diyanat_details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			button_diyanat_apply.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			textview_heading.setTextSize((float)25);
			textview_tr_gov_head.setTextSize((float)25);
			textview_gov_details.setTextSize((float)23);
			button_gov_apply.setTextSize((float)23);
			txtv_tr_diyanat_head.setTextSize((float)25);
			txtv_diyanat_details.setTextSize((float)23);
			button_diyanat_apply.setTextSize((float)23);
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

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
import android.widget.ProgressBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.webkit.WebViewClient;
import android.view.View;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class BrowserActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private LinearLayout browser_linear;
	private LinearLayout webview_linear;
	private LinearLayout web_menu_linear;
	private ProgressBar progressbar1;
	private WebView webview1;
	private LinearLayout back_linear;
	private LinearLayout forward_linear;
	private LinearLayout refresh_linear;
	private LinearLayout cancel_linear;
	private LinearLayout exit_linear;
	private ImageView back_imageview;
	private TextView back_textview;
	private ImageView forward_imageview;
	private TextView forward_textview;
	private ImageView refresh_imageview;
	private TextView refresh_textview;
	private ImageView cancel_imageview;
	private TextView cancel_textview;
	private ImageView exit_imageview;
	private TextView exit_textview;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private SharedPreferences spbr;
	private AlertDialog.Builder d;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.browser);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		browser_linear = (LinearLayout) findViewById(R.id.browser_linear);
		webview_linear = (LinearLayout) findViewById(R.id.webview_linear);
		web_menu_linear = (LinearLayout) findViewById(R.id.web_menu_linear);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		back_linear = (LinearLayout) findViewById(R.id.back_linear);
		forward_linear = (LinearLayout) findViewById(R.id.forward_linear);
		refresh_linear = (LinearLayout) findViewById(R.id.refresh_linear);
		cancel_linear = (LinearLayout) findViewById(R.id.cancel_linear);
		exit_linear = (LinearLayout) findViewById(R.id.exit_linear);
		back_imageview = (ImageView) findViewById(R.id.back_imageview);
		back_textview = (TextView) findViewById(R.id.back_textview);
		forward_imageview = (ImageView) findViewById(R.id.forward_imageview);
		forward_textview = (TextView) findViewById(R.id.forward_textview);
		refresh_imageview = (ImageView) findViewById(R.id.refresh_imageview);
		refresh_textview = (TextView) findViewById(R.id.refresh_textview);
		cancel_imageview = (ImageView) findViewById(R.id.cancel_imageview);
		cancel_textview = (TextView) findViewById(R.id.cancel_textview);
		exit_imageview = (ImageView) findViewById(R.id.exit_imageview);
		exit_textview = (TextView) findViewById(R.id.exit_textview);
		sp = getSharedPreferences("Language", Activity.MODE_PRIVATE);
		spbr = getSharedPreferences("Browser", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		req = new RequestNetwork(this);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				progressbar1.setVisibility(View.VISIBLE);
				refresh_linear.setVisibility(View.GONE);
				cancel_linear.setVisibility(View.VISIBLE);
				if (sp.getString("Language", "").equals("ar")) {
					SketchwareUtil.showMessage(getApplicationContext(), "أرجو الإنتظار...");
				}
				if (sp.getString("Language", "").equals("en")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Please wait...");
				}
				if (sp.getString("Language", "").equals("bn")) {
					SketchwareUtil.showMessage(getApplicationContext(), "অনুগ্রহপূর্বক অপেক্ষা করুন...");
				}
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				progressbar1.setVisibility(View.GONE);
				refresh_linear.setVisibility(View.VISIBLE);
				cancel_linear.setVisibility(View.GONE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		back_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#bdbdbd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
				back_linear.setBackground(ripdr);
				if (webview1.canGoBack()) {
					webview1.goBack();
				}
			}
		});
		
		forward_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#bdbdbd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
				forward_linear.setBackground(ripdr);
				if (webview1.canGoForward()) {
					webview1.goForward();
				}
			}
		});
		
		refresh_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#bdbdbd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
				refresh_linear.setBackground(ripdr);
				webview1.reload();
				refresh_linear.setVisibility(View.GONE);
				cancel_linear.setVisibility(View.VISIBLE);
			}
		});
		
		cancel_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#bdbdbd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
				cancel_linear.setBackground(ripdr);
				webview1.stopLoading();
				cancel_linear.setVisibility(View.GONE);
				refresh_linear.setVisibility(View.VISIBLE);
			}
		});
		
		exit_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#bdbdbd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff")), null);
				exit_linear.setBackground(ripdr);
				if (sp.getString("Language", "").equals("ar")) {
					d.setTitle("هل تريد الخروج حقا؟");
					d.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							spbr.edit().remove("Browser").commit();
							finish();
						}
					});
					d.setNegativeButton("لا", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
				}
				if (sp.getString("Language", "").equals("en")) {
					d.setTitle("Do you really want to exit?");
					d.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							spbr.edit().remove("Browser").commit();
							finish();
						}
					});
					d.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
				}
				if (sp.getString("Language", "").equals("bn")) {
					d.setTitle("আপনি কি আসলেই বের হতে চান?");
					d.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							spbr.edit().remove("Browser").commit();
							finish();
						}
					});
					d.setNegativeButton("না", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
				}
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
				i.setClass(getApplicationContext(), BrowserErrorActivity.class);
				startActivity(i);
				finish();
			}
		};
	}
	private void initializeLogic() {
		refresh_linear.setVisibility(View.GONE);
		cancel_linear.setVisibility(View.VISIBLE);
		if (spbr.getString("Browser", "").equals("tur_gov")) {
			webview1.loadUrl("https://tbbs.turkiyeburslari.gov.tr");
		}
		if (spbr.getString("Browser", "").equals("tur_diyanat")) {
			webview1.loadUrl("https://diyanetburslari.tdv.org");
		}
		if (spbr.getString("Browser", "").equals("brn_gov")) {
			webview1.loadUrl("http://mfa.gov.bn/Pages/BDGS.aspx");
		}
		if (spbr.getString("Browser", "").equals("qat_hbku")) {
			webview1.loadUrl("https://www.hbku.edu.qa/ar/admissions#tab1249");
		}
		if (spbr.getString("Browser", "").equals("sau_iu_web")) {
			webview1.loadUrl("https://iu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_iu_apply")) {
			webview1.loadUrl("https://admission.iu.edu.sa/VarificationCodeNew.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_iu_check")) {
			webview1.loadUrl("https://admission.iu.edu.sa/Inquiry.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_iu_allin1")) {
			webview1.loadUrl("https://admission.iu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_kauM_web")) {
			webview1.loadUrl("https://www.kau.edu.sa/Home.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_kauM_apply")) {
			webview1.loadUrl("https://dcafl.kau.edu.sa/REGISTER.ASP");
		}
		if (spbr.getString("Browser", "").equals("sau_kauM_check")) {
			webview1.loadUrl("https://dcafl.kau.edu.sa/LOGIN.ASP");
		}
		if (spbr.getString("Browser", "").equals("sau_kauH_web")) {
			webview1.loadUrl("https://www.kau.edu.sa/Home.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_kauH_apply")) {
			webview1.loadUrl("https://outadmission.kau.edu.sa/ADM_FOLLOW.ASP");
		}
		if (spbr.getString("Browser", "").equals("sau_kauH_check")) {
			webview1.loadUrl("https://outadmission.kau.edu.sa/LOGIN.ASP");
		}
		if (spbr.getString("Browser", "").equals("sau_ksu_web")) {
			webview1.loadUrl("https://www.ksu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_ksu_apply")) {
			webview1.loadUrl("https://ali-admit.ksu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_ksu_check")) {
			webview1.loadUrl("https://ali-admit.ksu.edu.sa/login.html");
		}
		if (spbr.getString("Browser", "").equals("sau_uqu_web")) {
			webview1.loadUrl("https://uqu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_uqu_apply")) {
			webview1.loadUrl("https://uquweb.uqu.edu.sa/admission/ui/register");
		}
		if (spbr.getString("Browser", "").equals("sau_uqu_check")) {
			webview1.loadUrl("https://uquweb.uqu.edu.sa/admission/ui/login");
		}
		if (spbr.getString("Browser", "").equals("sau_uqu_allin1")) {
			webview1.loadUrl("https://uquweb.uqu.edu.sa/admission");
		}
		if (spbr.getString("Browser", "").equals("sau_imamu_web")) {
			webview1.loadUrl("https://imamu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_imamu_apply")) {
			webview1.loadUrl("https://menha.imamu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_imamu_check")) {
			webview1.loadUrl("https://menha.imamu.edu.sa/#!/login");
		}
		if (spbr.getString("Browser", "").equals("sau_nu_web")) {
			webview1.loadUrl("https://www.nu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_nu_apply")) {
			webview1.loadUrl("https://edugate.nu.edu.sa/nu/ui/guest/application_online/index/forwardTypeApplicationOnline.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_nu_check")) {
			webview1.loadUrl("https://edugate.nu.edu.sa/nu/ui/guest/application_online/index/forwardTypeApplicationOnline.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_pnu_web")) {
			webview1.loadUrl("https://www.pnu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_pnu_apply")) {
			webview1.loadUrl("https://www.pnu.edu.sa/en/announcements/pages/announcements23745.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_pnu_check")) {
			webview1.loadUrl("");
		}
		if (spbr.getString("Browser", "").equals("sau_tu_web")) {
			webview1.loadUrl("https://www.tu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_tu_apply")) {
			webview1.loadUrl("https://webapps.tu.edu.sa/admission/%D8%A7%D9%84%D9%85%D9%86%D8%AD-%D8%A7%D9%84%D8%AE%D8%A7%D8%B1%D8%AC%D9%8A%D8%A9?fbclid=IwAR3PRWNRHS0ZAoOclXdls4iYmzPdn6");
		}
		if (spbr.getString("Browser", "").equals("sau_tu_check")) {
			webview1.loadUrl("https://webapps.tu.edu.sa/admission/%D8%A7%D9%84%D9%85%D9%86%D8%AD-%D8%A7%D9%84%D8%AE%D8%A7%D8%B1%D8%AC%D9%8A%D8%A9?fbclid=IwAR3PRWNRHS0ZAoOclXdls4iYmzPdn6");
		}
		if (spbr.getString("Browser", "").equals("sau_mu_web")) {
			webview1.loadUrl("https://mu.edu.sa/mu/ui/home.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_mu_apply")) {
			webview1.loadUrl("https://edugate.mu.edu.sa/mu/ui/home.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_mu_check")) {
			webview1.loadUrl("https://edugate.mu.edu.sa/mu/ui/home.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_nbu_web")) {
			webview1.loadUrl("https://nbu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_nbu_apply")) {
			if (sp.getString("Language", "").equals("ar")) {
				webview1.loadUrl("https://scholarship.nbu.edu.sa/main_ar.aspx");
			}
			if (sp.getString("Language", "").equals("en")) {
				webview1.loadUrl("https://scholarship.nbu.edu.sa/main_en.aspx");
			}
			if (sp.getString("Language", "").equals("bn")) {
				webview1.loadUrl("https://scholarship.nbu.edu.sa/main_en.aspx");
			}
		}
		if (spbr.getString("Browser", "").equals("sau_nbu_check")) {
			webview1.loadUrl("https://scholarship.nbu.edu.sa/query/arquery.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_ju_web")) {
			webview1.loadUrl("https://ju.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_ju_apply")) {
			webview1.loadUrl("https://edug.ju.edu.sa/ju/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_ju_check")) {
			webview1.loadUrl("https://edug.ju.edu.sa/ju/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_uhb_web")) {
			webview1.loadUrl("https://www.uhb.edu.sa/ar/Pages/default.aspx");
		}
		if (spbr.getString("Browser", "").equals("sau_uhb_apply")) {
			webview1.loadUrl("https://www.uhbscholarship.rf.gd/scholarships/uhb");
		}
		if (spbr.getString("Browser", "").equals("sau_uhb_check")) {
			webview1.loadUrl("https://www.uhbscholarship.rf.gd/scholarships/uhb/login.php");
		}
		if (spbr.getString("Browser", "").equals("sau_taibahu_web")) {
			webview1.loadUrl("https://taibahu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_taibahu_apply")) {
			webview1.loadUrl("https://eas.taibahu.edu.sa/AdmExternalScholarShip/");
		}
		if (spbr.getString("Browser", "").equals("sau_taibahu_check")) {
			webview1.loadUrl("");
		}
		if (spbr.getString("Browser", "").equals("sau_jazanu_web")) {
			webview1.loadUrl("https://jazanu.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_jazanu_apply")) {
			webview1.loadUrl("https://edugate.jazanu.edu.sa/jazan/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_jazanu_check")) {
			webview1.loadUrl("https://edugate.jazanu.edu.sa/jazan/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_ut_web")) {
			webview1.loadUrl("https://ut.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_ut_apply")) {
			webview1.loadUrl("https://myut.ut.edu.sa/ut/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_ut_check")) {
			webview1.loadUrl("https://myut.ut.edu.sa/ut/ui/guest/request_scholarship/index/steeringScholarshipIndex.faces");
		}
		if (spbr.getString("Browser", "").equals("sau_iau_web")) {
			webview1.loadUrl("https://www.iau.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_iau_apply")) {
			webview1.loadUrl("https://www.iau.edu.sa/ar/administration/deanships/deanship-of-admissions-and-registration/external-grants-and-scholarships");
		}
		if (spbr.getString("Browser", "").equals("sau_iau_check")) {
			webview1.loadUrl("https://sis.iau.edu.sa/psp/hcs9prd/?cmd=login&languageCd=ARA");
		}
		if (spbr.getString("Browser", "").equals("sau_kku_web")) {
			webview1.loadUrl("https://kku.edu.sa");
		}
		if (spbr.getString("Browser", "").equals("sau_kku_apply")) {
			webview1.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdApCttjUcpKZowa8WQxxljxq7EgobsqyPJb-Bsfj-uaSWY5g/viewform");
		}
		if (spbr.getString("Browser", "").equals("sau_kku_check")) {
			webview1.loadUrl("");
		}
		if (spbr.getString("Browser", "").equals("sau_isdb_web")) {
			webview1.loadUrl("https://www.isdb.org");
		}
		if (spbr.getString("Browser", "").equals("sau_isdb_apply")) {
			webview1.loadUrl("https://isdbscholarships.smartsimple.com/s_signup.jsp?token=XVtQC1oGZV9eQRdeRQpSRVJTZVxwBnNqHGRZ");
		}
		if (spbr.getString("Browser", "").equals("sau_isdb_check")) {
			webview1.loadUrl("https://isdbscholarships.smartsimple.com/s_Login.jsp");
		}
		_upload_download();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
			}
			break;
			
			case REQUEST_SELECT_FILE:
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				if (uploadMessage == null) return; uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(_resultCode, _data)); uploadMessage = null; }
			break;
			
			case FILECHOOSER_RESULTCODE:
			if (null == mUploadMessage){
				return; }
			Uri result = _data == null || _resultCode != RESULT_OK ? null : _data.getData(); mUploadMessage.onReceiveValue(result);
			mUploadMessage = null;
			
			if (true){
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (webview1.canGoBack()) {
			webview1.goBack();
		}
		else {
			if (sp.getString("Language", "").equals("ar")) {
				d.setTitle("هل تريد الخروج حقا؟");
				d.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						spbr.edit().remove("Browser").commit();
						finish();
					}
				});
				d.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
			if (sp.getString("Language", "").equals("en")) {
				d.setTitle("Do you really want to exit?");
				d.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						spbr.edit().remove("Browser").commit();
						finish();
					}
				});
				d.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
			if (sp.getString("Language", "").equals("bn")) {
				d.setTitle("আপনি কি আসলেই বের হতে চান?");
				d.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						spbr.edit().remove("Browser").commit();
						finish();
					}
				});
				d.setNegativeButton("না", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		req.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "a", _req_request_listener);
		if (sp.getString("Language", "").equals("ar")) {
			back_textview.setText("الخلف");
			forward_textview.setText("الأمام");
			refresh_textview.setText("تحديث");
			cancel_textview.setText("إلغاء");
			exit_textview.setText("خروج");
			back_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			forward_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			refresh_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			cancel_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			exit_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
		}
		if (sp.getString("Language", "").equals("en")) {
			back_textview.setText("Back");
			forward_textview.setText("Forward");
			refresh_textview.setText("Refresh");
			cancel_textview.setText("Cancel");
			exit_textview.setText("Exit");
			back_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			forward_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			refresh_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			cancel_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
			exit_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/el_messiri_regular.ttf"), 1);
		}
		if (sp.getString("Language", "").equals("bn")) {
			back_textview.setText("পূর্ববর্তী");
			forward_textview.setText("পরবর্তী");
			refresh_textview.setText("নবায়ন");
			cancel_textview.setText("বাতিল");
			exit_textview.setText("বাহির");
			back_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			forward_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			refresh_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			cancel_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			exit_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/shorif_sandwip.ttf"), 0);
			back_textview.setTextSize((float)14);
			forward_textview.setTextSize((float)14);
			refresh_textview.setTextSize((float)14);
			cancel_textview.setTextSize((float)14);
			exit_textview.setTextSize((float)14);
		}
	}
	private void _upload_download () {
		webview1.setWebChromeClient(new WebChromeClient());
		final WebSettings webSettings = webview1.getSettings();
		final String newUserAgent; newUserAgent = "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/79.0.3945.136 Safari/605.1.15";
		webSettings.setUserAgentString(newUserAgent);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
			webSettings.setAllowFileAccessFromFileURLs(true); 
			webSettings.setAllowUniversalAccessFromFileURLs(true);
		}
		webview1.getSettings().setBuiltInZoomControls(true);webview1.getSettings().setDisplayZoomControls(false);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(true);
		webview1.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
		webview1.getSettings().setAppCacheEnabled(true);
		webview1.getSettings().setAllowFileAccess(true);
		webview1.getSettings().setDomStorageEnabled(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webview1.loadUrl(webview1.getUrl());
		//download
		webview1.setDownloadListener(new DownloadListener() { 
			@Override 
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) { 
				DownloadManager.Request request = new DownloadManager.Request( Uri.parse(url)); request.setMimeType(mimeType); String cookies = CookieManager.getInstance().getCookie(url); request.addRequestHeader("cookie", cookies); request.addRequestHeader("User-Agent", userAgent); if (sp.getString("Language", "").equals("ar")) {
						request.setDescription("جارى التحميل...");
						}
						if (sp.getString("Language", "").equals("en")) {
						request.setDescription("Downloading...");
						}
						if (sp.getString("Language", "").equals("bn")) {
						request.setDescription("ডাউনলোড হচ্ছে...");
						} request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType)); request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); request.setDestinationInExternalPublicDir( Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName( url, contentDisposition, mimeType)); DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE); 
				dm.enqueue(request);
				 if (sp.getString("Language", "").equals("ar")) {
						Toast.makeText(getApplicationContext(), "جارى التحميل...", Toast.LENGTH_LONG).show();
						}
						if (sp.getString("Language", "").equals("en")) {
						Toast.makeText(getApplicationContext(), "Downloading...", Toast.LENGTH_LONG).show();
						}
						if (sp.getString("Language", "").equals("bn")) {
						Toast.makeText(getApplicationContext(), "ডাউনলোড হচ্ছে...", Toast.LENGTH_LONG).show();
					//Notif if success
					BroadcastReceiver onComplete = new BroadcastReceiver() {
						public void onReceive(Context ctxt, Intent i) {
							if (sp.getString("Language", "").equals("ar")) {
								showMessage("تم التحميل!");
									}
							if (sp.getString("Language", "").equals("en")) {
								showMessage("Download Complete!");
									}
							if (sp.getString("Language", "").equals("bn")) {
								showMessage("ডাউনলোড শেষ!");
									}
							unregisterReceiver(this);
						}};
					registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
						} }});
		
		webview1.setWebChromeClient(new WebChromeClient() {
			// For 3.0+ Devices
			protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
				mUploadMessage = uploadMsg; Intent i = new Intent(Intent.ACTION_GET_CONTENT); i.addCategory(Intent.CATEGORY_OPENABLE);
				i.setType("*/*"); startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
			}
			
			// For Lollipop 5.0+ Devices
			public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
				if (uploadMessage != null) {
					uploadMessage.onReceiveValue(null);
					uploadMessage = null; 
				} 
				uploadMessage = filePathCallback; Intent i = fileChooserParams.createIntent(); try {
					startActivityForResult(i, REQUEST_SELECT_FILE);
				} catch (ActivityNotFoundException e) {
					uploadMessage = null; Toast.makeText(getApplicationContext(), "Cannot Open File Chooser", Toast.LENGTH_LONG).show(); return false; }
				return true; }
			
			//For Android 4.1 only
			protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
				mUploadMessage = uploadMsg; Intent i = new Intent(Intent.ACTION_GET_CONTENT); i.addCategory(Intent.CATEGORY_OPENABLE); 
				i.setType("*/*"); startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
			}
			
			protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
				mUploadMessage = uploadMsg; Intent i = new Intent(Intent.ACTION_GET_CONTENT); i.addCategory(Intent.CATEGORY_OPENABLE);
				i.setType("*/*"); startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
			}
		});
		
	}
	
	private ValueCallback<Uri> mUploadMessage;
	public ValueCallback<Uri[]> uploadMessage;
	public static final int REQUEST_SELECT_FILE = 100;
	
	private final static int FILECHOOSER_RESULTCODE = 1;
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

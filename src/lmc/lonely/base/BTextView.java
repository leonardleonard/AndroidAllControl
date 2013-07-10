package lmc.lonely.base;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ZoomControls;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.lonely.R;
import lmc.lonely.SysConts;
import lmc.utils.TimeUtils;
public class BTextView extends Activity {
	private TextView txt_call = null;
	private TextView txt_html = null;
	private TextView txt_span = null;
	private TextView txt_blog = null;
	private TextView txt_img = null;
	private String[]words = new String[]{"ab学生","ab学习","ab学生会","ab学前班","ab学习委员","ab学好","ab学做人","abGoogle","abGoogle Map"};
	private ArrayAdapter<String>wAd = null;
	private AutoCompleteTextView txt_auto = null;
	private MultiAutoCompleteTextView txt_mauto = null;
	private TextSwitcher txt_formatres = null;
	private Button txt_format = null;
	private int size = 15;
	private ZoomControls txt_zoom = null;
    private TextView txt_zoomres = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_txt);
        txt_call = (TextView) super.findViewById(R.id.txt_call);
        txt_html = (TextView) super.findViewById(R.id.txt_html);
        txt_span = (TextView) super.findViewById(R.id.txt_span);
        txt_blog = (TextView) super.findViewById(R.id.txt_blog);
        txt_img = (TextView) super.findViewById(R.id.txt_img);
        txt_auto = (AutoCompleteTextView) super.findViewById(R.id.txt_auto);
        txt_mauto = (MultiAutoCompleteTextView) super.findViewById(R.id.txt_mauto);
        txt_formatres = (TextSwitcher) super.findViewById(R.id.txt_formatres);
        txt_format = (Button) super.findViewById(R.id.txt_format);
        txt_zoom = (ZoomControls) super.findViewById(R.id.txt_zoom);
        txt_zoomres = (TextView) super.findViewById(R.id.txt_zoomres);
        txt_call.setMovementMethod(LinkMovementMethod.getInstance());
        txt_html.setText(Html.fromHtml("<a href='"+SysConts.down+"'>源码下载</a>"));
        txt_html.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString ss = new SpannableString("字符链接");
        ss.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				BTextView.this.onBackPressed();
			}
		},0,"字符链接".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_span.setText(ss);
        txt_span.setMovementMethod(LinkMovementMethod.getInstance());
        txt_blog.setText("开发者博客:"+SysConts.csdn);
        Linkify.addLinks(txt_blog,Linkify.ALL);
        String img = "图片链接<a href='"+SysConts.csdn+"'><img src='ico_txt'/></a>";
        CharSequence imgChars = Html.fromHtml(img,new ImageGetter() {
			@Override
			public Drawable getDrawable(String source) {
				Drawable dw = BTextView.this.getResources().getDrawable(R.drawable.icob_txt1);
				if(source.equals("ico_txt")){
					dw.setBounds(0,0,dw.getIntrinsicWidth()/2,dw.getIntrinsicHeight()/2);
				}
				return dw;
			}
		},null);
        txt_img.setText(imgChars);
        txt_img.setBackgroundColor(0xFF00FFFF);
        txt_img.setMovementMethod(LinkMovementMethod.getInstance());
        wAd = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);
        txt_auto.setAdapter(wAd);
        txt_mauto.setAdapter(wAd);
        txt_mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        txt_formatres.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				TextView tv = new TextView(BTextView.this);
				tv.setLayoutParams(new TextSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				tv.setBackgroundColor(0xFFFFFFFF);
				tv.setTextColor(0xFF000000);
				tv.setTextSize(12);
				return tv;
			}
		});
        txt_formatres.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        txt_formatres.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        txt_format.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				txt_formatres.setText("当前时间:"+TimeUtils.getTime(TimeUtils.COX));
			}
		});
        txt_zoom.setOnZoomInClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				size += 2;
				txt_zoomres.setTextSize(size);
			}
		});
        txt_zoom.setOnZoomOutClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				size -= 2;
				txt_zoomres.setTextSize(size);
			}
		});
    }
}
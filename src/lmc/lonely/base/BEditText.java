package lmc.lonely.base;
import java.lang.reflect.Field;
import java.util.Random;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import lmc.lonely.R;
public class BEditText extends Activity implements OnClickListener {
	private EditText edit_face = null;
	private Button edit_add = null;
	private EditText edit_num = null;
	private Button edit_check = null;
	private EditText edit_disable = null;
	private EditText edit_blank = null;
	private int count = 0;
	private EditText edit_pwd = null;
	private EditText edit_focused = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_edit);
        edit_face = (EditText) super.findViewById(R.id.edit_face);
        edit_add = (Button) super.findViewById(R.id.edit_add);
        edit_num = (EditText) super.findViewById(R.id.edit_num);
        edit_check = (Button) super.findViewById(R.id.edit_check);
        edit_disable = (EditText) super.findViewById(R.id.edit_disable);
        edit_blank = (EditText) super.findViewById(R.id.edit_blank);
        edit_pwd = (EditText) super.findViewById(R.id.edit_pwd);
        edit_focused = (EditText) super.findViewById(R.id.edit_focused);
        edit_add.setOnClickListener(this);
        edit_check.setOnClickListener(this);
        edit_disable.setEnabled(false);
        edit_blank.setOnClickListener(this);
        edit_pwd.setOnClickListener(this);
        edit_focused.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				edit_focused.setText(hasFocus?"获得焦点":"失去焦点");
			}
		});
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.edit_add){
			try{
				Field fd = R.drawable.class.getDeclaredField("icob_edit"+(1+new Random().nextInt(3)));
				Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),Integer.parseInt(fd.get(R.drawable.class).toString()));
				SpannableString ss = new SpannableString("icob_edit");
				ss.setSpan(new ImageSpan(this,bmp),0,ss.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				edit_face.append(ss);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.edit_check){
			if(edit_num.getText().toString().equals("")){
				edit_num.setError("请输入内容");
			}
		}else if(v.getId()==R.id.edit_blank){
			edit_blank.setText("");
		}else if(v.getId()==R.id.edit_pwd){
			if(count%2==0){
				edit_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				count++;
			}else if(count%2==1){
				edit_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
				count++;
			}
		}
	}
}
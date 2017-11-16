package mm.tencent.com.chattext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rockerhieu.emojicon.EmojiconTextView;

public class MainActivity extends AppCompatActivity {

    public EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = ((EditText) findViewById(R.id.EmojiconTextView));
    }
    public void open(View view)
    {
        String s = text.getText().toString();
        EmojiconTextView textView = (EmojiconTextView) findViewById(R.id.emoji);
        setContent2(textView,s+"[微笑]");
    }
    //这里是添加表情
    public void setContent2(TextView tv_content, String content) {
        SimpleCommonUtils.spannableEmoticonFilter(tv_content, content);
    }

}

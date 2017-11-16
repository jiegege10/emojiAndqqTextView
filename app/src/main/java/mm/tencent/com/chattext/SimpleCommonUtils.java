package mm.tencent.com.chattext;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;



/**
 *
 * 表情工厂类 加载表情种类
 * */

public class SimpleCommonUtils {

    public static void spannableEmoticonFilter(TextView tv_content, String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        Spannable spannable = QqFilter.spannableFilter(tv_content.getContext(),
                spannableStringBuilder,
                content,
                EmoticonsKeyboardUtils.getFontHeight(tv_content),
                null);
        tv_content.setText(spannable);

        /* Spannable spannable = EmojiDisplay.spannableFilter(tv_content.getContext(),
                spannableStringBuilder,
                content,
                EmoticonsKeyboardUtils.getFontHeight(tv_content));*/

//        spannable = XhsFilter.spannableFilter(tv_content.getContext(),
//                spannable,
//                content,
//                EmoticonsKeyboardUtils.getFontHeight(tv_content),
//                null);
//        tv_content.setText(spannable);
    }
}

package mm.tencent.com.chattext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QqFilter extends EmoticonFilter {


    public static final int WRAP_DRAWABLE = -1;
    public static final Pattern QQ_RANGE = Pattern.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");

    public static Matcher getMatcher(CharSequence matchStr) {
        return QQ_RANGE.matcher(matchStr);
    }



    public static Spannable spannableFilter(Context context, Spannable spannable, CharSequence text, int fontSize, EmojiDisplayListener emojiDisplayListener) {
        Matcher m = getMatcher(text);
        if (m != null) {
            while (m.find()) {
                String key = m.group();
                int icon = DefQqEmoticons.sQqEmoticonHashMap.get(key);
                if (emojiDisplayListener == null) {
                    if (icon > 0) {
                        emoticonDisplay(context, spannable, icon, fontSize, m.start(), m.end());
                    }
                } else {
                    emojiDisplayListener.onEmojiDisplay(context, spannable, "" + icon, fontSize, m.start(), m.end());
                }
            }
        }
        return spannable;
    }


    public static void emoticonDisplay(Context context, Spannable spannable, int emoticon, int fontSize, int start, int end) {
        Drawable drawable = getDrawable(context, emoticon);
        if (drawable != null) {
            int itemHeight;
            int itemWidth;
            if (fontSize == WRAP_DRAWABLE) {
                itemHeight = drawable.getIntrinsicHeight();
                itemWidth = drawable.getIntrinsicWidth();
            } else {
                itemHeight = fontSize;
                itemWidth = fontSize;
            }
            drawable.setBounds(0, 0, itemHeight, itemWidth);
            EmoticonSpan imageSpan = new EmoticonSpan(drawable);
            spannable.setSpan(imageSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }
}

package mm.tencent.com.chattext;

import android.graphics.Paint;
import android.widget.TextView;

public class EmoticonsKeyboardUtils {

    public EmoticonsKeyboardUtils() {
    }

    public static int getFontHeight(TextView textView) {
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int)Math.ceil((double)(fm.bottom - fm.top));
    }



}

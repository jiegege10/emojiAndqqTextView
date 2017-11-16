package mm.tencent.com.chattext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

public abstract class EmoticonFilter {
    public EmoticonFilter() {
    }



    public static Drawable getDrawable(Context context, int emoticon) {
        if(emoticon <= 0) {
            return null;
        } else {
            try {
                return Build.VERSION.SDK_INT >= 21?context.getResources().getDrawable(emoticon, (Resources.Theme)null):context.getResources().getDrawable(emoticon);
            } catch (Exception var3) {
                var3.printStackTrace();
                return null;
            }
        }
    }
}

package mm.tencent.com.chattext;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class PasteCopyService extends Service {
ClipboardManager clipboardManager;
private WindowManager wm;
@Override
public void onCreate() {
    super.onCreate();
    clipboardManager =(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
    final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
    params.type =  WindowManager.LayoutParams.TYPE_TOAST;
    params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
    params.gravity = Gravity.TOP;
    params.height = 200;
    params.x = 0;
    params.y = 0;

    final LayoutInflater mInflater = LayoutInflater.from(this);
    final View view = mInflater.inflate(R.layout.activity_main,null);
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                Intent intent = new Intent(PasteCopyService.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            wm.removeView(view);
        }
    });

    clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
        @Override
        public void onPrimaryClipChanged() {
            wm.addView(view,params);
            view.post(new Runnable() {
                @Override
                public void run() {

                }
            });
            Toast.makeText(PasteCopyService.this,"测试",Toast.LENGTH_SHORT).show();
        }
    });
}


@Override
public void onDestroy() {
    super.onDestroy();
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);
}

@Nullable
@Override
public IBinder onBind(Intent intent) {
    return null;
}
} 
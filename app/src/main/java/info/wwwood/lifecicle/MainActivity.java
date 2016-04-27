package info.wwwood.lifecicle;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private int countOnCreate=0;
    private int countOnRestart=0;
    private int countOnStart=0;
    private int countOnResume=0;
    private int countOnPause=0;
    private int countOnStop=0;
    private int countOnDestroy=0;

    private final int tvOnCreateID=0;
    private final int tvOnRestartID=1;
    private final int tvOnStartID=2;
    private final int tvOnResumeID=3;
    private final int tvOnPauseID=4;
    private final int tvOnStopID=5;
    private final int tvOnDestroyID=6;

    private List<TextView> tvList=new ArrayList<TextView>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("OnCreate ",String.valueOf(++countOnCreate));

        TextView tvOnCreate=new TextView(this);
        tvOnCreate.setTag(tvOnCreateID);
        tvList.add(tvOnCreate);

        TextView tvOnRestart=new TextView(this);
        tvOnRestart.setTag(tvOnRestartID);
        tvList.add(tvOnRestart);

        TextView tvOnStart=new TextView(this);
        tvOnStart.setTag(tvOnStartID);
        tvList.add(tvOnStart);

        TextView tvOnResume=new TextView(this);
        tvOnResume.setTag(tvOnResumeID);
        tvList.add(tvOnResume);

        TextView tvOnPause=new TextView(this);
        tvOnPause.setTag(tvOnPauseID);
        tvList.add(tvOnPause);

        TextView tvOnStop=new TextView(this);
        tvOnStop.setTag(tvOnStopID);
        tvList.add(tvOnStop);

        TextView tvOnDestroy=new TextView(this);
        tvOnDestroy.setTag(tvOnDestroyID);
        tvList.add(tvOnDestroy);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart ",String.valueOf(++countOnRestart));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart ",String.valueOf(++countOnStart));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume ",String.valueOf(++countOnResume));
        renderView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause ",String.valueOf(++countOnPause));

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop ",String.valueOf(++countOnStop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy ",String.valueOf(++countOnDestroy));
    }

    private void renderView(){
        ViewGroup lyMain=(ViewGroup) findViewById(R.id.lyMain);
        lyMain.removeAllViews();

        int MarginTop=0;

        for (TextView textView:tvList){
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);

            params.topMargin=MarginTop;

            switch ((Integer) textView.getTag())
            {
                case tvOnCreateID:
                    textView.setText("onCreate " + String.valueOf(countOnCreate));
                    break;
                case tvOnRestartID:
                    textView.setText("onRestart " + String.valueOf(countOnRestart));
                    break;
                case tvOnStartID:
                    textView.setText("onStart " + String.valueOf(countOnStart));
                    break;
                case tvOnResumeID:
                    textView.setText("onResume " + String.valueOf(countOnResume));
                    break;
                case tvOnPauseID:
                    textView.setText("onPause " + String.valueOf(countOnPause));
                    break;
                case tvOnStopID:
                    textView.setText("onStop " + String.valueOf(countOnStop));
                    break;
                case tvOnDestroyID:
                    textView.setText("onDestroy " + String.valueOf(countOnDestroy));
                    break;
            }
            lyMain.addView(textView,params);
            MarginTop=MarginTop+=100;
        }
    }
}

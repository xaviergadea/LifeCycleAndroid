package info.wwwood.lifecicle;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int countOnCreate=0;
    private int countOnRestart=0;
    private int countOnStart=0;
    private int countOnResume=0;
    private int countOnPause=0;
    private int countOnStop=0;
    private int countOnDestroy=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("OnCreate ",String.valueOf(++countOnCreate));
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
        
    }
}

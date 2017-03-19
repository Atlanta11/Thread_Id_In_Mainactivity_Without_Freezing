package enterprise.sample.com.thread_id;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    private Button buttonStart, buttonStop, buttonStart1, buttonStop1;

    private  boolean mStopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"Thread id:"+Thread.currentThread().getId());

        buttonStart=(Button)findViewById(R.id.buttonThreadStarter);
        buttonStop=(Button)findViewById(R.id.buttonStopthread);
        buttonStart1=(Button)findViewById(R.id.buttonThreadStarter1);
        buttonStop1=(Button)findViewById(R.id.buttonStopthread1);

    }
/////////////////////////////////////////////////////////////////////////////////////////////////    this freeze the Mainactivity

    public void onClick(View view){
        switch (view.getId()){
            case R.id.buttonThreadStarter:
                mStopLoop=true;
                while (mStopLoop){
                    Log.i(TAG,"Thread id in while loop:"+Thread.currentThread().getId());
                }
                break;
            case R.id.buttonStopthread: mStopLoop=false;
                break;
        }


    }
/////////////////////////////////////////////////////////////////////////////////////////////////    this freeze the Mainactivity

    public void onClick1(View view){
        switch (view.getId()){
            case R.id.buttonThreadStarter1:
                mStopLoop=true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mStopLoop){
                            Log.i(TAG,"Thread id in while loop:"+Thread.currentThread().getId());
                        }
                    }
                }).start();

                break;
            case R.id.buttonStopthread1: mStopLoop=false;
                break;
        }


    }


}

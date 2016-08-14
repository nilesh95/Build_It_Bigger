package content.example.com.androidjoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by NILESH on 14-08-2016.
 */
public class Android_Joker extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_joker);
        t= (TextView) findViewById(R.id.jokes_txt);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            t.setText(extras.getString("joke"));
        }
    }
}
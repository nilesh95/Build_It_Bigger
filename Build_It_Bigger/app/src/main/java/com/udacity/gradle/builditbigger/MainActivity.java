package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.Joke;

import content.example.com.androidjoke.Android_Joker;



public class MainActivity extends ActionBarActivity {
    Context c;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=this;
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        spinner.setVisibility(View.VISIBLE);
       Joke myJoker = new Joke();

        new EndpointsAsyncTask()
        {
            @Override
        protected void onPostExecute(String result) {
                spinner.setVisibility(View.GONE);
                Intent i=new Intent(c, Android_Joker.class);
        i.putExtra("joke",result);
        startActivity(i);
        }
        }.execute(new Pair<Context, String>(this, myJoker.getJoke()));
//        Intent i=new Intent(this, Android_Joker.class);
//        i.putExtra("joke",myJoker.getJoke());
//        startActivity(i);
 //      Toast.makeText(this, myBean.getData(), Toast.LENGTH_SHORT).show();
    }


}

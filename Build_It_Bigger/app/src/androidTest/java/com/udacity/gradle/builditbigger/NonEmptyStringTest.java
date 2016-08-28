package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;


/**
 * Created by NILESH on 15-08-2016.
 */
public class NonEmptyStringTest extends AndroidTestCase {

    @Override
    protected void runTest() throws Throwable {
        super.runTest();

        try {
            String string = new EndpointsAsyncTask().execute().get();
            assertNotNull(string);
            assertTrue(string.length() > 0);
            Log.v("NonEmpty:: ",string);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
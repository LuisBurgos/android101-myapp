package mx.yellowme.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by javikin on 6/20/16.
 */
public class Util {

    public static void sendAndFinish(Activity activity, Class clase){
        Intent mainIntent = new Intent().setClass(activity, clase);
        activity.startActivity(mainIntent);
        activity.finish();
    }

    public static void sendTo(Activity activity, Class clase){
        Intent mainIntent = new Intent().setClass(activity, clase);
        activity.startActivity(mainIntent);
    }

}

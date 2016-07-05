package mx.yellowme.util;

import android.app.Activity;
import android.app.ProgressDialog;
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


    public static ProgressDialog createModalProgressDialog(Activity activity) {
        return createModalProgressDialog(activity, null);
    }

    public static ProgressDialog createModalProgressDialog(Activity activity, String dialogMessage) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        if(dialogMessage != null){
            progressDialog.setMessage(dialogMessage);
        }
        return progressDialog;
    }

}

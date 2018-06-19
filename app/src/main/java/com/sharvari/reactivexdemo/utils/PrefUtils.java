package com.sharvari.reactivexdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sharvari on 19-Jun-18.
 */

public class PrefUtils {

    private PrefUtils() {
    }

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences("PREF",Context.MODE_PRIVATE);
    }

    public static void storeApiKey(Context context, String apiKey){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("API_KEY", apiKey);
        editor.commit();
    }

    public static String getApiKey(Context context){
        return getSharedPreferences(context).getString("API_KEY", null);
    }

}

package com.blackspider.util;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/20/2018 at 1:02 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/20/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static String covertTimeToText(long dataDate) {

        String convTime = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date pasTime = dateFormat.parse(String.valueOf(dataDate));

            Date nowTime = new Date();

            long dateDiff = nowTime.getTime() - pasTime.getTime();

            long detik = TimeUnit.MILLISECONDS.toSeconds(dateDiff);
            long menit = TimeUnit.MILLISECONDS.toMinutes(dateDiff);
            long jam   = TimeUnit.MILLISECONDS.toHours(dateDiff);
            long hari  = TimeUnit.MILLISECONDS.toDays(dateDiff);

            if (detik < 60) {
                convTime = detik+"detik lalu";
            } else if (menit < 60) {
                convTime = menit+"menit lalu";
            } else if (jam < 24) {
                convTime = jam+"jam lalu";
            } else if (hari >= 7) {
                if (hari > 30) {
                    convTime = (hari / 30)+"bulan lalu";
                } else if (hari > 360) {
                    convTime = (hari / 360)+"tahun lalu";
                } else {
                    convTime = (hari / 7) + "minggu lalu";
                }
            } else if (hari < 7) {
                convTime = hari+"hari lalu";
            }

        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("ConvTimeE", e.getMessage());
        }

        return convTime;

    }

}

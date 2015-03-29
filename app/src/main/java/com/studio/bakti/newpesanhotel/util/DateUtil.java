package com.studio.bakti.newpesanhotel.util;

import android.widget.Toast;

/**
 * Created by bakti on 3/29/15.
 */
public class DateUtil {
    public static int julianDay(int year, int month, int day) {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        int jdn = day + (153 * m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
        return jdn;
    }

    public static int diff(int y1, int m1, int d1, int y2, int m2, int d2) {
        return julianDay(y1, m1, d1) - julianDay(y2, m2, d2);
    }

    public static int diff(String fromDay,String toDay){
        String[] dayFrom = fromDay.split("-");
        String[] dayTo = toDay.split("-");
        return diff(Integer.parseInt(dayTo[0]),Integer.parseInt(dayTo[1]),Integer.parseInt(dayTo[2]),
                Integer.parseInt(dayFrom[0]),Integer.parseInt(dayFrom[1]),Integer.parseInt(dayFrom[2]));
    }
}

package com.common.util;

import com.config.util.string.StringUtil;

import java.text.DecimalFormat;

/**
 * Created by LiNan on 2018-05-02.
 * Description:
 */
public class CoordinateUtil {

    private static final int METER2PX = 6; // 1m = 6px

    /**
     * meter to px
     * @param oldSize
     * @return
     */
    public static String convertM2P(String oldSize){
        String[] size = oldSize.split(" ");
        String wString = size[0].replace("(","");
        String hString = size[1].replace(")","");
        float w = Float.parseFloat(wString)*METER2PX;
        float h = Float.parseFloat(hString)*METER2PX;
        return w + " " + h ;
    }


    /**
     * px to meter
     * @param oldSize
     * @return
     */
    public static String convertP2M(String oldSize){
        String[] size = oldSize.split(" ");
        String wString = size[0].replace("(","");
        String hString = size[1].replace(")","");
        double w = StringUtil.getOneDecimal(Double.valueOf(wString)/METER2PX);
        double h = StringUtil.getOneDecimal(Double.valueOf(hString)/METER2PX);
        return w + " " + h;
    }

    public static void main(String[] args) {
        String a = "(70 8.4)";
        String b = convertP2M(a);
        System.out.println(convertM2P(a));
        System.out.println(convertP2M(a));
    }
}

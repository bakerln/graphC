package com.common.util;

import com.config.util.string.StringUtil;


/**
 * Created by LiNan on 2018-05-02.
 * Description:
 */
public class CoordinateUtil {

    private static final int METER2PX = 6; // 1m = 6px
    private static final int LAYER_PX = 20;//每层20px

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

    /**
     * getContainerPos
     * @param oldPos
     * @param layer
     * @return
     */
    public static String getContainerPos(String oldPos,String layer){
        String[] size = oldPos.split(" ");
        float y = Float.valueOf(size[1]) + (3 - Integer.valueOf(layer))*LAYER_PX;
        String x = size[0];

        return x + " " + y;

    }

    public static void main(String[] args) {
        String a = "-600 -380";
//        String b = convertP2M(a);
        String b = getContainerPos(a,"1");
        System.out.println(b);
//        System.out.println(convertM2P(a));
//        System.out.println(convertP2M(a));
    }
}

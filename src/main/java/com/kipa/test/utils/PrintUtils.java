package com.kipa.test.utils;

/**
 * @author: Qinyadong
 * @date: 2019/6/17 17:15
 * @since: 字体打印工具类
 */
public class PrintUtils {

    public static final int WHITE = 30;             // 白色
    public static final int WHITE_BACKGROUND = 40;  // 白色背景
    public static final int RED = 31;               // 红色
    public static final int RED_BACKGROUND = 41;    // 红色背景
    public static final int GREEN = 32;             // 绿色
    public static final int GREEN_BACKGROUND = 42;  // 绿色背景
    public static final int YELLOW = 33;            // 黄色
    public static final int YELLOW_BACKGROUND = 43; // 黄色背景
    public static final int BLUE = 34;              // 蓝色
    public static final int BLUE_BACKGROUND = 44;   // 蓝色背景
    public static final int MAGENTA = 35;           // 品红（洋红）
    public static final int MAGENTA_BACKGROUND = 45;// 品红背景
    public static final int CYAN = 36;              // 蓝绿
    public static final int CYAN_BACKGROUND = 46;   // 蓝绿背景
    public static final int BLACK = 37;             // 黑色
    public static final int BLACK_BACKGROUND = 47;  // 黑色背景

    public static final int BOLD = 1;       // 粗体
    public static final int ITATIC = 3;     // 斜体
    public static final int UNDERLINE = 4;  // 下划线
    public static final int REVERSE = 7;    // 反转

    private static String formatPrint(String txt, int... codes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (codes == null || codes.length == 0) {
            return "";
        }
        for (int code : codes) {
            stringBuilder.append(code).append(";");
        }
        String codeStr = stringBuilder.toString();
        if (codeStr.endsWith(";")) {
            codeStr = codeStr.substring(0, codeStr.length() -1);
        }
        return (char) 27 + "[" + codeStr + "m" + txt + (char) 27 + "[0m";
    }

    static void println(String txt) {
        System.out.println(formatPrint(txt, RED, BOLD, GREEN_BACKGROUND));
    }

    public static void println(Object o) {
        println(String.valueOf(o));
    }

    public static void println(Object... objects) {
        if (objects == null || objects.length == 0) {
            return;
        }
        for (Object object : objects) {
            println(object);
        }
    }
}

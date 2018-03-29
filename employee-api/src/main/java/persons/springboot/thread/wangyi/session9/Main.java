package persons.springboot.thread.wangyi.session9;

import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * <p>
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * <p>
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String conNum = sc.nextLine();
            check(conNum);
        }
    }

    private static void check(String con) {
        String[] st = con.split(" ");
        int len = st[st.length-1].length();
        System.out.println(len);
    }
}

package com.tanpp.zyu;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Author: shaoff
 * Date: 2022/3/14 21:29
 * Description:
 */
public class Hello {

    public static void main(String[] args) throws Exception {
        InputStream in= Thread.currentThread().getContextClassLoader().getResourceAsStream("name.txt");
        Scanner scanner=new Scanner(in);

        String name=scanner.nextLine();
        in.close();
        System.out.println("hello, " +name);
    }
}

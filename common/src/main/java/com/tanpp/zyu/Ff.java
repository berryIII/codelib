package com.tanpp.zyu;


import static jdk.nashorn.internal.objects.Global.print;
import static com.tanpp.sqlparse.Fff.*;

/**
 * Author: tshaoff
 * Date: 2022/3/6 14:59
 * Package: me.tanpp.zyu
 * Description:
 */


public class Ff {
    int a=1;// 成员变量，实例变量
    static int b=2; //静态变量，类变量


    public static void main(String[] args) {
        print("HelloWorld");
        print(new Ff());

        Ff o1=new Ff();
        Ff o2=new Ff();
        print1("jintian");
        print2("123");




    }


}

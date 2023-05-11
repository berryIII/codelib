package com.tanpp.common.annotations;

import java.util.Set;
import org.reflections.Reflections;

/**
 * Author: tanpp
 * Date: 2021/7/21 15:31
 * Package: me.tanpp.common.annotations
 * Description:
 */
public class ScanAnnotation {

    /*scan某个包下所有带有特定注解的类*/
    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.tencent.pcg.udf");
        Set<Class<?>> clazzs = reflections.getTypesAnnotatedWith(Udf.class);
    }
}

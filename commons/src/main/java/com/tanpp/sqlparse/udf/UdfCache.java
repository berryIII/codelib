package com.tanpp.sqlparse.udf;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import com.tanpp.common.reflection.annotations.Udf;
import org.reflections.Reflections;

/**
 *
 * @author tanpp
 */
public class UdfCache {
    public static final Map<String,ScalarFunction> cache=new ConcurrentHashMap<>();
    static {
        Reflections reflections = new Reflections("me.tanpp.sqlparse.udf");
        Set<Class<?>> clazzs = reflections.getTypesAnnotatedWith(Udf.class);
        clazzs.forEach(c->{
            try {
                ScalarFunction f= (ScalarFunction) c.newInstance();
                cache.put(f.getName(), f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }



}

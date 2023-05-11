package com.tanpp.sqlparse.udf;

import java.util.List;

import com.tanpp.common.annotations.Udf;

/**
 * Author: tanpp
 * Date: 2021/10/28 16:24
 * Package: me.tanpp.sqlparse.udf
 * Description:
 */
@Udf
public class Length implements ScalarFunction{

    @Override
    public Object eval(List<Object> params) {
        String value= (String) params.get(0);
        return value.length();
    }
}

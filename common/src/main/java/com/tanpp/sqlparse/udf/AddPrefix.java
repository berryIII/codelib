package com.tanpp.sqlparse.udf;

import java.util.List;

import com.tanpp.common.annotations.Udf;

/**
 * Author: tanpp
 * Date: 2021/10/28 16:18
 * Package: me.tanpp.sqlparse.udf
 * Description:
 */
@Udf
public class AddPrefix implements ScalarFunction {
    @Override
    public String eval(List<Object> params) {
        String colValue= (String) params.get(0);
        String prefix= (String) params.get(1);
        return prefix+colValue;
    }
}

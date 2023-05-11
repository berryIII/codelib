package com.tanpp.sqlparse.udf;

import java.util.List;

import com.tanpp.common.annotations.Udf;

/**
 * Author: tanpp
 * Date: 2021/10/28 16:45
 * Package: me.tanpp.sqlparse.udf
 * Description:
 */
@Udf
public class CeilDiv implements ScalarFunction {

    @Override
    public Object eval(List<Object> params) {
        String num1 = String.valueOf(params.get(0));
        String num2 = String.valueOf(params.get(1));
        return -Math.floorDiv(-Integer.parseInt(num1),Integer.parseInt(num2));
    }

    @Override
    public String getName() {
        return ScalarFunction.super.getName();
    }
}

package com.berry.sqlparse.udf;

import com.berry.common.reflection.annotations.Udf;
import java.util.List;

/**
 * Author: tanpp
 * Date: 2021/10/28 16:45
 * Description:
 */
@Udf(name = "ceil_div")
public class CeilDiv implements ScalarFunction {

    @Override
    public Object eval(List<Object> params) {
        String num1 = String.valueOf(params.get(0));
        String num2 = String.valueOf(params.get(1));
        return -Math.floorDiv(-Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @Override
    public String getName() {
        return ScalarFunction.super.getName();
    }
}

package com.berry.common.reflection.functions;

import com.berry.common.reflection.ScalarFunction;
import java.util.List;

/**
 * ScalarFunction示例实现
 *
 * @author tanpp
 */
public class SampleFunction implements ScalarFunction {

    @Override
    public Object eval(List<Object> params) {
        return new Object();
    }
}

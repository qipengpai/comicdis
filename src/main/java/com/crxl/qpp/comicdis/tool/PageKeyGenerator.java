package com.crxl.qpp.comicdis.tool;


import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

public class PageKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return null;
    }
}

package com.fengquanwei.smartwebapp.chapter3.aspect;

import com.fengquanwei.framework.annotation.Aspect;
import com.fengquanwei.framework.annotation.Controller;
import com.fengquanwei.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Controller 切面（拦截 Controller 的所有方法）
 *
 * @author fengquanwei
 * @create 2017/12/07 15:31
 **/
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.info("---------- begin ----------");
        LOGGER.info(String.format("class: %s", cls.getName()));
        LOGGER.info(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.info(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.info("----------- end -----------");
    }
}

package org.ywb.study.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ywb.study.annotation.DataSource;
import org.ywb.study.dao.DataSourceHolder;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * User: yangwenbiao
 * Date: 2017/2/24
 * Time: 15:12
 */
@Component
@Aspect
public class DataSourceAspectj {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspectj.class);

    @Before("execution(* org.ywb.study.dao.*Mapper.*(..))")
    public void before(JoinPoint point) {

        Method method = ((MethodSignature) point.getSignature()).getMethod();
        DataSource d = method.getAnnotation(DataSource.class);

        if (!Objects.isNull(d)) {
            String value = d.value();
            //LOGGER.info("获取到的数据源是, {}", value);
            DataSourceHolder.setContext(value);
        }
    }
}

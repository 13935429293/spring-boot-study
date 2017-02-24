package org.ywb.study.annotation;

import java.lang.annotation.*;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/24
 * Time: 14:13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value();
}

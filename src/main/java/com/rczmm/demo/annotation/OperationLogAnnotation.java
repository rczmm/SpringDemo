package com.rczmm.demo.annotation;

import java.lang.annotation.*;


/**
 * 自定义操作日志注解
 *
 * @author rczmm
 * @date 2024/05/20 14:45
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogAnnotation {

    /**
     * 操作模块
     */
    String operationModule() default "";

    /**
     * 操作描述
     */
    String operationDesc() default "";

    /**
     * 操作类型
     */
    String operationType() default "";


}

package com.rczmm.demo.util;


import com.rczmm.demo.annotation.OperationLogAnnotation;
import com.rczmm.demo.domain.Log;
import com.rczmm.demo.mapper.LogMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;


/**
 * 操作日志切面处理类
 *
 * @author rczmm
 * @date 2024-05-21
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    private final LogMapper logMapper;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public OperationLogAspect(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    /**
     * 设置操作日志切入点
     */
    @Pointcut("@annotation(com.rczmm.demo.annotation.OperationLogAnnotation)")
    public void operationLogPointCut() {
    }

    @AfterReturning(returning = "result", value = "operationLogPointCut()")
    public void saveOperationLog(JoinPoint joinPoint, Object result) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Log log = new Log();
        if (requestAttributes != null) {
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            log.setIp(IpUtil.getIpAddr(request));
        }
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            OperationLogAnnotation annotation = method.getAnnotation(OperationLogAnnotation.class);
            if (Objects.nonNull(annotation)) {
                log.setModel(annotation.operationModule());
                log.setType(annotation.operationType());
                log.setDescription(annotation.operationDesc());
            }
            log.setOperationTime(Timestamp.valueOf(SDF.format(new Date())));
            int insertResult = logMapper.insertLog(log);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).info("保存操作日志失败");
        }


    }
}

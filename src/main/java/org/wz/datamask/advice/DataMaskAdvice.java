package org.wz.datamask.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.wz.datamask.annotation.Masked;
import org.wz.datamask.util.DataMaskUtil;

import javax.annotation.Resource;

/**
 *
 */
@Slf4j
@Aspect
public class DataMaskAdvice {

    private DataMaskUtil dataMaskUtil;

    public DataMaskAdvice(DataMaskUtil dataMaskUtil) {
        this.dataMaskUtil = dataMaskUtil;
    }

    @Pointcut("@annotation(org.wz.datamask.annotation.Masked)")
    public void pointcut() {
        // noop
    }

    @Around("pointcut() &&  @annotation(masked)")
    public Object dataMaskedAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Masked masked) throws Throwable {
        Object data = proceedingJoinPoint.proceed();
        dataMaskUtil.convert(data);
        return data;
    }

}

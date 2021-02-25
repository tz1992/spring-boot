package com.fiberhome.practice.aspect;

import com.fiberhome.practice.annocation.TestLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.fiberhome.practice.dao.*.*get*(..))||" +
            "execution(public * com.fiberhome.practice.dao.*.*insert*(..))")
    public void OperatorPoint() {

    }


    @Around("OperatorPoint()")
    public Object aroundOperator(ProceedingJoinPoint point) {
        Object result=null;
        try {
            Signature signature= point.getSignature();
            //获取方法
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            TestLog testLog = method.getAnnotation(TestLog.class);
            String dataType= testLog.dataType().trim();
            System.out.println(dataType);
            Object[] args = point.getArgs();
            result=point.proceed();
        }catch (Throwable throwable){
           throwable.printStackTrace();
        }

        return result;
    }
}

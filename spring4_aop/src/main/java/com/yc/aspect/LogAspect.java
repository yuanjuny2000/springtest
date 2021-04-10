package com.yc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void add(){
        
    }
    
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))")
    private void update(){

    }
    
    @Pointcut("add() || update()")
    private void addAndUpdate(){
        
    }



    //添加的声明
    @Before("com.yc.aspect.LogAspect.addAndUpdate()")
    public void log(){
        System.out.println("=========前置增强的日志==========");
        Date d =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr=sdf.format(d);
        System.out.println("执行时间:"+dstr);
        System.out.println("=========前置增强的日志结束=========");
    }
}

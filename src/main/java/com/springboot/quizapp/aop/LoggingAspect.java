package com.springboot.quizapp.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    //return type,class-name.method-name(args)
  @Before("execution(* com.springboot.quizapp.service.QuestionService.getAllQuestions(..))")
    public void logMethodCall(){
      System.out.println("Hello");
        LOGGER.info("Method called");
    }

}

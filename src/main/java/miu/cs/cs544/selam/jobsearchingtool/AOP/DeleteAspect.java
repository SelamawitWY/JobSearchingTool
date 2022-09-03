package miu.cs.cs544.selam.jobsearchingtool.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@org.aspectj.lang.annotation.Aspect
@Configuration
public class DeleteAspect {

    @Pointcut("execution(public * org.springframework.data.jpa.repository.JpaRepository.deleteById(..)) || " +
              "execution(public * org.springframework.data.jpa.repository.JpaRepository.delete(..))")
    public void allRepositoryDelete() {
    }

    @After("allRepositoryDelete()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Object with id : " + joinPoint.getArgs()[0] + " has been deleted Successfully.");
    }
}

package ru.kpfu.itis.aspect;

/**
 * Created by etovladislav on 07.09.16.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.routing.DbContextHolder;
import ru.kpfu.itis.routing.DbType;

@Aspect
@Component
public class WriteConnectionInterceptor implements Ordered {
    private static final Logger log = LoggerFactory.getLogger(WriteConnectionInterceptor.class);

    private int order;

    @Value("20")
    public void setOrder(int order) {
        System.out.println("ReadOnlyConnectionInterceptor >>> order = 20");
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Pointcut(value="execution(public * *(..))")
    public void anyPublicMethod() { }

    @Around("@annotation(writeConnection)")
    public Object proceed(ProceedingJoinPoint pjp,
                          WriteConnection writeConnection) throws Throwable {

        try {
            DbContextHolder.setDbType(DbType.MASTER);
            Object result = pjp.proceed();
            DbContextHolder.clearDbType();
            return result;
        } finally {
            DbContextHolder.clearDbType();
        }
    }
}
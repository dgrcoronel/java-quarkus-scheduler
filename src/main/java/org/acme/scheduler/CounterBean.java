package org.acme.scheduler;

import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

@ApplicationScoped              
public class CounterBean {

    private AtomicInteger counter = new AtomicInteger();

    public int get() {  
        return counter.get();
    }

    @Scheduled(every="5s")     
    void increment() {
        counter.incrementAndGet(); 
        System.out.println("Counter: " + counter.get());
    }

    // @Scheduled(cron="0 55 13 * * ?") 
    // void cronJob(ScheduledExecution execution) {
    //     counter.incrementAndGet();
    //     System.out.println(execution.getScheduledFireTime());
    //     System.out.println("Counter: " + counter.get());
    // }

    // @Scheduled(cron = "{cron.expr}") 
    // void cronJobWithExpressionInConfig() {
    //    counter.incrementAndGet();
    //    System.out.println("Cron expression configured in application.properties. \n Counter: " + counter.get());
    // }
}
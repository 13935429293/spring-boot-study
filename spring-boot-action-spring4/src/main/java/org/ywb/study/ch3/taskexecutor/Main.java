package org.ywb.study.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * date: 2017/5/17 15:11
 * description:
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService service = ac.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            service.asyncTask(i);
            service.asyncTaskPlus(i);
        }

        ac.close();

    }
}

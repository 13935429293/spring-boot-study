package org.ywb.study.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * date: 2017/5/17 15:10
 * description:
 */
@Service
public class AsyncTaskService {

    @Async
    public void asyncTask(Integer i){
        System.out.println("执行任务1:" + i);
    }

    @Async
    public void asyncTaskPlus(Integer i){
        System.out.println("执行任务2:" + (i + 1));
    }

}

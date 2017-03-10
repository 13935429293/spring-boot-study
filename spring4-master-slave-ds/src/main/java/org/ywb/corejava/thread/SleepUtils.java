package org.ywb.corejava.thread;

import java.util.concurrent.TimeUnit;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/8
 * Time: 18:32
 */
public class SleepUtils {
    public static final void second (long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package org.ywb.corejava.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2017/3/27.
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                cyclic.await();
                dowork();
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void dowork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + "：任务完成");
        }
    }

    public static class BarrierRun implements Runnable{
        boolean flag;
        int n;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：【士兵" + n + "个，任务完成！】");
            } else {
                System.out.println("司令：【士兵" + n + "个，集合完成！】");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int n = 10;
        Thread[] allSolider = new Thread[n];
        boolean flag = false;
        // 第二个参数是当cyc
        // lic执行完成之后，系统执行的动作
        CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(flag, n));
        System.out.println("队伍集合");
        for (int i = 0; i < n; i++) {
            System.out.println("士兵" + i + "报道");
            allSolider[i] = new Thread(new Soldier("士兵" + i, cyclic));
            allSolider[i].start();
        }
    }
}

package cn.codexin.questions;

import java.util.concurrent.Semaphore;

/**
 * Created by xinGao 2020/5/3
 */

public class Q1117_Building_H2O {
    //信号量
    class H2O {
        private Semaphore eleH = new Semaphore(2);
        private Semaphore eleO = new Semaphore(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            eleH.acquire(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            eleO.release(1);

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            eleO.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            eleH.release(2);
        }
    }
}

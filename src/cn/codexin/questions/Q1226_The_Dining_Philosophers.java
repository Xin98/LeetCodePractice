package cn.codexin.questions;

import java.util.concurrent.Semaphore;

/**
 * Created by xinGao 2020/5/6
 */

public class Q1226_The_Dining_Philosophers {
    class DiningPhilosophers {

        private final Semaphore[] forks;
        private int n;

        public DiningPhilosophers() {
            n = 5;
            forks = new Semaphore[n];
            for (int i = 0; i < n; i++) {
                forks[i] = new Semaphore(1);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int firstFork, secondFork;
            if ((philosopher & 1) == 0) {
                //偶数拿首先拿左筷子
                firstFork = philosopher;
                secondFork = (philosopher + 1) % n;
            } else {
                //奇数首先拿右筷子
                firstFork = (philosopher + 1) % n;
                secondFork = philosopher;
            }
            //拿起筷子
            forks[firstFork].acquire();
            forks[secondFork].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            //吃面
            eat.run();
            //放下筷子
            putLeftFork.run();
            putRightFork.run();
            forks[firstFork].release();
            forks[secondFork].release();
        }
    }

}

package cn.codexin.questions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xinGao 2020/5/1
 */

public class Q1115_Print_FooBar_Alternately {
    //信号量
    class FooBar {
        private int n;

        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }
    }

    //锁  生产者消费者模式
//    class FooBar {
//        private int n;
//
//        private ReentrantLock lock = new ReentrantLock();
//        private Condition condition = lock.newCondition();
//        private boolean isEmpty = true;
//        public FooBar(int n) {
//            this.n = n;
//        }
//
//        public void foo(Runnable printFoo) throws InterruptedException {
//            //producer
//            for (int i = 0; i < n; i++) {
//                try{
//                    lock.lock();
//                    while(!isEmpty){
//                        condition.await();
//                    }
//                    // printFoo.run() outputs "foo". Do not change or remove this line.
//                    printFoo.run();
//                    isEmpty = false;
//                    condition.signal();
//                }finally {
//                    lock.unlock();
//                }
//            }
//        }
//
//        public void bar(Runnable printBar) throws InterruptedException {
//            //consumer
//            for (int i = 0; i < n; i++) {
//                try{
//                    lock.lock();
//                    while(isEmpty){
//                        condition.await();
//                    }
//                    // printBar.run() outputs "bar". Do not change or remove this line.
//                    printBar.run();
//                    isEmpty = true;
//                    condition.signal();
//                }finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }
}

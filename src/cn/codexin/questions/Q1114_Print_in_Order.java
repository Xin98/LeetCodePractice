package cn.codexin.questions;

import java.util.concurrent.Semaphore;

/**
 * Created by xinGao 2020/4/28
 */

public class Q1114_Print_in_Order {
    class Foo {
        private Semaphore sa = new Semaphore(1);
        private Semaphore sb = new Semaphore(0);
        private Semaphore sc = new Semaphore(0);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            sa.acquire();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sb.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sb.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sc.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sc.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

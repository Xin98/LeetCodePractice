package cn.codexin.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Created by xinGao 2020/5/2
 */

public class Q1116_Print_Zero_Even_Odd {
    static class ZeroEvenOdd {
        private int n;

        private Semaphore zero = new Semaphore(1);
        private Semaphore even = new Semaphore(0);
        private Semaphore odd = new Semaphore(0);
        private volatile int num;

        public ZeroEvenOdd(int n) {
            this.n = n;
            num = 1;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(;num <= n;){
                zero.acquire();
                if(num <= n)
                    printNumber.accept(0);
                if(num % 2 == 0){
                    even.release();
                }else{
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(;num <= n;){
                even.acquire();
                if(num <= n)
                    printNumber.accept(num);
                num++;
                zero.release();

            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(;num <= n;){
                odd.acquire();
                if(num <= n)
                    printNumber.accept(num);
                num++;
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(15);
        executorService.submit(()->{zeroEvenOdd.zero(x-> System.out.print(x));return null;});
        executorService.submit(()->{zeroEvenOdd.odd(x-> {
            if (x % 2 != 0) {
                System.out.print(x + " ");
            } else {
                System.out.print("error");
            }
        });return null;});
        executorService.submit(()->{zeroEvenOdd.even(x-> {
            if (x % 2 == 0) {
                System.out.print(x + " ");
            } else {
                System.out.print("error");
            }
        });return null;});
        executorService.shutdown();
    }
}

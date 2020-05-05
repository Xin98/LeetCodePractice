package cn.codexin.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Created by xinGao 2020/5/5
 */

public class Q1195_Fizz_Buzz_Multithreaded {
    static class FizzBuzz {
        private int n;
        private volatile int count = 0;
        Semaphore fizzSmp = new Semaphore(0);
        Semaphore buzzSmp = new Semaphore(0);
        Semaphore fbSmp = new Semaphore(0);
        Semaphore numSmp = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while(true){
                fizzSmp.acquire();
                //终止线程条件
                if(count > n) break;
                printFizz.run();
                numSmp.release();
            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while(true){
                buzzSmp.acquire();
                //终止线程条件
                if(count > n) break;
                printBuzz.run();
                numSmp.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true){
                fbSmp.acquire();
                //终止线程条件
                if(count > n) break;
                printFizzBuzz.run();
                numSmp.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            //number线程是控制线程，它控制着其他三个输出字符线程的输出时机。
            while(count <= n){
                numSmp.acquire();
                //把count的修改写在其他信号量的release之前可以避免其他线程观察到的count与预期不一样的情况。
                count++;
                //因为count写在前面了，所以这里要判断count是否超过了n
                if(count > n) break;
                if(count % 3 == 0 && count % 5 == 0) fbSmp.release();
                else if(count % 3 == 0) fizzSmp.release();
                else if(count % 5 == 0) buzzSmp.release();
                else {
                    printNumber.accept(count);
                    numSmp.release();
                }
                //如果把count写在release之后，可能在其他线程会观察到count值为 count + 1 的情况。

            }
            //count > n后，释放其他信号量使他们可以各自终止线程
            fbSmp.release();
            fizzSmp.release();
            buzzSmp.release();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(()->{fizzBuzz.fizz(()-> System.out.println("fizz")); return null;});
        executorService.submit(()->{fizzBuzz.buzz(()-> System.out.println("buzz")); return null;});
        executorService.submit(()->{fizzBuzz.fizzbuzz(()-> System.out.println("fizzbuzz")); return null;});
        executorService.submit(()->{fizzBuzz.number(x-> System.out.println(x)); return null;});
        executorService.shutdown();
    }
}

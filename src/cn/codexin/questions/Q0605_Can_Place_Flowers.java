package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/1
 */

public class Q0605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(n <= 0) {
                return true;
            }
            if(flowerbed[i] == 0) {
                if(i != 0 && flowerbed[i - 1] == 1 || i != len - 1 && flowerbed[i + 1] == 1) {
                    continue;
                }
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}

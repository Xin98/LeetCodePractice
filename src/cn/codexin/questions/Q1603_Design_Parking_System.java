package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/19
 */

public class Q1603_Design_Parking_System {
    class ParkingSystem {
        private int[] pos;
        public ParkingSystem(int big, int medium, int small) {
            this.pos = new int[3];
            this.pos[0] = big;
            this.pos[1] = medium;
            this.pos[2] = small;
        }

        public boolean addCar(int carType) {
            if(pos[carType - 1] > 0) {
                pos[carType - 1]--;
                return true;
            }
            return false;
        }
    }
}

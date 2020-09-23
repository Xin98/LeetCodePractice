package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/23
 */

public class Q0640_Solve_the_Equation {
    public String solveEquation(String equation) {
        int lx = 0, rx = 0, lnum = 0, rnum = 0;
        int n = equation.length();
        boolean right = false;
        for(int i = 0; i < n; i++) {
            if(equation.charAt(i) == '=') {
                right = true;
                continue;
            }
            boolean nag = false;
            if(equation.charAt(i) == '-') {
                nag = true;
                i++;
            } else if (equation.charAt(i) == '+') {
                i++;
            }
            boolean x = false;
            int num = 0;

            while(i < n) {
                char c = equation.charAt(i);
                if(c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else {
                    if(c == 'x') {
                        x = true;
                        if(i == 0 || (num == 0 && equation.charAt(i-1) != '0')) {
                            num = 1;
                        }
                    } else {
                        i--;
                    }
                    break;
                }
                i++;
            }
            int coe = nag ? (-num) : num;
            if(right) {
                rx += x ? coe : 0;
                rnum += x ? 0 : coe;
            } else {
                lx += x ? coe : 0;
                lnum += x ? 0 : coe;
            }

        }
        if(lx == rx) {
            if(lnum == rnum) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        int result = (rnum - lnum) / (lx - rx);
        return "x=" + result;
    }

    public static void main(String[] args) {
        Q0640_Solve_the_Equation Q = new Q0640_Solve_the_Equation();
        Q.solveEquation("x+5-3+x=6+x-2");
    }
}

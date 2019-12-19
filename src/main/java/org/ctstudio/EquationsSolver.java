package org.ctstudio;

import java.math.BigDecimal;


/**
 * 二元一次方程组解题器，能解以下形式的二元一次方程组：
 * a1*x+b1*y+c1=0
 * a2*x+b2*y+c2=0
 * 解题要求请参考README.md
 */
public class EquationsSolver {
    /**
     * 方程组里的参数
     */
    private double a1;
    private double a2;
    private double b1;
    private double b2;
    private double c1;
    private double c2;
    private double resultX;//结果X
    private double resultY;//结果Y

    /**
     * 构造方法
     *
     * @param a1
     * @param a2
     * @param b1
     * @param b2
     * @param c1
     * @param c2
     */
    public EquationsSolver(double a1, double b1, double c1, double a2, double b2, double c2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
    }

    public Double getX() {
        //判断方程组是否有解
        if (a1 * b2 - b1 * a2 == 0) {
            return null;
        }
        //如果b1为0
        if (b1 == 0 && a1 != 0) {
            resultX = div(-c1, a1);
            return resultX;
        } else if (b2 == 0 && a2 != 0) {//如果b2为0
            resultX = div(-c2, a2);
            return resultX;
        }
        resultX = div(b1 * c2 - c1 * b2, a1 * b2 - b1 * a2);
        return resultX;

    }

    public Double getY() {
        //判断方程组是否有解
        if (a1 * b2 - b1 * a2 == 0) {
            return null;
        }
        //如果a1为0
        if (a1 == 0 && b1 != 0) {
            resultY = div(-c1, b1);
            return resultY;
        } else if (a2 == 0 && b2 != 0) {//如果a2为0
            resultY = div(-c2, b2);
            return resultY;
        }
        resultY = div(a2 * c1 - c2 * a1, a1 * b2 - b1 * a2);
        return resultY;
    }

    /**
     * 两个数相除
     * 这样可以不用先/再加上%的值  防止丢失精度
     *
     * @param x
     * @param y
     * @return
     */
    public double div(double x, double y) {
        BigDecimal bigDecimal = new BigDecimal(x);
        BigDecimal bigDecimal2 = new BigDecimal(y);
        return bigDecimal.divide(bigDecimal2).doubleValue();
    }

    public static void main(String[] args) {
        EquationsSolver solver1 = new EquationsSolver(1.0, 1.0, 6.0, 3.0, 1.0, 7.0);
        System.out.println(solver1.getX());
        System.out.println(solver1.getY());

    }

}

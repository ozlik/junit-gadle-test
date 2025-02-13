package shilova;

import java.util.Objects;

public class Fraction {
    Integer num;
    Integer den;

    public Integer getNum() {
        return num;
    }

    public Integer getDen() {
        return den;
    }

    public Fraction(Integer num, Integer den) {
        nullChecker(num, den);
        this.num = num;
        this.den = den;
    }

    public void nullChecker(Integer num, Integer den) {
        if (num == null || den == null) {
            throw new NullPointerException("значение не должно быть равно нулю");
        }
        if (den == 0) {
            throw new ArithmeticException("нельзя делить на ноль");
        }
    }

    public static Fraction sum(Fraction first, Fraction second) {
        long bigCommonDen = ((long) first.getDen() * (long) second.getDen());
        if (bigCommonDen > Integer.MAX_VALUE) {
            throw new RuntimeException("знаменатель слишком большой");
        }
        Integer commonDen = first.getDen() * second.getDen();
        Integer sumNum = first.getNum() * second.getDen() + second.getNum() * first.getDen();
        return new Fraction(sumNum, commonDen);
    }

       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Objects.equals(num, fraction.num) && Objects.equals(den, fraction.den);
    }
}

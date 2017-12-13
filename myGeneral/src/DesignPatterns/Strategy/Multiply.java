package DesignPatterns.Strategy;

public class Multiply implements Strategy {

    @Override
    public void Operation(int num1, int num2) {
        System.out.println(num2 * num1);
    }

}

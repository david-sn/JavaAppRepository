package DesignPatterns.Strategy;

public class Add implements Strategy {

    @Override
    public void Operation(int num1, int num2) {
        System.out.println(num1 + num2);

    }

}

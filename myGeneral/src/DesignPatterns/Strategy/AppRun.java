package DesignPatterns.Strategy;


public class AppRun {

    public static void main(String[] args) {

        ManagerCompisition compisition=new  ManagerCompisition();
        compisition.setStrategy(new Multiply());
        compisition.Operation(5, 5);
        
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.Strategy;

/**
 *
 * @author D.Nazer
 */
public class ManagerCompisition implements Strategy {

    private Strategy strategy;

    //this for change instance of interface at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void Operation(int num1, int num2) {
        this.strategy.Operation(num1, num2);
    }

}

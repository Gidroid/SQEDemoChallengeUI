package com.sample.model;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class PizzaData {
    private PizzaTypes pizzaType;
    private PizzaToppings firstTopping = null;
    private PizzaToppings secondTopping = null;
    private String quantity = "0";
    private String cost = "0";

    public PizzaTypes getPizzaType() {
        return pizzaType;
    }

    public PizzaData setPizzaType(PizzaTypes pizzaType) {
        this.pizzaType = pizzaType;
        return this;
    }

    public String getFirstTopping() {
        return firstTopping.getDisplayName();
    }

    public PizzaData setFirstTopping(PizzaToppings firstTopping) {
        this.firstTopping = firstTopping;
        return this;
    }

    public String getSecondTopping() {
        return secondTopping.getDisplayName();
    }

    public PizzaData setSecondTopping(PizzaToppings secondTopping) {
        this.secondTopping = secondTopping;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public PizzaData setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getCost() {
        if ("0".equals(cost)) {
            cost = String.valueOf(pizzaType.getCost() * Integer.parseInt(quantity));
        }
        return cost;
    }

    public PizzaData setCost(String cost) {
        this.cost = cost;
        return this;
    }
}

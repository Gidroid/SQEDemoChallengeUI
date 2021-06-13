package com.sample.pages.sections;

import com.sample.model.PizzaData;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.Arrays;

public class PizzaSection extends HtmlElement {
    @FindBy(id = "pizza1Pizza")
    private Select pizzaTypeDropdown;

    @FindBy(className = "toppings1")
    private Select firstToppingDropdown;

    @FindBy(className = "toppings2")
    private Select secondToppingDropdown;

    @FindBy(id = "pizza1Qty")
    private TextInput quantityInput;

    @FindBy(id = "pizza1Cost")
    private TextBlock costTextBox;

    public void fillWith(PizzaData pizza) {
        pizzaTypeDropdown.selectByValue(pizza.getPizzaType().getDisplayName());
        if(pizza.getFirstTopping() != null) {
            firstToppingDropdown.selectByValue(pizza.getFirstTopping());
        }
        if(pizza.getSecondTopping() != null) {
            secondToppingDropdown.selectByValue(pizza.getSecondTopping());
        }
        quantityInput.sendKeys(pizza.getQuantity());
        costTextBox.click();
    }

    public PizzaData getFilledForm() {
        String selectedPizzaType = pizzaTypeDropdown.getFirstSelectedOption().getText();
        String firstTopping = firstToppingDropdown.getFirstSelectedOption().getText();
        String secondTopping = secondToppingDropdown.getFirstSelectedOption().getText();
        String quantity = quantityInput.getText();
        String cost = costTextBox.getAttribute("value");
        PizzaData pizza = new PizzaData()
                .setPizzaType(getTypeByDisplayName(selectedPizzaType))
                .setQuantity(quantity)
                .setCost(cost);
        if(!firstTopping.isEmpty()) {
            pizza.setFirstTopping(getToppingByName(firstTopping));
        }
        if(!secondTopping.isEmpty()) {
            pizza.setSecondTopping(getToppingByName(secondTopping));
        }
        return pizza;
    }

    private PizzaTypes getTypeByDisplayName(String displayName) {
        return Arrays.stream(PizzaTypes.values())
                .filter(pizzaType -> pizzaType.getDisplayName().equals(displayName))
                .findFirst().orElse(null);
    }

    private PizzaToppings getToppingByName(String toppingName) {
        return Arrays.stream(PizzaToppings.values())
                .filter(pizzaTopping -> pizzaTopping.getDisplayName().equals(toppingName))
                .findFirst().orElse(null);
    }
}

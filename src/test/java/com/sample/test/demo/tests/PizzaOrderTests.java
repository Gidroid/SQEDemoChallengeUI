package com.sample.test.demo.tests;

import com.sample.model.PizzaData;
import com.sample.model.UserData;
import com.sample.pages.DialogForm;
import com.sample.pages.PizzaOrderPage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PaymentOptions;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PizzaOrderTests extends TestBase {

    @Test
    public void verifyTitle() {
        String title = new PizzaOrderPage(driver).title();
        assertThat(title).isEqualTo("Pizza Order Form");
    }

    @Test
    public void userCanOrderPizza() {
        PizzaData pizzaData = new PizzaData()
                .setPizzaType(PizzaTypes.MEDIUM_TWOTOPPINGS)
                .setFirstTopping(PizzaToppings.MOZZARELLA)
                .setSecondTopping(PizzaToppings.OLIVES)
                .setQuantity("1");
        UserData userData = UserData.builder()
                .name("Kevin")
                .email("test@test.com")
                .phone("123456")
                .build();

        DialogForm dialogForm = new PizzaOrderPage(driver)
                .fillPizzaFormWith(pizzaData)
                .fillPuckUpInformationWith(userData)
                .selectPaymentMethod(PaymentOptions.CASH_ON_PICKUP)
                .placeOrder();
        String bodyText = dialogForm.getBodyText();
        dialogForm.closeDialog();

        Assert.assertEquals(bodyText, "Thank you for your order! TOTAL: 9.75 Medium 8 Slices - 2 toppings");
    }

    @Test
    public void verifyUserGetErrorIfRequiredFieldsNotFilled() {
        PizzaData pizzaData = new PizzaData()
                .setPizzaType(PizzaTypes.MEDIUM_TWOTOPPINGS)
                .setFirstTopping(PizzaToppings.MOZZARELLA)
                .setSecondTopping(PizzaToppings.OLIVES)
                .setQuantity("1");
        UserData userData = UserData.builder()
                .email("test@test.com")
                .build();

        DialogForm dialogForm = new PizzaOrderPage(driver)
                .fillPizzaFormWith(pizzaData)
                .fillPuckUpInformationWith(userData)
                .selectPaymentMethod(PaymentOptions.CASH_ON_PICKUP)
                .placeOrder();

        String bodyText = dialogForm.getBodyText();
        dialogForm.closeDialog();

        assertThat(bodyText).isEqualTo("Missing name\nMissing phone number");
    }

    @Test
    public void verifyAllSpecifiedDataIsClearAfterClickingResetButton() {
        PizzaData pizzaData = new PizzaData()
                .setPizzaType(PizzaTypes.MEDIUM_TWOTOPPINGS)
                .setFirstTopping(PizzaToppings.MOZZARELLA)
                .setSecondTopping(PizzaToppings.OLIVES)
                .setQuantity("1");
        UserData userData = UserData.builder()
                .name("Kevin")
                .email("test@test.com")
                .phone("123456")
                .build();

        PizzaOrderPage pizzaOrderPage = new PizzaOrderPage(driver)
                .fillPizzaFormWith(pizzaData)
                .fillPuckUpInformationWith(userData)
                .selectPaymentMethod(PaymentOptions.CASH_ON_PICKUP)
                .resetForm();

        PizzaData filledPizzaForm = pizzaOrderPage.getFilledPizzaForm();
        UserData filledUserForm = pizzaOrderPage.getFilledPickUpInformation();
        String selectedPaymentMethod = pizzaOrderPage.getSelectedPaymentMethod();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(filledPizzaForm).usingRecursiveComparison().isEqualTo(new PizzaData());
        softly.assertThat(filledUserForm).usingRecursiveComparison().isEqualTo(UserData.builder().build());
        softly.assertThat(selectedPaymentMethod).isEmpty();
        softly.assertAll();
    }

    @Test
    public void verifyFilledPizzaForm() {
        PizzaData expectedPizza = new PizzaData()
                .setPizzaType(PizzaTypes.MEDIUM_TWOTOPPINGS)
                .setFirstTopping(PizzaToppings.MOZZARELLA)
                .setSecondTopping(PizzaToppings.OLIVES)
                .setQuantity("1");

        PizzaData actualPizza = new PizzaOrderPage(driver)
                .fillPizzaFormWith(expectedPizza)
                .getFilledPizzaForm();

        assertThat(actualPizza).usingRecursiveComparison().isEqualTo(expectedPizza);
    }
}

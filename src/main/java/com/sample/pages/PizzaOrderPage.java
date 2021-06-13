package com.sample.pages;

import com.sample.model.PizzaData;
import com.sample.model.UserData;
import com.sample.pages.sections.PaymentSection;
import com.sample.pages.sections.PizzaSection;
import com.sample.pages.sections.UserSection;
import com.sample.test.demo.constants.PaymentOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PizzaOrderPage {
    @FindBy(id = "pizza1")
    private PizzaSection pizzaSection;

    @FindBy(id = "pickupInfo")
    private UserSection pickUpInformationSection;

    @FindBy(id = "paymentSection")
    private PaymentSection paymentSection;

    private static final By ORDER_BUTTON_LOCATOR = By.id("placeOrder");
    private static final By RESET_BUTTON_LOCATOR = By.id("reset");
    private static final By DIALOG_LOCATOR = By.xpath("//div[@role=\"dialog\"]");

    private final WebDriver driver;

    public PizzaOrderPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public String title() {
        return driver.getTitle();
    }

    public PizzaOrderPage fillPizzaFormWith(PizzaData pizzaData) {
        pizzaSection.fillWith(pizzaData);
        return this;
    }

    public PizzaData getFilledPizzaForm() {
        return pizzaSection.getFilledForm();
    }

    public PizzaOrderPage fillPuckUpInformationWith(UserData userData) {
        pickUpInformationSection.fillWith(userData);
        return this;
    }

    public UserData getFilledPickUpInformation() {
        return pickUpInformationSection.getFilledForm();
    }

    public PizzaOrderPage selectPaymentMethod(PaymentOptions paymentOption) {
        paymentSection.payBY(paymentOption);
        return this;
    }

    public String getSelectedPaymentMethod() {
        return paymentSection.getSelectedPayment();
    }

    public DialogForm placeOrder() {
        driver.findElement(ORDER_BUTTON_LOCATOR).click();
        WebElement dialogElement = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(DIALOG_LOCATOR));
        return new DialogForm(dialogElement);
    }

    public PizzaOrderPage resetForm() {
        driver.findElement(RESET_BUTTON_LOCATOR).click();
        return this;
    }
}

package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DialogForm {
    private static final By CLOSE_BUTTON_LOCATOR = By.xpath("//button[@title=\"Close\"]");
    private static final By BODY_TEXT_LOCATOR = By.xpath("//div[@id=\"dialog\"]/p");
    private final WebElement dialogElement;

    public DialogForm(WebElement dialogElement) {
        this.dialogElement = dialogElement;
    }

    public String getBodyText() {
        return dialogElement.findElement(BODY_TEXT_LOCATOR).getText();
    }

    public void closeDialog() {
        dialogElement.findElement(CLOSE_BUTTON_LOCATOR).click();
    }
}

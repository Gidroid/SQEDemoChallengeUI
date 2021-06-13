package com.sample.pages.sections;

import com.sample.model.UserData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class UserSection extends HtmlElement {
    @FindBy(id = "name")
    private TextInput nameInput;

    @FindBy(id = "email")
    private TextInput emailInput;

    @FindBy(id = "phone")
    private TextInput phoneInput;

    public void fillWith(UserData user) {
        nameInput.sendKeys(user.getName());
        emailInput.sendKeys(user.getEmail());
        phoneInput.sendKeys(user.getPhone());
    }

    public UserData getFilledForm() {
       return UserData
                .builder()
                .name(nameInput.getText())
                .email(emailInput.getText())
                .phone(phoneInput.getText())
                .build();
    }
}

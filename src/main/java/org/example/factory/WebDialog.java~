package org.example.factory;

import org.example.Button.Button;
import org.example.Button.HTMLButton;
import org.example.CheckBox.CheckBox;
import org.example.CheckBox.WebCheckBox;

public class WebDialog extends Dialog {


    @Override
    Button createButton() {
        return new HTMLButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WebCheckBox();
    }
}
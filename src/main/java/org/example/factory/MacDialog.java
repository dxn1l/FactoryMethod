package org.example.factory;

import org.example.Button.Button;
import org.example.Button.MacButton;
import org.example.CheckBox.CheckBox;
import org.example.CheckBox.MacCheckBox;

public class MacDialog extends Dialog {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

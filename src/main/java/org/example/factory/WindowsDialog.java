package org.example.factory;

import org.example.Button.Button;
import org.example.Button.WindowsButton;
import org.example.CheckBox.CheckBox;
import org.example.CheckBox.WindowsCheckBox;

public class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

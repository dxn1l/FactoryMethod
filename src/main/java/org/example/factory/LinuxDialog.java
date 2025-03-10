package org.example.factory;

import org.example.Button.Button;
import org.example.Button.LinuxButton;
import org.example.CheckBox.CheckBox;
import org.example.CheckBox.LinuxCheckBox;

public class LinuxDialog extends Dialog {
    @Override
    Button createButton() {
        return new LinuxButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new LinuxCheckBox();
    }
}

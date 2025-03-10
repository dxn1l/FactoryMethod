package org.example.factory;

class MacDialog extends Dialog {
    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

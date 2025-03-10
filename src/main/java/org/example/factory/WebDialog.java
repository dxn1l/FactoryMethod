package org.example.factory;

class WebDialog extends Dialog {


    @Override
    Button createButton() {
        return new HTMLButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WebCheckBox();
    }
}
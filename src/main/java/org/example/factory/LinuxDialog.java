package org.example.factory;

class LinuxDialog extends Dialog {
    @Override
    Button createButton() {
        return new LinuxButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new LinuxCheckBox();
    }
}

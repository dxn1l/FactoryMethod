package org.example.factory;

class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

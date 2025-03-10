package org.example.factory;

abstract class Dialog {
    abstract Button createButton(); // Método fábrica
    abstract CheckBox createCheckBox();


    public void render() {
        Button button = createButton(); // Crea el botón adecuado
        CheckBox checkBox = createCheckBox();

        button.render();
        button.onClick();

        checkBox.render();
        checkBox.onToggle();
    }
}

package org.example.factory;

import org.example.Button.Button;
import org.example.CheckBox.CheckBox;

public abstract class Dialog {
    public abstract Button createButton(); // Método fábrica
    public abstract CheckBox createCheckBox();


    public void render() {
        Button button = createButton(); // Crea el botón adecuado
        CheckBox checkBox = createCheckBox();

        button.render();
        button.onClick();

        checkBox.render();
        checkBox.onToggle();
    }
}

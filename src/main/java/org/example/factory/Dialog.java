package org.example.factory;

abstract class Dialog {
    abstract Button createButton(); // Método fábrica

    public void render() {
        Button okButton = createButton(); // Crea el botón adecuado
        okButton.onClick();
        okButton.render();
    }
}

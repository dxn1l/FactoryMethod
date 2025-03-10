package org.example.factory;

class WebCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Renderizando un checkbox estilo Web");
    }

    @Override
    public void onToggle() {
        System.out.println("Checkbox Web cambiado de estado");
    }
}

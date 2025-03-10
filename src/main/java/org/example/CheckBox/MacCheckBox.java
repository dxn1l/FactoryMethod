package org.example.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Renderizando un checkbox estilo MacOS");
    }

    @Override
    public void onToggle() {
        System.out.println("Checkbox de MacOS cambiado de estado");
    }
}

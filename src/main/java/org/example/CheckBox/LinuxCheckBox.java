package org.example.CheckBox;

public class LinuxCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Renderizando un checkbox estilo Linux");
    }

    @Override
    public void onToggle() {
        System.out.println("Checkbox de Linux cambiado de estado");
    }
}

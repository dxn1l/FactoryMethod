package org.example.factory;

class WindowsCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Renderizando un checkbox estilo Windows");
    }

    @Override
    public void onToggle() {
        System.out.println("Checkbox de Windows cambiado de estado");
    }
}

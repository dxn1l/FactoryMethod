package org.example.Button;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando un botón estilo MacOS");
    }

    @Override
    public void onClick() {
        System.out.println("Clic en botón de MacOS");
    }
}

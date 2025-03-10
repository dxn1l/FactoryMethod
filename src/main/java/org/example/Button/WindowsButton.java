package org.example.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando un botón estilo Windows");
    }

    @Override
    public void onClick() {
        System.out.println("Clic en botón de Windows");
    }
}

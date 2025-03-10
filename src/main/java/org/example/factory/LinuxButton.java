package org.example.factory;

class LinuxButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando un botón estilo Linux");
    }

    @Override
    public void onClick() {
        System.out.println("Clic en botón de Linux");
    }
}

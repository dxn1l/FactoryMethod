package org.example.factory;

class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando un botón HTML");
    }

    @Override
    public void onClick() {
        System.out.println("Clic en botón HTML");
    }
}

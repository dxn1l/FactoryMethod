package org.example.factory;

public class Application {
    private static Dialog dialog;

    public static void initialize(String os) {
        if ("Windows".equalsIgnoreCase(os)) {
            dialog = new WindowsDialog();
        } else if ("Web".equalsIgnoreCase(os)) {
            dialog = new WebDialog();
        } else {
            throw new RuntimeException("Error! Sistema operativo desconocido.");
        }
    }

    public static void main(String[] args) {
        // Simulamos una configuración del sistema
        String configOS = "Windows"; // Cambia a "Web" para probar otro tipo de botón
        initialize(configOS);
        dialog.render();
    }
}

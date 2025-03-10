package org.example.factory;

import org.example.Application;
import org.example.Button.Button;
import org.example.Button.HTMLButton;
import org.example.Button.WindowsButton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {
    @Test
    void testWindowsButtonCreation() {
        Dialog dialog = new WindowsDialog();
        Button button = dialog.createButton();
        assertTrue(button instanceof WindowsButton, "El botón debe ser una instancia de WindowsButton");
    }

    @Test
    void testWebButtonCreation() {
        Dialog dialog = new WebDialog();
        Button button = dialog.createButton();
        assertTrue(button instanceof HTMLButton, "El botón debe ser una instancia de HTMLButton");
    }

    @Test
    void testWindowsDialogRendering() {
        Dialog dialog = new WindowsDialog();
        assertDoesNotThrow(dialog::render, "Renderización del WindowsDialog no debe lanzar excepciones");
    }

    @Test
    void testWebDialogRendering() {
        Dialog dialog = new WebDialog();
        assertDoesNotThrow(dialog::render, "Renderización del WebDialog no debe lanzar excepciones");
    }

    @Test
    void testApplicationInitializationWindows() {
        assertDoesNotThrow(() -> Application.initialize("Windows"), "Inicialización con Windows no debe lanzar excepción");
    }

    @Test
    void testApplicationInitializationWeb() {
        assertDoesNotThrow(() -> Application.initialize("Web"), "Inicialización con Web no debe lanzar excepción");
    }

    @Test
    void testApplicationInitializationError() {
        assertThrows(RuntimeException.class, () -> Application.initialize("Linux"), "Debe lanzar excepción para SO desconocido");
    }
}

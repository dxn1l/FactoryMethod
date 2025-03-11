package org.example;

import org.example.Button.Button;
import org.example.factory.*;
import org.example.Button.*;
import org.example.CheckBox.*;
import org.example.factory.Dialog;

import javax.swing.*;
import java.awt.*;

public class Application {
    private static Dialog dialog;
    private static JTextArea terminal;


    public static void initialize(String os) {
        switch (os.toLowerCase()) {
            case "windows":
                dialog = new WindowsDialog();
                break;
            case "web":
                dialog = new WebDialog();
                break;
            case "mac":
                dialog = new MacDialog();
                break;
            case "linux":
                dialog = new LinuxDialog();
                break;
            default:
                throw new RuntimeException("Error! Sistema operativo desconocido.");
        }
    }

    public static void main(String[] args) {
        // Aplicar tema oscuro
        setDarkMode();

        // Crear la ventana principal
        JFrame frame = new JFrame("Factory Method - Selector de Botón");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Dropdown para seleccionar el sistema
        String[] options = {"Windows", "Mac", "Linux", "Web"};
        JComboBox<String> osSelector = new JComboBox<>(options);
        osSelector.setBackground(Color.DARK_GRAY);
        osSelector.setForeground(Color.GREEN);

        JButton createButton = new JButton("Crear Botón");
        createButton.setBackground(Color.BLACK);
        createButton.setForeground(Color.GREEN);

        // Panel superior con selección de sistema
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        JLabel label = new JLabel("Selecciona el sistema:");
        label.setForeground(Color.GREEN);
        topPanel.add(label);
        topPanel.add(osSelector);
        topPanel.add(createButton);

        // Área de texto para simular la terminal
        terminal = new JTextArea();
        terminal.setEditable(false);
        terminal.setBackground(Color.BLACK);
        terminal.setForeground(Color.GREEN);
        JScrollPane scrollPane = new JScrollPane(terminal);

        // Agregar componentes al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Acción del botón para crear el botón seleccionado
        createButton.addActionListener(e -> {
            String selectedOS = (String) osSelector.getSelectedItem();
            initialize(selectedOS);
            renderButton(frame);
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }

    private static void setDarkMode() {
        try {
            UIManager.put("Panel.background", Color.BLACK);
            UIManager.put("Label.foreground", Color.GREEN);
            UIManager.put("Button.background", Color.DARK_GRAY);
            UIManager.put("Button.foreground", Color.GREEN);
            UIManager.put("ComboBox.background", Color.BLACK);
            UIManager.put("ComboBox.foreground", Color.GREEN);
            UIManager.put("ScrollPane.background", Color.BLACK);
            UIManager.put("TextArea.background", Color.BLACK);
            UIManager.put("TextArea.foreground", Color.GREEN);
            UIManager.put("CheckBox.background", Color.BLACK);
            UIManager.put("CheckBox.foreground", Color.GREEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void renderButton(JFrame frame) {
        // Eliminar el panel inferior antes de agregar el nuevo
        Container contentPane = frame.getContentPane();

        // Remover solo el panel inferior sin afectar la selección y la terminal
        Component[] components = contentPane.getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel && comp != contentPane.getComponent(0)) { // No eliminar el panel superior
                contentPane.remove(comp);
            }
        }

        // Crear el botón usando Factory Method
        Button button = dialog.createButton();
        CheckBox checkBox = dialog.createCheckBox();

        // Crear panel inferior
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setLayout(new FlowLayout());

        // Botón generado dinámicamente
        JButton dynamicButton = new JButton("Botón " + button.getClass().getSimpleName());
        dynamicButton.setBackground(Color.DARK_GRAY);
        dynamicButton.setForeground(Color.GREEN);
        dynamicButton.addActionListener(e -> {
            terminal.append("\n-> " + button.getClass().getSimpleName() + " \n fue presionado\n");
            terminal.append("   " + simulateButtonAction(button) + "\n\n");
        });

        // Checkbox generado dinámicamente
        JCheckBox dynamicCheckBox = new JCheckBox("CheckBox");
        dynamicCheckBox.setBackground(Color.BLACK);
        dynamicCheckBox.setForeground(Color.GREEN);
        dynamicCheckBox.addActionListener(e -> {
            terminal.append("\n-> " + checkBox.getClass().getSimpleName() + " cambiado de estado\n\n");
        });

        // Agregar elementos al panel
        bottomPanel.add(dynamicButton);
        bottomPanel.add(dynamicCheckBox);

        // Agregar el nuevo panel al frame
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Refrescar la interfaz
        frame.revalidate();
        frame.repaint();
    }

    private static String simulateButtonAction(Button button) {
        return "Acción: " + (button instanceof WindowsButton ? "Abrir menú" :
                button instanceof MacButton ? "Abrir Spotlight" :
                        button instanceof LinuxButton ? "Abrir terminal" :
                                button instanceof HTMLButton ? "Navegar a una página" : "Acción desconocida");
    }
}




package org.example;

import org.example.view.FarmaciaGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Farmácia...");

        // Inicia a interface gráfica
        SwingUtilities.invokeLater(() -> {
            FarmaciaGUI gui = new FarmaciaGUI();
            gui.setVisible(true);
        });

        // Mantém o console ativo para logs adicionais se necessário
        System.out.println("Sistema em execução. Use a interface gráfica para interagir.");
    }
}
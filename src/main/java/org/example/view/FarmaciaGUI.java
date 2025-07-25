package org.example.view;

import org.example.controller.BancoDeDados;
import org.example.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FarmaciaGUI extends JFrame {
    private BancoDeDados banco;
    private JTextArea outputArea;
    private JTextField nomeField, quantidadeField, tipoField, codigoField;

    public FarmaciaGUI() {
        banco = new BancoDeDados();

        setTitle("Sistema de Farmácia");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        inputPanel.add(codigoField);

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        inputPanel.add(quantidadeField);

        inputPanel.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        inputPanel.add(tipoField);

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        JButton editButton = new JButton("Editar");
        editButton.addActionListener(new EditButtonListener());
        inputPanel.add(editButton);

        add(inputPanel, BorderLayout.NORTH);

        // Área de saída
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Painel de ações
        JPanel actionPanel = new JPanel();

        JButton listButton = new JButton("Listar Medicamentos");
        listButton.addActionListener(e -> listarMedicamentos());
        actionPanel.add(listButton);

        JButton searchButton = new JButton("Pesquisar");
        searchButton.addActionListener(new SearchButtonListener());
        actionPanel.add(searchButton);

        JButton deleteButton = new JButton("Excluir");
        deleteButton.addActionListener(new DeleteButtonListener());
        actionPanel.add(deleteButton);

        add(actionPanel, BorderLayout.SOUTH);

        listarMedicamentos();
    }

    private void listarMedicamentos() {
        ArrayList<Item> itens = banco.ler();
        outputArea.setText("");

        if (itens == null || itens.isEmpty()) {
            outputArea.append("Nenhum medicamento cadastrado.\n");
            return;
        }

        outputArea.append("=== LISTA DE MEDICAMENTOS ===\n");
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            outputArea.append(String.format("%d - %s, %d, %s\n",
                    i, item.getNome(), item.getQuantidade(), item.getTipo()));
        }
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nome = nomeField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());
                String tipo = tipoField.getText();

                Item novoItem = new Item(nome, quantidade, tipo);
                banco.cadastrar(novoItem, true);

                outputArea.append("Medicamento adicionado com sucesso!\n");
                listarMedicamentos();

                // Limpar campos
                nomeField.setText("");
                quantidadeField.setText("");
                tipoField.setText("");
            } catch (NumberFormatException ex) {
                outputArea.append("Erro: Quantidade deve ser um número.\n");
            } catch (Exception ex) {
                outputArea.append("Erro ao adicionar medicamento: " + ex.getMessage() + "\n");
            }
        }
    }

    class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                String nome = nomeField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());
                String tipo = tipoField.getText();

                ArrayList<Item> itens = banco.ler();
                if (itens == null || codigo < 0 || codigo >= itens.size()) {
                    outputArea.append("Código inválido.\n");
                    return;
                }

                Item itemEditado = new Item(nome, quantidade, tipo);
                itens.set(codigo, itemEditado);

                // Reescrever todo o arquivo
                for (int i = 0; i < itens.size(); i++) {
                    banco.cadastrar(itens.get(i), i == 0 ? false : true);
                }

                outputArea.append("Medicamento editado com sucesso!\n");
                listarMedicamentos();

                // Limpar campos
                codigoField.setText("");
                nomeField.setText("");
                quantidadeField.setText("");
                tipoField.setText("");
            } catch (NumberFormatException ex) {
                outputArea.append("Erro: Código e quantidade devem ser números.\n");
            } catch (Exception ex) {
                outputArea.append("Erro ao editar medicamento: " + ex.getMessage() + "\n");
            }
        }
    }

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                ArrayList<Item> itens = banco.ler();

                Item item = banco.pesquisar(codigo, itens);
                if (item == null) {
                    outputArea.append("Medicamento não encontrado.\n");
                    return;
                }

                outputArea.append(String.format("Resultado da pesquisa:\n%d - %s, %d, %s\n",
                        codigo, item.getNome(), item.getQuantidade(), item.getTipo()));

                // Preencher campos com os dados encontrados
                nomeField.setText(item.getNome());
                quantidadeField.setText(String.valueOf(item.getQuantidade()));
                tipoField.setText(item.getTipo());
            } catch (NumberFormatException ex) {
                outputArea.append("Erro: Código deve ser um número.\n");
            }
        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                ArrayList<Item> itens = banco.ler();

                if (itens == null || codigo < 0 || codigo >= itens.size()) {
                    outputArea.append("Código inválido.\n");
                    return;
                }

                banco.excluir(codigo, itens);
                outputArea.append("Medicamento excluído com sucesso!\n");
                listarMedicamentos();

                // Limpar campos
                codigoField.setText("");
                nomeField.setText("");
                quantidadeField.setText("");
                tipoField.setText("");
            } catch (NumberFormatException ex) {
                outputArea.append("Erro: Código deve ser um número.\n");
            } catch (Exception ex) {
                outputArea.append("Erro ao excluir medicamento: " + ex.getMessage() + "\n");
            }
        }
    }
}
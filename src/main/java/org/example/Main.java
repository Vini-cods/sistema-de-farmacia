package org.example;

import org.example.controller.BancoDeDados;
import org.example.model.Item;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Farmácia");

        Item tilenol = new Item("Tilenol", 150, "Frasco");

        BancoDeDados banco = new BancoDeDados();
        banco.cadastrar(tilenol);



    }
}
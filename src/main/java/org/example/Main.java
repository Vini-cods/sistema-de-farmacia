package org.example;

import org.example.controller.BancoDeDados;
import org.example.model.Item;

public class Main {
    public static void main(String[] args) {

        Item dipirona = new Item("Dipirona 500mg", 100, "Caixa");
        Item bromoprida = new Item( "Bromoprida 200mg", 50, "Caixa");

        BancoDeDados banco = new BancoDeDados();
        banco.cadastrar(dipirona);
        banco.cadastrar(bromoprida);


    }
}
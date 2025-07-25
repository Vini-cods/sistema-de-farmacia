package org.example.controller;

import org.example.model.Item;

import java.io.*;

public class BancoDeDados {

    private Item item;

    public BancoDeDados() {

    }

    public void cadastrar(Item item) {
        try {
            OutputStream os = new FileOutputStream("medicamentos.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String linha = item.getNome()+","+item.getQuantidade()+","+item.getTipo();

            bw.write(linha);
            bw.newLine();

            bw.close();
            osw.close();
            os.close();

            System.out.println("O medicamento "+item.getNome()+" foi cadastrado com sucesso!!");
        } catch (Exception e){
            System.out.println("Não conseguiu cadastrar o medicamento!");
            System.out.println(e);
        }


    }

    public void editar(int codigo) {

    }

    public void pesquisar(int codigo) {

    }

    public void excluir(int codigo) {

    }

    public void ler() {
        try{
        InputStream is = new FileInputStream("medicamentod.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while (linha != null) {

        }

            System.out.println("O arquivo de medicamentos.txt foi lido com sucesso!");

    } catch(Exception e) {
            System.out.println("Não conseguiu ler o arquivo!");
        }
    }
}
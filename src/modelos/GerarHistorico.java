package modelos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Historico {

    public static void registrarNoHistorico(String siglaMoedaOrigem, String siglaMoedaDestino, double valor, double resultado, String simboloMoedaOrigem, String simboloMoedaDestino) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataAtual = new Date();
        String dataFormatada = formatter.format(dataAtual);

        //siglaMoedaOrigem = "USD";
        //siglaMoedaDestino = "BRL";
        //valor = 1;
        //resultado = 5;
        //siglaMoeda = "$";

        String valorFormatado = String.format("%.2f", valor);
        String resultadoFormatado = String.format("%.2f", resultado);


        try (PrintWriter writer = new PrintWriter(new FileWriter("historico.txt", true))) {
            writer.println("Conversão de: " + siglaMoedaOrigem + " para " + siglaMoedaDestino );
            writer.println("Valor a ser convertido: " + simboloMoedaOrigem + valorFormatado);
            writer.println("Resultado da Conversão: " + simboloMoedaDestino + resultadoFormatado);
            writer.println( "Data e Hora da Conversão: " + dataFormatada + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exibirHistorico() {
        File arquivo = new File("historico.txt");

        if (arquivo.exists() && arquivo.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Não existe arquivo historico.txt ou não há nenhuma conversão a ser mostrada.");
        }
    }

}

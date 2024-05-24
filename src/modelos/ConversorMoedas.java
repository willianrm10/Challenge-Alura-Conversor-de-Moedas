package modelos;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ConversorMoedas {
    Scanner sc = new Scanner(System.in);

    private double valorParaConversao, valorConvertido;
    private boolean validandoError;

    public double getValorParaConversao() {
        return valorParaConversao;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public boolean getValidandoError() {
        return validandoError;
    }

    public void fazerConversao(String moedaOrigem, String moedaDestino, JsonObject jsonResponse,
                               String descMoedaOrigem, String descMoedaDestino, String simboloMoeda) throws IOException {

       try {
           System.out.print("Informe o valor a ser convertido: ");
           //double quantiaParaConversao = Double.parseDouble(reader.readLine().trim());
           double quantiaParaConversao = sc.nextDouble();

           JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
           double valorMoedaOrigem = conversionRates.get(moedaOrigem).getAsDouble();
           double valorMoedaDestino = conversionRates.get(moedaDestino).getAsDouble();

           valorConvertido = (quantiaParaConversao / valorMoedaOrigem) * valorMoedaDestino;

           String resultadoFormatado = String.format("%.2f", valorConvertido);

           valorParaConversao = quantiaParaConversao;

           System.out.println(" ");
           System.out.println("#################################################");
           System.out.println("O valor convertido " + descMoedaOrigem + " para " + descMoedaDestino + " é: " + simboloMoeda + resultadoFormatado + "[" + moedaDestino + "]");
           System.out.println("#################################################");
           System.out.println(" ");
           validandoError = true;
       } catch (NumberFormatException e){
           System.out.println("\nPor favor, Use o Ponto ao invés da Virgula em casas decimais");
           System.out.println(e.getMessage());
           validandoError = false;
       }
    }
}

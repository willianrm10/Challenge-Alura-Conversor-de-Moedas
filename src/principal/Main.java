package principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import modelos.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorMoedas conversorMoedas = new ConversorMoedas();
        Scanner sc = new Scanner(System.in);

        SiglaMoedaEnum descMoedaOrigem;
        SiglaMoedaEnum descMoedaDestino;
        SimboloMoedaEnum simboloMoedaOrigem, simboloMoedaDestino;

        String siglaMoedaOrigem, siglaMoedaDestino;

        try {
            // Endereço da API com a chave
            String urlAPI = "https://v6.exchangerate-api.com/v6/e0e25deeb235767c51089dda/latest/USD";

            // Verificando a resposta do Json
            JsonObject jsonResponse = parseJsonResponse(urlAPI);

            // Selecionar uma opção referente ao Menu de Opções
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            boolean validOption = false;

            while (!validOption) {
                // Menu de Opções.....
                System.out.println("***************************************************");
                System.out.println(ConsoleColors.RED +"       Bem-vindo ao conversor de Moedas =)        ");
                System.out.println("***************************************************");

                System.out.println(ConsoleColors.BLUE  + "1  - Peso Argentino      =>>     Dólar");
                System.out.println(ConsoleColors.GREEN + "2  - Dólar               =>>     Peso Argentino");
                System.out.println(ConsoleColors.BLUE  + "3  - Real Brasileiro     =>>     Dólar");
                System.out.println(ConsoleColors.GREEN + "4  - Dólar               =>>     Real Brasileiro");
                System.out.println(ConsoleColors.BLUE  + "5  - Real Brasileiro     =>>     Iene");
                System.out.println(ConsoleColors.GREEN + "6  - Iene                =>>     Real Brasileiro");
                System.out.println(ConsoleColors.BLUE  + "7  - Real Brasileiro     =>>     Euro");
                System.out.println(ConsoleColors.GREEN + "8  - Euro                =>>     Real Brasileiro");
                System.out.println(ConsoleColors.BLUE  + "9  - Real Brasileiro     =>>     Libra Esterlina");
                System.out.println(ConsoleColors.GREEN + "10 - Libra Esterlina     =>>     Real Brasileiro");
                System.out.println(ConsoleColors.BLUE  + "11 - Dólar               =>>     Euro");
                System.out.println(ConsoleColors.GREEN + "12 - Euro                =>>     Dólar");
                System.out.println(ConsoleColors.BLUE  + "13 - Dólar               =>>     Libra Esterlina");
                System.out.println(ConsoleColors.GREEN + "14 - Libra Esterlina     =>>     Dólar");
                System.out.println(ConsoleColors.BLUE  + "15 - Visualizar o historico de conversão?");
                System.out.println(ConsoleColors.GREEN + "16 - Sair do Programa");

                System.out.println(ConsoleColors.RESET +"***************************************************");

                System.out.print("Escolha uma das opção Acima para realizar a conversão: ");
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        //convertCurrency("ARS", "USD", allowedCurrencyCodes, jsonResponse, reader);
                        descMoedaOrigem = SiglaMoedaEnum.ARS;
                        descMoedaDestino = SiglaMoedaEnum.USD;
                        simboloMoedaOrigem = SimboloMoedaEnum.ARS;
                        simboloMoedaDestino = SimboloMoedaEnum.USD;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.ARS);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.USD);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "2":
                        //convertCurrency("USD", "ARS", allowedCurrencyCodes, jsonResponse, reader);
                        descMoedaOrigem = SiglaMoedaEnum.USD;
                        descMoedaDestino = SiglaMoedaEnum.ARS;
                        simboloMoedaOrigem = SimboloMoedaEnum.USD;
                        simboloMoedaDestino = SimboloMoedaEnum.ARS;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.USD);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.ARS);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "3":
                        descMoedaOrigem = SiglaMoedaEnum.BRL;
                        descMoedaDestino = SiglaMoedaEnum.USD;
                        simboloMoedaOrigem = SimboloMoedaEnum.BRL;
                        simboloMoedaDestino = SimboloMoedaEnum.USD;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.BRL);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.USD);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "4":
                        descMoedaOrigem = SiglaMoedaEnum.USD;
                        descMoedaDestino = SiglaMoedaEnum.BRL;
                        simboloMoedaOrigem = SimboloMoedaEnum.USD;
                        simboloMoedaDestino = SimboloMoedaEnum.BRL;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.USD);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.BRL);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "5":
                        descMoedaOrigem = SiglaMoedaEnum.BRL;
                        descMoedaDestino = SiglaMoedaEnum.JPY;
                        simboloMoedaOrigem = SimboloMoedaEnum.BRL;
                        simboloMoedaDestino = SimboloMoedaEnum.JPY;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.BRL);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.JPY);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "6":
                        descMoedaOrigem = SiglaMoedaEnum.JPY;
                        descMoedaDestino = SiglaMoedaEnum.BRL;
                        simboloMoedaOrigem = SimboloMoedaEnum.JPY;
                        simboloMoedaDestino = SimboloMoedaEnum.BRL;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.JPY);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.BRL);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "7":
                        descMoedaOrigem = SiglaMoedaEnum.BRL;
                        descMoedaDestino = SiglaMoedaEnum.EUR;
                        simboloMoedaOrigem = SimboloMoedaEnum.BRL;
                        simboloMoedaDestino = SimboloMoedaEnum.EUR;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.BRL);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.EUR);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "8":
                        descMoedaOrigem = SiglaMoedaEnum.EUR;
                        descMoedaDestino = SiglaMoedaEnum.BRL;
                        simboloMoedaOrigem = SimboloMoedaEnum.EUR;
                        simboloMoedaDestino = SimboloMoedaEnum.BRL;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.EUR);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.BRL);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "9":
                        descMoedaOrigem = SiglaMoedaEnum.BRL;
                        descMoedaDestino = SiglaMoedaEnum.GBP;
                        simboloMoedaOrigem = SimboloMoedaEnum.BRL;
                        simboloMoedaDestino = SimboloMoedaEnum.GBP;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.BRL);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.GBP);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "10":
                        descMoedaOrigem = SiglaMoedaEnum.GBP;
                        descMoedaDestino = SiglaMoedaEnum.BRL;
                        simboloMoedaOrigem = SimboloMoedaEnum.GBP;
                        simboloMoedaDestino = SimboloMoedaEnum.BRL;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.GBP);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.BRL);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "11":
                        descMoedaOrigem = SiglaMoedaEnum.USD;
                        descMoedaDestino = SiglaMoedaEnum.EUR;
                        simboloMoedaOrigem = SimboloMoedaEnum.USD;
                        simboloMoedaDestino = SimboloMoedaEnum.EUR;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.USD);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.EUR);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "12":
                        descMoedaOrigem = SiglaMoedaEnum.EUR;
                        descMoedaDestino = SiglaMoedaEnum.USD;
                        simboloMoedaOrigem = SimboloMoedaEnum.EUR;
                        simboloMoedaDestino = SimboloMoedaEnum.USD;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.EUR);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.USD);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "13":
                        descMoedaOrigem = SiglaMoedaEnum.USD;
                        descMoedaDestino = SiglaMoedaEnum.GBP;
                        simboloMoedaOrigem = SimboloMoedaEnum.USD;
                        simboloMoedaDestino = SimboloMoedaEnum.GBP;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.USD);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.GBP);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse, descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "14":
                        descMoedaOrigem = SiglaMoedaEnum.GBP;
                        descMoedaDestino = SiglaMoedaEnum.USD;
                        simboloMoedaOrigem = SimboloMoedaEnum.GBP;
                        simboloMoedaDestino = SimboloMoedaEnum.USD;
                        siglaMoedaOrigem = String.valueOf(SiglaMoedaEnum.GBP);
                        siglaMoedaDestino = String.valueOf(SiglaMoedaEnum.USD);

                        conversorMoedas.fazerConversao(siglaMoedaOrigem,siglaMoedaDestino, jsonResponse,descMoedaOrigem.getDescricaoMoeda(), descMoedaDestino.getDescricaoMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );

                        if(conversorMoedas.getValidandoError()){
                            GerarHistorico.registrarNoHistorico(siglaMoedaOrigem,siglaMoedaDestino, conversorMoedas.getValorParaConversao(), conversorMoedas.getValorConvertido(), simboloMoedaOrigem.getDescricaoSimboloMoeda(), simboloMoedaDestino.getDescricaoSimboloMoeda() );
                        }
                        break;
                    case "15":
                        System.out.println("Exibindo Histórico de Conversão: \n");
                        GerarHistorico.exibirHistorico();
                        break;
                    case "16":
                        System.out.println("Finalizando o conversor de moedas!");
                        validOption = true;
                        break;
                    default:
                        System.out.println("Opção Inválida, por favor verifique a opção corretamente!.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static JsonObject parseJsonResponse(String urlString) throws IOException {
        // Criando a Url
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Lendo a resposta da API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Resposta do Json
        Gson gson = new Gson();
        return gson.fromJson(response.toString(), JsonObject.class);
    }
}
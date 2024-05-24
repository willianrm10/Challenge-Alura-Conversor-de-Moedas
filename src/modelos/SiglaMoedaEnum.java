package modelos;

public enum SiglaMoedaEnum {
    ARS("Peso Argentino"),
    BRL("Real brasileiro"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    JPY("Iene - Japão"),
    USD("Dólar Americano");

    private String descricaoMoeda;

    SiglaMoedaEnum(String descricaoMoeda){
        this.descricaoMoeda = descricaoMoeda;
    }

    public String getDescricaoMoeda(){
        return this.descricaoMoeda;
    }
}

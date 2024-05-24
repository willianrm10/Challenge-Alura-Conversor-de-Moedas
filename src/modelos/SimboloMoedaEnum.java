package modelos;

public enum SimboloMoedaEnum {
    ARS("$ "),
    BRL("R$ "),
    EUR("€ "),
    GBP("£ "),
    JPY("¥ "),
    USD("$ ");

    private String descricaoSimboloMoeda;

    SimboloMoedaEnum(String descricaoSimboloMoeda){
        this.descricaoSimboloMoeda = descricaoSimboloMoeda;
    }

    public String getDescricaoSimboloMoeda(){
        return this.descricaoSimboloMoeda;
    }
}

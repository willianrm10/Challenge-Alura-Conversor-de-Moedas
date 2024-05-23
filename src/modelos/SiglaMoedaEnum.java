package modelos;

public enum SiglaMoeda {
    BRL("Real brasileiro"),
    USD("Dólar Americano");

    private String descricao;

    SiglaMoeda(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}

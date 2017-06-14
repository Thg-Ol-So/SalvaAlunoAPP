package Modelo;

/**
 * Created by oliveira on 04/06/17.
 */

public class AtividadeObj {
    private String data;
    private String conteudo;
    private String tipo;
    private int    id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AtividadeObj(String tipo, String data, String conteudo){
        this.data       = data;
        this.conteudo   = conteudo;
        this.tipo       = tipo;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

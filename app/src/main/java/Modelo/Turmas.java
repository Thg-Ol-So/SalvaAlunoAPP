package Modelo;

/**
 * Created by oliveira on 11/06/17.
 */

public class Turmas {
    private String idTurma;
    private int    id;

    public Turmas(String turma){
        this.idTurma   = turma;
    }
    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

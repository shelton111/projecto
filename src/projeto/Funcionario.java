
package projeto;

public class Funcionario extends Pessoa {
private String estado_civil, categoria;
private int cell;


    public Funcionario(int id, String nome, String endereco, char genero, String estado_civil, int cell, String categoria) {
        super(id, nome, endereco, genero);
        this.estado_civil = estado_civil;
        this.cell = cell;
        this.categoria = categoria;
         
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }
    
    
}


package projeto;

import java.util.Vector;

public class Transporte {
     private int idtransporte;
     private Vector produto;
     private String  matricula, marca, tipo;
    

    public Transporte(int idtransporte,String marca ,String matricula, String tipo, Vector produto) {
        this.idtransporte = idtransporte;
        this.matricula = matricula;
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdtransporte() {
        return idtransporte;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return  idtransporte + "' " + matricula + "' " + marca + "' " + tipo ;
    }
    
    
}


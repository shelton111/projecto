package projeto;

import java.util.Vector;

public class TransporteProprio extends Transporte{
    private String nome;
    private int contacto;
    
    public TransporteProprio(int idtransporte, String marca, String matricula, String tipo, Vector produto, String nome, int contacto) {
        super(idtransporte, marca, matricula, tipo, produto);
        this.nome = nome;
        this.contacto = contacto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + nome + ";" + contacto + '}';
    }
    
}

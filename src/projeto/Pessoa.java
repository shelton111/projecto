
package projeto;

public class Pessoa {
    protected int id;
    protected String nome, endereco;
    protected char genero;

    public Pessoa(int id, String nome, String endereco, char genero) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.genero = genero;
    }

    public Pessoa() {
    }
    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public char getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return   id + " " + nome + " " + endereco + " " + genero ;
    }
    
    
}

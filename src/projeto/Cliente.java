
package projeto;

public class Cliente extends Pessoa {
    private String email;
    
    public Cliente(int id, String nome, String endereco, char genero, String email) {
        super(id, nome, endereco, genero);
        this.email = email;
    }
    public Cliente(){
        
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ email ;
    }
    
    
}

package projeto;

public class Electrodomestico extends Produto {
    private String capacidade , marca;
    
    public Electrodomestico(int codigo, String nome, String descricao, int stock, String marca, String capacidade, double preco) {
        super(codigo, nome,descricao, stock, marca, capacidade, preco);
        this.capacidade = capacidade;
         this.marca = marca; 
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
     @Override
    public String toString() {
        return super.toString();
    }

    
}

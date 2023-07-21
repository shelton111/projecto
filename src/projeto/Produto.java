
package projeto;

public class Produto {
    protected int codigo, stock, quant;
    protected String nome, descricao, marca, capacidade;
    protected double preco;

    public Produto(int codigo, String nome, String descricao, int stock, String marca, String capacidade, double preco) {
        this.codigo = codigo;
        this.stock = stock;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
        this.capacidade = capacidade;
    }

    public Produto() {
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

   
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
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
        return  codigo +" "+ nome +" "+descricao+" "+stock +" "+marca + " "+capacidade+" " + preco ;
    }
    
    
}

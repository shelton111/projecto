package projeto;

public class Mobiliario extends Produto {
    private String tamanho, material;
    public Mobiliario(int codigo, String nome,String descricao, int stock,String marca, String capacidade, double preco) {
        super(codigo, nome,descricao,stock,marca, capacidade, preco);
        this.tamanho = tamanho;
        this.material = material;
    }

    public Mobiliario() {
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    
}

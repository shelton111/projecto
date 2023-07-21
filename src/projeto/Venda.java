
package projeto;

import java.util.Date;


public class Venda {
    private Cliente cliente;
    private Carrinho_Compras cc ;;
    private Date data;

    public Venda(Cliente cliente, Carrinho_Compras cc, Date data) {
        this.cliente = cliente;
        this.cc = cc;
        this.data = data;
    }
    public Venda( Carrinho_Compras cc){
        this.cc = cc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho_Compras getCC() {
        return cc;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return  cliente.toString() + " "+ cc.toString() + " " + data;
    }
     public String toString2() {
        return  cliente.getId() + " "+ cc.getProduto().getCodigo();
    }
     public String toString3() {
        return  cc.toString();
    }
    
}

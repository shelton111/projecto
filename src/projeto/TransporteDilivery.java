package projeto;

import java.util.Vector;

public class TransporteDilivery extends Transporte{
    private Funcionario funcionario;
    private String destino;
    
    public TransporteDilivery(int idtransporte, String marca, String matricula, String tipo, Vector produto,Funcionario funcionario, String destino  ) {
        super(idtransporte, marca, matricula, tipo, produto);
        this.funcionario = funcionario;
        this.destino = destino;
                
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return super.toString() + "| funcionario:" + funcionario + "| destino: " + destino + '}';
    }
    
    
}

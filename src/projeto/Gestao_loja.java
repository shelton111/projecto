
package projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Gestao_loja {
  private Cliente cliente;
  private Produto pp;
  private Venda venda;
  private Carrinho_Compras cc ;
  private ValidarDados validar;
  private TransporteDilivery transported;
  private TransporteProprio transportep;
  private Ficheiro fch;
  private BufferedReader bf;
  private ArrayList<Produto> p;
  private Vector vc, vp;
  private int idp =1000, opcao=0; int quantidade = 0;
  
    public Gestao_loja() throws IOException {
       validar = new ValidarDados();
       fch = new Ficheiro();
       p = new  ArrayList();
       vc = new Vector();
       vp = new Vector();
     
    }
    
    public void cadastrarCliente()  throws IOException{ 
        System.out.println("\n==================NOVO REGISTO==================");
        int id = validar.validarCodigo();
        String nome = validar.validaString("\nNome do Clinte: ", 2, 30);
        String contacto = validar.validaString("Endereco do Clinte: ", 5, 20);
        char genero = validar.validaSexo("Sexo do Cliente (F/M): ");
        String email = validar.validarEmail("Email do Cliente: ", 11, 50);
        cliente = new Cliente(id, nome, contacto, genero, email);
        fch.escreverFicheiro("CLiente.txt", cliente.toString());
        System.out.println("Cliente cadastrado com sucesso\n"+ "O seu codigo de cliente e "+id+"\n");
        
        
    }
    
    
     public void AtualizarrCliente(int id)  throws IOException{ 
        System.out.println("\n==============================================");
        String nome = validar.validaString("\nNome do Clinte: ", 2, 30);
        String endereco = validar.validaString("Endereco do Clinte: ", 5, 20);
        char genero = validar.validaSexo("Sexo do Cliente (F/M): ");
        String email = validar.validarEmail("Email do Cliente: ", 11, 50);
        cliente = new Cliente(id, nome, endereco, genero, email);
        fch.AtualizarObject("Cliente.txt", id);
        fch.escreverFicheiro("CLiente.txt", cliente.toString());
        System.out.println(nome+"\n"+endereco+"\n"+genero+"\n"+email+"\n"); 
        System.out.println("Dados Atualizados com sucesso\n");
    }
    
  
    public boolean listarProduto() throws IOException{
        int ver = 0;
        boolean lista = false, resp=false; int cont =0;
        bf = new BufferedReader(new InputStreamReader(System.in));
        
        
   do{
        ver = validar.validaInt("\nO que deseja ver: \n"+"1. PRODUTOS ELECTRODOMESTICOS"
                    +"\n2. PRODUTOS MOBILIARIOS\n"+"3. TODOD PRODUTOS"+"\n4. VOLTAR"+"\nEscolha uma opcao: ", 1, 4);
    switch(ver){
     case 1:System.out.println("\nTVS");
        fch.pesquisar("Produto.txt", "Tv");
        System.out.println("\nGELEIRAS");
        fch.pesquisar("Produto.txt", "Geleira");
        System.out.println("\nCONGELADORES");
        fch.pesquisar("Produto.txt", "Congelador");
        System.out.println("\nFOGAO");
        fch.pesquisar("Produto.txt", "Fogao");
        System.out.println("\nMICOONDAS");
        fch.pesquisar("Produto.txt", "Microonda");
        System.out.println("\nARCAS");
        fch.pesquisar("Produto.txt", "Arcas");
        System.out.println("\nAR-CONDIONADO");
        fch.pesquisar("produto.txt", "Arcondicionado");
        System.out.println("");                    
            
        boolean des =validar.validaResposta("\ndeseja adicionar algum produto? (s/n): ","entrada invalida, tente novamente"); 
        if (des) {
        do{       
        int opcao = validar.validaInt("Digite o numero do produto que deseja: ", 16, 100);
        if (fch.Testar("Produto.txt", opcao)) {
        lista = true;
        quantidade = validar.validaInt("Digite a Quantidade: ", 1, 1000);
        pp = (fch.produto("Produto.txt", opcao));
        vp.add(pp);
        cc = new Carrinho_Compras(fch.produto("Produto.txt", opcao), quantidade);
        vc.add(cc);
        resp = validar.validaResposta("Deseja continuar?(s/n): ", "entrada invalida, tente novamente");
        System.out.println("");
        
       }else{
        System.out.println("Numero do produto invalido, tente novamente");
       }
        }while(resp!=false);}
            else{
            break;  
                }break;
     case 2:System.out.println("\nCAMAS");
        fch.pesquisar("Produto.txt", "Cama");
        System.out.println("\nMESAS");
        fch.pesquisar("Produto.txt", "mesa");
        System.out.println("\nSOFAS");
        fch.pesquisar("Produto.txt", "Sofa");
        System.out.println("\nGUARDA FATOS");
        fch.pesquisar("Produto.txt", "Guarda fato");
        System.out.println("\nCABECEIRA E ARMARIOS");
        fch.pesquisar("Produto.txt", "Cabeceira");
        fch.pesquisar("Produto.txt", "Armario");
        System.out.println("");
        boolean desj =validar.validaResposta("\ndeseja adicionar algum produto? (s/n): ","entrada invalida, tente novamente"); 
        if (desj) {
        do{       
        int opcao = validar.validaInt("Digite o numero do produto que deseja: ", 1, 100);
        if (fch.Testar("Produto.txt", opcao)) {
        lista = true;
        quantidade = validar.validaInt("Digite a Quantidade: ", 1, 1000);
        pp = (fch.produto("Produto.txt", opcao));
        vp.add(pp);
        cc = new Carrinho_Compras(fch.produto("Produto.txt", opcao), quantidade);
        vc.add(cc);
        resp = validar.validaResposta("Deseja continuar?(s/n): ", "entrada invalida, tente novamente\n");
        }else{
        System.out.println("Codigo do produto invalido, tente novamente");
        }
        }while(resp!=false);}
         else{
         break;  
        }break;
     case 3:System.out.println("\nHISENSE");
        fch.pesquisar("Produto.txt", "Hisense");
        System.out.println("\nDUFY");
        fch.pesquisar("Produto.txt", "Defy");
        System.out.println("\nSMART");
        fch.pesquisar("Produto.txt", "Smart");
        System.out.println("\nKIK");
        fch.pesquisar("Produto.txt", "Kik");
        System.out.println("");            
        System.out.println("\nCAMAS");
        fch.pesquisar("Produto.txt", "Cama");
        System.out.println("\nMESAS");
        fch.pesquisar("Produto.txt", "Mesa");
        System.out.println("\nSOFAS");
        fch.pesquisar("Produto.txt", "Sofa");
        System.out.println("\nGUARDA FATOS");
        fch.pesquisar("Produto.txt", "Guarda fato");
        System.out.println("\nCABECEIRA E ARMARIOS");
        fch.pesquisar("Produto.txt", "Cabeceira");
        fch.pesquisar("Produto.txt", "Armario");
        System.out.println("");              
        boolean desejo =validar.validaResposta("\nDeseja adicionar algum produto? (s/n): ","entrada invalida, tente novamente"); 
        if (desejo) {
        do{       
        int opcao = validar.validaInt("Digite o numero do produto que deseja: ", 1, 100);
        if (fch.Testar("Produto.txt", opcao)) {
        lista = true;
        System.out.println("");
        quantidade = validar.validaInt("Digite a Quantidade: ", 1, 1000);
        pp = (fch.produto("Produto.txt", opcao));
        vp.add(pp);
        cc = new Carrinho_Compras(fch.produto("Produto.txt", opcao), quantidade);
        vc.add(cc);
        resp = validar.validaResposta("Deseja continuar?(s/n): ", "entrada invalida, tente novamente");
        System.out.println("");
        }else{
        System.out.println("Numero do produto invalido, tente novamente");
        }
        }while(resp!=false);}
            else{
                 break;  
                }break;
                case 4: break;
            }
        }while(ver!=4);
 
         
      return lista;
    }
    
    public boolean removerProduto() throws IOException{
        int cod = 0; boolean rpp=false; Carrinho_Compras cc = null ;
        Produto pp = null;
        if (vc.isEmpty()) {
        System.out.println("\nNao ha produtos alocados no carrinho");
        }else{
        for (int i = 0; i < vc.size(); i++) {
        cc =(Carrinho_Compras)vc.elementAt(i);
        System.out.println("\n"+cc.toString());        
        }      
        do{
        cod = validar.validaInt("Digite o numero do produto:  ", 1, 1000);    
        for (int i = 0; i < vc.size(); i++) {
        cc =(Carrinho_Compras)vc.elementAt(i);
        pp =(Produto)vp.elementAt(i);
        if (cc.getProduto().getCodigo()== cod) {
        vc.remove(cc);
        System.out.println("Produtos removidos com sucesso!\n");}
        if (pp.getCodigo()== cod) {
        vp.remove(pp);}}
        rpp = validar.validaResposta("Deseja continuar?(s/n): ", "entrada invalida, tente novamente");    
        }while(rpp!=false);  
        }
      return true;
    }
    
    
    public void visualizarProduto() throws IOException{
       Carrinho_Compras cc ; 
       if (vc.isEmpty()) {
       System.out.println("Nenhum produto encontrado");
       }else{ 
       for (int i = 0; i < vc.size(); i++) { 
       cc =(Carrinho_Compras)vc.elementAt(i);
       System.out.println("\n/"+cc.toString());
       }
       System.out.println("=====================0000================0000=====/");
           System.out.println("");
       }
    }
    
    
    public void pesquisar()  throws IOException{ 
        int id = validar.validarCodigo(); boolean resp = false;
        Carrinho_Compras cc ; Produto pp; 
        String nome = validar.validaString("Nome do produto: ", 2, 30);
        if (fch.localizar("Produto.txt", nome)) {
        System.out.println("=======================================================");    
        fch.pesquisar("Produto.txt", nome); 
        System.out.println("=======================================================");
        resp = validar.validaResposta("Deseja adicionar o produto: (S/N) ", "entrada invalida, tente novamente");
        if (resp) {
        do{       
        int opcao = validar.validaInt("Digite o numero do produto que deseja: ", 1, 100);
        if (fch.Testar("Produto.txt", opcao)) {
        quantidade = validar.validaInt("Digite a Quantidade: ", 1, 1000);
        cc = new Carrinho_Compras(fch.produto("Produto.txt", opcao), quantidade);
        vc.add(cc);
        pp = fch.produto("Produto.txt", opcao);
        vp.add(pp);
        System.out.println("Produto adicionado com sucesso!");
        resp = validar.validaResposta("Deseja continuar?(s/n): ", "entrada invalida, tente novamente");
        System.out.println("");  
       }else{
        System.out.println("Numero do produto invalido, tente novamente");
       }
        }while(resp!=false);}
            else{      
        }
        }else{
            System.out.println(fch.localizar("Produto.txt", nome)+"  produto nao disponivel");
        }   
    }
    
    public void ComprarProduto(int idcliente) throws IOException{    
        double soma = 0, compra=0; Carrinho_Compras cc ; int op = 0;
        if (vc.isEmpty()) {
        System.out.println("!Nenhum produto encontrado!\n");
        }else{
        for (int i = 0; i < vc.size(); i++) {
        cc =(Carrinho_Compras)vc.elementAt(i);   
        soma = soma+(cc.getProduto().getPreco()*cc.getQuantidade());
        compra = soma;
        }
        System.out.println("\n<<A sua compra esta avaliado no preco de "+ compra+">>\n");
        op = validar.validaInt("Digite 1 para confirmar a compra\n"+"2.Cancelar\n"+"Escolha uma opcao: ", 1, 2);  
        if (op==1) {
        transporte(idcliente);
        }
        }
    }
    
     public void transporte(int idcliente) throws IOException{
        Carrinho_Compras cc ; Venda v1, v2, v3;
        if (vc.isEmpty()== false) {
        String endereco = ""; 
        int opp = validar.validaInt("escolha o metodo do transporte do produto: "+"\n1. Dilivery"+"\n2. Proprio\n", 1,2);
        if (opp ==1) {
        endereco = validar.validaString("Degite o endereco do destino: ", 2, 20);
        for (int i = 0; i < vc.size(); i++){ 
        cc =(Carrinho_Compras)vc.elementAt(i);    
        v1 = new Venda(fch.cliente("Cliente.txt",idcliente ), cc, Date.from(Instant.now()));
        v2 = new Venda(cc);
        //v3 = new Venda(fch.cliente("Cliente.txt",idcliente ).getId(), cc.getProduto().getCodigo());
        fch.escreverFicheiro("vendacliente.txt", v1.toString2());
        fch.escreverFicheiro("Vendas.txt", v1.toString());
        fch.escreverFicheiro("Vendaproduto.txt", v2.toString3());
        } System.out.println("COMPRA EFECTUADA COM SUCESSO\n");AtualizarProduto();}else{
        int idt = validar.validarCodigotransporte();
        String nome = validar.validaString("Degite o nome do transportador: ", 2, 20);
        int cell = validar.validaInt("Degite o contacto do transportador: ", 820000000, 879999999);
        String marca = validar.validaString("Degite a marca do veilculo: ", 2, 20);
        String matrc = validar.validaString("Degite a matricula do veiculo : ", 6, 20);
        transportep = new TransporteProprio(idt, marca, matrc, "proprio",vc ,nome, cell);
        for (int i = 0; i < vc.size(); i++){ 
        cc =(Carrinho_Compras)vc.elementAt(i);
        v2 = new Venda(fch.cliente("Cliente.txt",idcliente ), cc, Date.from(Instant.now()));
        v3 = new Venda(cc);
        fch.escreverFicheiro("vendacliente.txt", v2.toString2());
        fch.escreverFicheiro("Vendas.txt", v2.toString());
        fch.escreverFicheiro("Vendaproduto.txt", v3.toString3());
        fch.escreverFicheiro("TransportePessoal.txt", transportep.toString());
        }  System.out.println("COMPRA EFECTUADA COM SUCESSO\n");
        AtualizarProduto();}
        }else{
        System.out.println("Nao ha produtos na carrinha de compra\n");
        }
    }
     
     public void AtualizarProduto() throws IOException{
         int cod = 0, stock = 0;
         for (int i = 0; i < vp.size(); i++) {
         pp =(Produto)vp.elementAt(i);
         fch.AtualizarObject("Produto.txt", pp.getCodigo());
         cod = validar.validarProduto();
         stock = pp.getStock() - 1;
         pp.setCodigo(cod);
         pp.setStock(stock);
         fch.escreverFicheiro("Produto.txt", pp.toString());
         
         }
     }
     
     public void Perfil(int cod) throws IOException{
     int conta = 0;
          do{
         conta = validar.validaInt("\n1. ATUALIZAR CLIENTE\n"+
         "2. DADOS DO CLIENTE\n"+
         "3. MUDAR A SENHA\n"+"4. HISTORICO DE VENDAS\n"+"5. SAIR\n"+"Escolha uma opcao: ", 1, 5);
         switch(conta){
         case 1: AtualizarrCliente(cod); break;
         case 2: VisualizarCliente(cod); break;
         case 3: AtualizarCodigo(cod); break;
         case 4: Historico(cod); break;
         case 5: break;       
         }
         } while(conta!=5);}
     
     public void AtualizarCodigo(int cod) throws IOException{
        Cliente cc = new Cliente();
        cc = fch.cliente("Cliente.txt", cod);
        fch.AtualizarObject("Cliente.txt", cod);
        int id = validar.validaInt("degite seu codigo anteriao: ", 1000, 9999);
        int novoid = validar.validaInt("degite seu codigo novo codigo: ", 1000, 9999);
        cc.setId(novoid);
        fch.escreverFicheiro("CLiente.txt", cc.toString()); 
        System.out.println("Dados Atualizados com sucesso\n");
         }
     
      public void Historico(int cod) throws IOException{
          if (fch.Testar("vendacliente.txt", cod)) {
          System.out.println("\n=========================================");    
          fch.Historico(cod);
          System.out.println("===========================================\n");
          }else{
              System.out.println("Historico vazio!\n");
          }
         }
     
      public void RecuperarCodigo(String nome, String email) throws IOException{
        Cliente cc = new Cliente();  int cod=0;
        cod = fch.RecuperarCodigo("Cliente.txt", nome, email);
          if (cod !=0) {
              System.out.println("O seu codigo e "+cod+"\n");    
          }else{
              System.out.println("Nome ou email do Cliente invalido!\n");
          }
 
         }
      
      public void VisualizarCliente(int cod) throws IOException{
          Cliente cc = new Cliente();
          cc = fch.cliente("Cliente.txt", cod);
          System.out.println("\nDADOS DO CLIENTE"
                             +"\n----------------------\n"+
                             "NOME: "+cc.getNome()+
                             "\nGENERO: "+cc.getGenero()+
                             "\nENDERECO: "+cc.getEndereco()+
                             "\nEMAIL: "+cc.getEmail()+
                             "\n<<<<<cod: "+cc.getId()+">>>>>\n");
      }
    
    public static void main(String[] args) throws IOException {
        Gestao_loja gl = new Gestao_loja();
       // System.out.println(gl.produto.toString());
        gl.listarProduto();
    }
    
}

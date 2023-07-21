
package projeto;

import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
       ValidarDados v = new ValidarDados();
       Ficheiro fch = new Ficheiro();
        Gestao_loja gl = new Gestao_loja();
       int opcao =0, caso = 0, cod;
    
       do{ 
         System.out.println("BEM VINDO A NOSSA LOJA "); 
           opcao = v.validaInt("1. ENTRAR\n"+"2. CADASTRAR\n"+"3. RECUPERAR CODIGO\n"+"4. SAIR\n"+"Escolha uma opcao: ",  1, 4);
           switch(opcao){
               case 1:
                      cod = v.validaInt("Degite a Senha: ", 1000, 10000);
                      if (fch.Testar("Cliente.txt", cod)) {
                      System.out.println("\n==============BEM VINDO A NOSSA LOJA ONLINE===============");
                      
                      do{
                      System.out.print ('\u000C');
                      caso = v.validaInt("\n1. ATUALIZAR CLIENTE\n"+"2. VISUALIZAR E ADICIONAR PRODUTO NO CARRINHO DE COMPRA\n"+
                       "3. VISUALIZAR PRODUTOS NO CARRINHO DE COMPRA\n"+"4. REMOVER PRODUTO NO CARRINHO DE COMPRA\n"+
                       "5. EFECTUAR A COMPRA\n"+"6. PESQUISAR PRODUTO\n"+"7. MEU PERFIL\n"+"8. SA1R\n"+"Escolha uma opcao: ", 1, 8);
        
                      switch(caso){
                       case 1: gl.AtualizarrCliente(cod);break;
                       case 2: gl.listarProduto(); break;
                       case 3: gl.visualizarProduto(); break;
                       case 4: gl.removerProduto(); break;
                       case 5: gl.ComprarProduto(cod); break;
                       case 6: gl.pesquisar();break;
                       case 7: gl.Perfil(cod);
                       case 8: break;
                       }
                       }while(caso!=81
                              );
                       }else{
                          System.out.println("Codigo de Cliene invalidao\n");
                       }break;
               case 2: gl.cadastrarCliente();break;
               case 3:String nome = v.validaString("Degite o nome do Cliente: ", 2, 25);
                      String email = v.validaString("Degite o email do Cliente: ", 2, 25);
                      gl.RecuperarCodigo(nome, email);break;
               case 4: System.out.println("bay bay");break;
       }
       }while(opcao!=4);
    }

    private static void exec(String cls) {
    }
}


package projeto;

import java.io.*;
import javax.swing.JOptionPane;
public class ValidarDados {
    private Cliente cl = new Cliente();
    private Ficheiro f;
    private BufferedReader ler;
    private int codigo;
    
    public ValidarDados() {
        ler = new BufferedReader(new InputStreamReader(System.in));
         f = new Ficheiro();}
    
    public int validarCodigo(){
        do{
        codigo = (int) ((int)1000 + Math.random()*(9999-1000));
        }while(f.Testar("Cliente.txt", codigo));
        return codigo;
    }
    public int validarCodigotransporte(){
        do{
        codigo = (int) ((int)10 + Math.random()*(9999-1000));
        }while(f.Testar("Transporte.txt", codigo));
        return codigo;
    }
    public int validarProduto(){
        do{
        codigo = (int) ((int)1 + Math.random()*(100-36));
        }while(f.Testar("Produtos.txt", codigo));
        return codigo;
    }
    public static void main(String[] args) {
        ValidarDados v = new ValidarDados();
        
        int c= v.validarCodigo();
        //for (int i = 0; i < 15; i++) {
          //ap.ver();
        //System.out.println(ap);
    }
    
    public int validaInt(String msg, int min, int max) {
      int n = 0;
      do {
         try {
          System.out.print(msg);
          n = Integer.parseInt(ler.readLine());
          if (n < min || n > max) {
          System.out.println("[Erro] Digite novamente");}
          }catch (IOException ex) {
          System.out.print("[ERRO] Digite novamente");
          }catch (NumberFormatException ex) {
          System.out.println(ex.getMessage());}
        } while (n < min || n > max);
    return n;}

    
    public String validaString(String msg, int min, int max) {
        String txt = null;
        do {
         try {
          System.out.print(msg);
          txt = ler.readLine();
          if (txt.length() < min || txt.length() > max) {
          System.out.print("[Erro] Digite novamente");}
          }catch (IOException ex) {
          System.out.println("[Erro] Digite novamente");}
        } while (txt.length() < min || txt.length() > max);
    return txt;}

    
    public double validaDouble(String msg, double min, double max) {
        double n = 0;
        do {
         try {
          System.out.print(msg);                                                                                                                              n = Float.parseFloat(ler.readLine());
          if (n < min || n > max) {
          System.out.println("[Erro] Digite novamente");}
          }catch (NumberFormatException ex) {
          System.out.println(ex.getMessage());
          }catch (IOException ex) {
          System.out.println("[Erro] Digite novamente");}
        }while (n < min || n > max);
    return n;}
    
    public char validaSexo(String msg) throws IOException{
        char sex = 0;
String aux = "";
        do{
         try{
         System.out.print(msg);
         sex = (ler.readLine()).charAt(0);
         }catch (IOException ex) {
         System.out.println("[Erro] Digite novamente");}
         catch (StringIndexOutOfBoundsException in){
         System.out.println(in.getMessage()); }
         if(sex != 'f' && sex != 'F' && sex != 'm' && sex != 'M'){
         System.out.println("\nDADO INAVIDO!\nDIGITE NOVAMENTE");}
        } while (sex != 'f' && sex != 'F' && sex != 'm' && sex != 'M');
    return sex;}

     public boolean validaResposta(String msg, String erro) throws IOException{
        char resp = 0;
        boolean op;
        do{ try{
          System.out.print(msg);
          resp = (ler.readLine()).charAt(0);
          }catch (IOException ex) {
          System.out.println("[Erro] Digite novamente");}
          catch (StringIndexOutOfBoundsException in){
          System.out.println(in.getMessage()); }
          if(resp != 'S' && resp != 'N' && resp != 'n' && resp != 's'){
          System.out.println("\nDADO INAVIDO!\nDIGITE NOVAMENTE");}
        }while (resp != 'S' && resp != 'N' && resp != 'n' && resp != 's'); 
    op = (resp == 'S' || resp == 's');
    return op;}
    
     public String validarEmail(String mensagem, int min, int max) throws IOException{
	        String email=""; boolean d =false; int cont =0; String b ="" ; String mail = "@gmail.com";
                
	        do{
                System.out.println(mensagem);
	        try{
                email =ler.readLine();
                int a= email.length();
                int v = email.length() - 10;
                b = email.substring(v, a);
                }catch (StringIndexOutOfBoundsException in){
	        System.out.println(in.getMessage());
	        }
                if (b.equals(mail)){
                d =true;
	        if (email.length()<min || email.length()>max || d!=true || cont>=10)
	        System.out.println("Dado Invalido. Tentar novamente\n"+"email so aceita no formato: ****@gmail.com");}
                }while (email.length()<min ||email.length()>max || d != true || cont>=10);
	        return email;
        }
    
       

}

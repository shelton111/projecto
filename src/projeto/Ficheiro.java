package projeto;

import java.io.*; 
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Ficheiro {
  private Cliente cliente;
  private Produto pp = new Produto();  
  private Venda venda;
  private Vector vt = new Vector();
  private int cont =0;

 public void escreverFicheiro (String nF, String Fch) throws IOException {
 try { 
 FileWriter fw = new FileWriter(nF, true);
 
 PrintWriter pw = new PrintWriter(fw); 
 BufferedWriter fichOut = new BufferedWriter(fw);
 fichOut.write(Fch); 
 fichOut.newLine();  
 fichOut.close(); 
 } catch (IOException ex){ 
 System.out.println(ex.getMessage()); } 
 } 

public void lerDoFicheiro(String nf) throws IOException { 
StringTokenizer str; //uma porção de informacao a ser dividia por Str.Tokenizer
String linha="";
Produto pp = new Produto();
 try { 
 FileReader fr = new FileReader(nf); 
 BufferedReader fichIn = new BufferedReader(fr); 
 linha = fichIn.readLine();
 while (linha != null) { // enquanto não atingir o fim de ficheiro
  str = new StringTokenizer(linha," ");    
 int cod = Integer.parseInt(str.nextToken());
 String pnome = str.nextToken();
 String descricao = str.nextToken();
 int stock = Integer.parseInt(str.nextToken());
 String marca = str.nextToken();
 String capacidade = str.nextToken();
 double preco = Double.parseDouble(str.nextToken());
 pp = new Produto(cod,  pnome,descricao, stock,marca, capacidade, preco);    
System.out.println(pp.getCodigo()+"  "+pp.getNome()+"  "+pp.getMarca()
         +" "+pp.getDescricao()+" "+
         pp.getCapacidade()+"\nPRECO: "+pp.getPreco()+"0MTs\n");
 linha = fichIn.readLine();
 cont++;}
 fichIn.close(); 
 } catch (FileNotFoundException a) { 
 System.out.println("Ficheiro nao encontrado!"); 
 }catch (NumberFormatException nn){ 
 System.out.println(nn.getMessage()); 
 }catch (IOException b) { System.out.println(b); }} 

 public void gravarFichObj(String nfobj, String cc) {
 try {
 FileOutputStream ff = new FileOutputStream (nfobj);
 ObjectOutputStream ss = new ObjectOutputStream(ff);
 ss.writeObject(cc);
 ss.close();
 } catch (IOException xx) {
 System.out.println(xx.getMessage());
 }}
 
 public void lerrFichObj(String nfobj) throws ClassNotFoundException, IOException {
     Object a;
 try {
 FileInputStream ff = new FileInputStream (nfobj);
 ObjectInputStream ss = new ObjectInputStream(ff);
 a = ss.readObject();
 while (a != null) {
 System.out.println(a.toString());
 a = ss.readObject();
 }ss.close();
 } catch (IOException xx) {
 System.out.println(xx.getMessage());
 }}
 
public int pesquisar(String fic2, String nn) throws IOException{
String linha="", Fich=" " ; int cod = 0;
StringTokenizer str;
Produto pp= null;
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
 while (linha!=null){
 str = new StringTokenizer(linha," ");
 cod = Integer.parseInt(str.nextToken());
 String pnome = str.nextToken();
 String descricao = str.nextToken();
 int stock = Integer.parseInt(str.nextToken());
 String marca = str.nextToken();
 String capacidade = str.nextToken();
 double preco = Double.parseDouble(str.nextToken());
 String dd = pnome;
 String ee = marca.substring(0, 2);
 if(dd.equals(nn) || ee.equals(nn.substring(0, 2))){
 pp = new Produto(cod,  pnome,descricao, stock,marca, capacidade, preco);
 System.out.println(pp.getCodigo()+"  "+pp.getNome()+"  "+pp.getMarca()
         +" "+pp.getDescricao()+" "+
         pp.getCapacidade()+"\nPRECO: "+pp.getPreco()+"\n");
 }linha= br.readLine();}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage()+"0MTs\n");}
return cod;
}

public void LerVisualizar(String fic2, int nn) throws IOException{
String linha="";
StringTokenizer str;
//Produto pp = null;
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha," ");
 int cod = Integer.parseInt(str.nextToken());
 String pnome = str.nextToken();
 String descricao = str.nextToken();
 int stock = Integer.parseInt(str.nextToken());
 String marca = str.nextToken();
 String capacidade = str.nextToken();
 double preco = Double.parseDouble(str.nextToken());
 if(cod == nn){
 pp = new Produto(cod,  pnome,descricao, stock,marca, capacidade, preco); 
 System.out.println(pp.getCodigo()+"  "+pp.getNome()+"  "+pp.getMarca()
         +" "+pp.getDescricao()+" "+
         pp.getCapacidade()+"\nPRECO: "+pp.getPreco()+"0MTs\n");
 }linha= br.readLine();}
 br.close();  
 }catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
 catch(IOException i){System.out.println(i.getMessage()+"\n");}
 }

 public boolean Testar(String nfch, int nr){
 int b = 0, aux;
 StringTokenizer str;
 boolean status=false;
 String matrFich= " ";
 String umaLinha="";   		          
try{          	  
 BufferedReader br = new BufferedReader(new FileReader(nfch));
 umaLinha=br.readLine();
 while (umaLinha!=null){
 str = new StringTokenizer(umaLinha," ");
 b=Integer.parseInt(str.nextToken());
 if(b==nr) status=true;
 umaLinha= br.readLine();}
 br.close();  
 }catch (FileNotFoundException fnf) {
 System.out.println("Ficheiro nao encontrado");
 }catch(NumberFormatException n){System.out.println(n.getMessage());	
 }catch (IOException io){
    System.out.println(io.getMessage());// gravarFich(nomeFich,conteudo);
 }return status;}
 
 
 public boolean localizar(String nfch, String n){
 StringTokenizer str;
 boolean status=false;
 String nome= " ", marca=" ";
 String umaLinha="";
 int id = 0;
try{          	  
 BufferedReader br = new BufferedReader(new FileReader(nfch));
 umaLinha=br.readLine();
 while (umaLinha!=null){
 str = new StringTokenizer(umaLinha," ");
 id=Integer.parseInt(str.nextToken());
 nome=str.nextToken();
 String descricao =str.nextToken();
 int s=Integer.parseInt(str.nextToken());
 marca =str.nextToken();
 String capacidade = str.nextToken();
 double preco = Double.parseDouble(str.nextToken());
 String dd = nome.substring(0, 2);
  String ee = marca.substring(0, 2);
 if(dd.equals(n.substring(0, 2)) || ee.equals(n.substring(0, 2)))status=true;
 umaLinha= br.readLine();}
 br.close();  
}catch (FileNotFoundException fnf) {
    System.out.println("Ficheiro nao encontrado");
}catch (IOException io){
    System.out.println(io.getMessage());
}return status;}
 
 
public double valor(String fic2, int nn) throws IOException{
String linha=""; int cod= 0 ;
StringTokenizer str;
double preco = 0, p=0;
Produto pt = null;
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha," ");
 cod = Integer.parseInt(str.nextToken());
 String pnome = str.nextToken();
 String descricao = str.nextToken();
 int stock = Integer.parseInt(str.nextToken());
 String marca = str.nextToken();
 String capacidade = str.nextToken();
 preco = Double.parseDouble(str.nextToken());
 pt = new Produto(cod, pnome, descricao, stock, marca, capacidade, preco);
 if(cod == nn)
  p = p + preco; 
 linha= br.readLine();
}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
      return p;
}


public Produto produto(String fic2, int nn) throws IOException{
String linha=""; int cod= 0 ;
StringTokenizer str;
double preco = 0, p=0;
Produto pt = null;
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha," ");
 cod = Integer.parseInt(str.nextToken());
 String pnome = str.nextToken();
 String descricao = str.nextToken();
 int stock = Integer.parseInt(str.nextToken());
 String marca = str.nextToken();
 String capacidade = str.nextToken();
 preco = Double.parseDouble(str.nextToken());
 if(cod == nn)
 pt = new Produto(cod,  pnome,descricao, stock,marca, capacidade, preco); 
 linha= br.readLine();
}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
      return pt;
}

public Cliente cliente(String fic2, int nn) throws IOException{
String linha=""; int cod= 0 ;
StringTokenizer str;
double preco = 0, p=0;
Cliente ct = null;
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha," ");
 cod = Integer.parseInt(str.nextToken());
 String cnome = str.nextToken();
 String endereco = str.nextToken(); //extrai nome de artigo*/
 char sexo = str.nextToken().charAt(0);
 String email = str.nextToken();
 
 if(cod == nn)
 ct = new Cliente(cod,cnome,endereco,sexo,email); 
 linha= br.readLine();
}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
      return ct;
}

public void AtualizarObject(String nf, int nr) throws IOException { 
StringTokenizer str;
String linha="";
int cod = 0;
ArrayList<String> salvar = new ArrayList();

 try { 
 FileReader fr = new FileReader(nf); 
 BufferedReader br = new BufferedReader(fr); 
 linha = br.readLine();
 while (linha != null) {
 str = new StringTokenizer(linha," ");
 cod = Integer.parseInt(str.nextToken());
     if (cod != nr) 
     salvar.add(linha);
     linha = br.readLine();
     }br.close();
     fr.close();
  FileWriter fw = new FileWriter(nf);
  BufferedWriter bff = new BufferedWriter(fw);
  bff.write("");
  bff.close();
  fw.close();
  
  FileWriter fw2 = new FileWriter(nf, true); 
  BufferedWriter bfw = new BufferedWriter(fw2);
  
     for (int i = 0; i < salvar.size(); i++) {
         bfw.write(salvar.get(i));
         bfw.newLine();
     }bfw.close();
 }catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
  catch(IOException i){System.out.println(i.getMessage());}
 }

public int RecuperarCodigo(String fic, String nm, String em) throws IOException{
String linha="", nome=" " ; int cod = 0;
StringTokenizer str;	  
try{
 BufferedReader br = new BufferedReader(new FileReader(fic));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha," ");
 int id = Integer.parseInt(str.nextToken());
 nome=str.nextToken();
  String endereco = str.nextToken();
 char sexo = str.nextToken().charAt(0);
 String email = str.nextToken();
 String dd = nome.substring(0, 2);
 if(nome.equals(nm) && email.equals(em))
 cod = id;
 //System.out.println(linha);
 linha= br.readLine();}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
return cod;
}

public void Historico(int id) throws IOException{
String linha=""; int idc = 0, idp = 0, cont = 0;
StringTokenizer str; 
Produto pp = null;
try{
 BufferedReader br = new BufferedReader(new FileReader("vendacliente.txt"));
 linha=br.readLine();
 while (linha!=null){
 str = new StringTokenizer(linha," ");
 idc = Integer.parseInt(str.nextToken());
 idp = Integer.parseInt(str.nextToken());
 if(idc == id)
 LerVisualizar("vendaproduto.txt", idp);
 cont++;
 linha= br.readLine();}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
//return pp;
}

    public static void main(String[] args) throws IOException {
        Ficheiro f = new Ficheiro();
        /*Produtos pt = new Produtos();
        Cliente c = new Cliente();
        pt = f.produto("Produtos.txt", 110);
         double a =0;
         
         a = f.valor("Produtos.txt", 110);
         f.pesquisar("Produtos.txt", "Mesa");
        c = f.cliente("Cliente.txt", 5747);
         
        if (a==0) {
            System.out.println("erro");
            
        }else{
            System.out.println("certo");
        }
        System.out.println(a+ " "+ f.Testar("Electrodomestico.txt", 110));
        System.out.println(pt.toString());
        System.out.println(c);
          */
       
        f.Historico(1111);
       ///f.LerVisualizarInt("vendaproduto.txt", 1111);
       //f.lerDoFicheiro("Produto.txt");
       // f.AtualizarObject("Produto.txt", 2);
   //int a = f.RecuperarCodigo("Cliente.txt", "Mael", "mael@gmail.com");
        //System.out.println(a);
        //int b =f.RecuperarCodigo("Cliente.txt", "Mael", "mael@gmail.com" );System.out.println(b);
        //f.gravarFichObj("clientes.txt", cc.toString());
       // f.lerDoFicheiro("Produto.txt");
    }
} 
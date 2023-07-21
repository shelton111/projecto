
package projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class teste {
    
    public static void main(String[] args) throws IOException {
        Scanner ss = new Scanner(System.in);
        BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("ola mundo");
        System.out.print("\033[2j");
        System.out.flush();
        System.out.println("qualquer coisa");
        String c = b.readLine();
        System.out.println(c);
        
    }
    
}

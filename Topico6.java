/** Crie uma aplicação onde ao executar, crie um estrutura de diretorios como abaixo.
 *  Crie também um método que exclua a Pasta 'AulaPOOII'.
AulaPOOII
      - - - Programacao
                    - - - Java
                               - - - 2015
      - - - OrientacaoObjeto
                   - - - Turma
                               - - - Montenegro
 */
package br.unisc.main;
//Importações
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ChristianRamos
 */
public class Topico6 {
    static String DRIVE="";
    
    //Criar Pasta   
    public void criarPasta(String nomePasta){
        new File(DRIVE + nomePasta).mkdir();
    }
    //Existe Pasta
    public boolean existePasta(String caminho, String nomePasta){
        return new File(DRIVE + caminho + nomePasta).exists();
    }
    
    //Principal
    public static void main(String[] args) {
        boolean result=false;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o drive a ser utilizado: ");
        DRIVE = entrada.nextLine().toUpperCase();
        System.out.println(DRIVE);
        Topico6 pasta = new Topico6();
        try{
            result = pasta.existePasta(":\\", "POOII");
            if(result == false){
                System.out.println("Criando pasta POOII...");
                pasta.criarPasta(":\\POOII");
                System.out.println("Pasta criada...");
            } else{
                System.out.println("A pasta POOII já existe.");
                }
        }catch(Exception e){
            System.out.println("Ocorreu um erro. A pasta não foi criada.");
        }
    }
}

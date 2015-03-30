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
        DRIVE = entrada.nextLine().toUpperCase()+":";
        Topico6 pasta = new Topico6();
        try{
            result = pasta.existePasta("\\", "POOII");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta POOII...");
                pasta.criarPasta("\\POOII");
                result = pasta.existePasta("\\", "POOII");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta POOII já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\", "Programacao");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta Programacao...");
                pasta.criarPasta("\\POOII\\Programacao");
                result = pasta.existePasta("\\", "POOII\\Programacao");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta Programacao já existe.");
                }
            //================================================================
                        result = pasta.existePasta("\\POOII\\", "OrientacaoObjeto");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta OrientacaoObjeto...");
                pasta.criarPasta("\\POOII\\OrientacaoObjeto");
                result = pasta.existePasta("\\", "POOII\\OrientacaoObjeto");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta OrientacaoObjeto já existe.");
                }
            
        }catch(Exception e){
            System.out.println("Ocorreu um erro. A pasta não foi criada.");
        }
        
    }
}
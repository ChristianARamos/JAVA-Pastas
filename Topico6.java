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
    
    //CRIAR PASTA  
    public void criarPasta(String nomePasta){
        new File(DRIVE + nomePasta).mkdir();
    }
    //EXITE PASTA
    public boolean existePasta(String caminho, String nomePasta){
        return new File(DRIVE + caminho + nomePasta).exists();
    }
    //DELETA PASTA
    public boolean deletarPasta(String caminho, String nomePasta){
        return new File(DRIVE + caminho + nomePasta).delete();
    }
    //DELETA ARVORE
    public void deletarArvore(File arvore){
        if(!arvore.isDirectory()){
            arvore.delete();
        }else{
           File files[] = arvore.listFiles();    
           for (File sub: files) {    
                deletarArvore(sub);
           }
           arvore.delete();
        }
    }
    public void listarPasta(String nomePasta){
        File dir = new File(DRIVE+"\\"+nomePasta);
        File[] conteudo = dir.listFiles();
        for(File pasta : conteudo){
            if(pasta.isDirectory()){
                System.out.println("DIR:"+nomePasta+"\\"+pasta.getName());
                listarPasta(nomePasta+"\\"+pasta.getName());
            }
        }
    }
    
    // <<------- MAIN ------->>
    public static void main(String[] args) {
        boolean result;
        String quest;
        Scanner entrada = new Scanner(System.in);
        Scanner qdelete = new Scanner(System.in);
        System.out.println("Por favor, informe o drive a ser utilizado: ");
        DRIVE = entrada.nextLine().toUpperCase() + ":";
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
                result = pasta.existePasta("\\POOII\\", "Programacao");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta Programacao já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\Programacao\\", "JAVA");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta JAVA...");
                pasta.criarPasta("\\POOII\\Programacao\\JAVA");
                result = pasta.existePasta("\\POOII\\Programacao\\", "JAVA");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta JAVA já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\Programacao\\JAVA\\", "2015");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta 2015...");
                pasta.criarPasta("\\POOII\\Programacao\\JAVA\\2015");
                result = pasta.existePasta("\\POOII\\Programacao\\JAVA\\", "2015");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta 2015 já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\", "OrientacaoObjeto");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta OrientacaoObjeto...");
                pasta.criarPasta("\\POOII\\OrientacaoObjeto");
                result = pasta.existePasta("\\POOII\\", "OrientacaoObjeto");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta OrientacaoObjeto já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\OrientacaoObjeto\\", "Turma");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta Turma...");
                pasta.criarPasta("\\POOII\\OrientacaoObjeto\\Turma");
                result = pasta.existePasta("\\POOII\\OrientacaoObjeto\\", "Turma");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta Turma já existe.");
                }
            //================================================================
            result = pasta.existePasta("\\POOII\\OrientacaoObjeto\\Turma\\", "Montenegro");
            if(result == false){
                System.out.println("A Pasta não existe. Criando pasta Montenegro...");
                pasta.criarPasta("\\POOII\\OrientacaoObjeto\\Turma\\Montenegro");
                result = pasta.existePasta("\\POOII\\OrientacaoObjeto\\Turma\\", "Montenegro");
                    if (result == true){
                        System.out.println("Pasta criada...");
                    } else{System.out.println("A Pasta não foi criada.");                        }
            } else{
                System.out.println("A pasta Montenegro já existe.");
                }
        }catch(Exception e){
            System.out.println("Ocorreu um erro. A pasta não foi criada.");
        }
        
        try{
            pasta.listarPasta("POOII");
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro. A lista não pode ser criada.");
        }
        
        System.out.println("Deseja executar o deletarArvore? S/N");
        quest = qdelete.nextLine().toUpperCase();
        if(quest.equalsIgnoreCase("S")){
            try{
                File pastas = new File(DRIVE+"\\POOII");
                pasta.deletarArvore(pastas);
                System.out.println("Pastas deletadas.");
            }catch(Exception e){
                System.out.println("Ocorreu um erro. Não foi possível deletar a pasta.");
            }
        }        
    }
}
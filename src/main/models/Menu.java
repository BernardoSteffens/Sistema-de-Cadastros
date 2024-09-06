package main.models;

import main.util.Arquivos;
import main.util.uteis;
import java.io.File;
import java.util.Scanner;

public class Menu {

    int opcao;
    static File file = new File("src/resources/formulario.txt");

    public static boolean printMenu(){

        System.out.println(Arquivos.lerArquivo(file));
        return logicaMenu();
    }

     private static boolean logicaMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                Usuario usuario = new Usuario();
                return true;
            case 2:
                Usuario.lerCadastros(1);
                return true;
            case 3:
                Pergunta.cadastrarPergunta();
                return true;
            case 4:
                Pergunta.deletarPergunta();
                return true;
            case 5:
                Usuario.pesquisarUsuario();
                return true;
            case 6:
                return false;
            default:
                System.out.println("\nOpção invalida\n");
                uteis.limparTela();
                return true;
        }
    }
}

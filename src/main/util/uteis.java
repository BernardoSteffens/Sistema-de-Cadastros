package main.util;

import java.io.File;

public class uteis {

    public static void limparTela(){

        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void verificarPasta(File pasta){
        if(!pasta.isDirectory()){
            System.out.println("O caminho especificado não é um diretório.");
            System.exit(1);
            //TODO adicionar excecao
        }
    }
}


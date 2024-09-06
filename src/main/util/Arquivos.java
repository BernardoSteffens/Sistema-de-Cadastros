package main.util;

import java.io.*;

public class Arquivos {

    public static String lerArquivo(File file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String texto = "";
            while(br.ready()){
                texto += (br.readLine() + "\n") ;
            }
            return texto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String lerPrimeiraLinhaArquivo(File file){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static String lerPrimeiraLinhaTodosArquivos(File pasta) {
        File[] files = pasta.listFiles();
        String texto = "";

        for (File file : files) {
            texto += lerPrimeiraLinhaArquivo(file) + "\n";
        }
        return texto;
    }

    public static String[] lerTodosArquivos(File pasta){
        //Verifica se é um diretorio valido
        if(!pasta.isDirectory()){
            System.out.println("O caminho especificado não é um diretório.");
            System.exit(1);
            //TODO adicionar excecao
        }
        int j = 0;

        File[] files = pasta.listFiles();
        String[] texto = new String[files.length];

        for(File file : files) {
            texto[j] = lerArquivo(file);
            j++;
        }

        return texto;
    }


    public static void escreveArquivo(File file, String texto){
        try(FileWriter fw = new FileWriter(file)){
            fw.write(texto);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

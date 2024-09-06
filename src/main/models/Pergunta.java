package main.models;

import main.util.Arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.lines;

public class Pergunta {

    static File file = new File("src/resources/perguntas.txt");
    static String texto = Arquivos.lerArquivo(file);

    public static void printPerguntas(){
        System.out.println(texto);
    }

    static void cadastrarPergunta(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a pergunta que deseja adicionar:");
        String novaPergunta = scanner.nextLine();
        String perguntaFormatada = formataPergunta(novaPergunta);
        texto = texto + perguntaFormatada;

        Arquivos.escreveArquivo(file, texto);
        System.out.println("Pergunta adicionada");
    }

    static void deletarPergunta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da pergunta q deseja excluir:");
        String numeroPergunta = scanner.next();

        if(Integer.valueOf(numeroPergunta) >= 5){
            List<String> linhas = texto.lines().toList();
            List<String> linhasCertas = linhas.stream().filter(l -> !(l.contains(numeroPergunta))).toList();
            String texto = "";

            for (int j = 0; j < linhasCertas.size(); j++) {
                texto = texto + linhasCertas.get(j) + "\n";
            }

            Arquivos.escreveArquivo(file, texto);
            System.out.println("Pegunta deletada");
        } else {
            System.out.println("Impossivel apagar as 4 primeiras");
        }
    }

    static String formataPergunta(String pergunta){
        int numero = numeroCadastro() + 1;
        String numeroPergunta = String.valueOf(numero);
        pergunta = "\n" + numeroPergunta + " - " + pergunta;
        return pergunta;
    }

    static int numeroCadastro(){
        List<String> linhas = texto.lines().toList();
        int indexUltimaLinha = linhas.size() - 1;
        String ultimaLinha = linhas.get(indexUltimaLinha);
        String[] partes = ultimaLinha.split(" -");
        return Integer.valueOf(partes[0]);
    }
}

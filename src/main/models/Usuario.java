package main.models;

import main.util.Arquivos;
import main.util.uteis;

import java.io.*;
import java.util.Scanner;

public class Usuario {

    String nome, email, idade, altura;
    static int i ;
    static File pasta = new File("D:\\Programação\\desafios\\sistemaDeCadastros\\src\\resources\\usuarios\\");

    public Usuario() {
        cadastrarUsuario();
        printDados();
    }

    private void cadastrarUsuario(){
        lerCadastros(2);

        System.out.println("\nPara cadastrar um novo usuario responda:");
        Pergunta.printPerguntas();
        lerDados();
        String nomeArquivo = pasta.toString() + (i+1) + "-" + nome.toUpperCase().replace(" ", "" ) + ".txt";
        String conteudoArquivo = nome +"\n"+ email +"\n"+ idade +"\n"+ altura;
        i++;

        try (FileWriter fw = new FileWriter(nomeArquivo);){
            fw.write(conteudoArquivo);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lerCadastros(int opcao){
        uteis.verificarPasta(pasta);
        File[] files = pasta.listFiles();

        switch (opcao){
            case 1:
                System.out.println(Arquivos.lerPrimeiraLinhaTodosArquivos(pasta) + "\n");
                break;
            case 2:
                numeroCadastro();
                break;
        }

        for(File file : files){
            if (file.isFile() && file.getName().endsWith(".txt")){

            } else{
                //TODO adicionar excecao
            }
        }
    }

    private static void numeroCadastro(){
        File[] files = pasta.listFiles();
        i = 0;
        for(File file : files){
            String nome = file.getName();
            String[] partes = nome.split("-");
            int numero = Integer.valueOf(partes[0]);
            i = Math.max(i, numero);
        }
    }

    public static void pesquisarUsuario(){
        Scanner scanner =new Scanner(System.in);

        System.out.println("Digite sua pesquisa:");
        String pesquisa = scanner.nextLine();

        String textos[] = Arquivos.lerTodosArquivos(pasta);


        for (int i = 0; i < textos.length; i++){

            if(textos[i].contains(pesquisa)){
                System.out.println("\n" + textos[i]);
                break;
            }
        }
        System.out.println("\n");
    }



    private void lerDados(){
        Scanner scanner = new Scanner(System.in);
        setNome(scanner.nextLine());
        setEmail(scanner.nextLine());
        setIdade(scanner.nextLine());
        setAltura(scanner.nextLine());

    }

    private void printDados(){
        System.out.println(nome + " " + email + " " + idade + " " + altura);
    }

    //SETTERS
    //TODO retornar execeções
    public void setNome(String nome) {
        if (nome.length() >= 10) {
            this.nome = nome;
        } else {
            System.out.println("Nome invalido");
        }
    }

    public void setEmail(String email) {
        if(email.contains("@")){
            this.email = email;
        } else{
            System.out.println("Email invalido");
        }
    }

    public void setIdade(String idade) {
        if (Integer.valueOf(idade) >= 18) {
            this.idade = idade;
        } else {
            System.out.println("É necessario ter mais de 18 anos");
        }
    }

    public void setAltura(String altura) {
        if (altura.contains(",")){
            this.altura = altura;
        } else{
            System.out.println("Deve conter ,");
        }
    }
}

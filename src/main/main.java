package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.models.Menu;
import main.models.Pergunta;
import main.models.Usuario;

public class main {

    public static void main(String[] args) {
        while(Menu.printMenu());
    }
}

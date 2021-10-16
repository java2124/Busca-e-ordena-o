package BuscaDeClientes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoClientes {

    public ArrayList<Cliente> dadosClientes (){
        ArrayList <Cliente> clientes = new ArrayList<>();
        String[] partes = null;
        try {
            File file = new File("arquivoDados.csv");
            Scanner scanner = new Scanner(file);

            // enquanto não chegar ao final do arquivo
            while (scanner.hasNextLine()) {
                // leia a próxima linha do arquivo
                String linha = scanner.nextLine();

                // quebrando a linha por ","
                partes = linha.split(",");
                
                Cliente novo = new Cliente(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);

                clientes.add(novo);
            }

            scanner.close();

            return clientes;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}

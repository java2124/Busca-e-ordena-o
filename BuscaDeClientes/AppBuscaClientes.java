/* INTEGRANTES:
    Rafaela Bomfim de Jesus RA.21249344
    Arthur Souza Silva RA.21265782
*/

package BuscaDeClientes;

import java.util.ArrayList;
import java.util.Scanner;

public class AppBuscaClientes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeCliente = "";
        int i = 0;
        ArrayList <Cliente> clientes = new ArrayList<>();
        ArquivoClientes dados = new ArquivoClientes();
        buscaCliente cliente = new buscaCliente();

        clientes = dados.dadosClientes();

        System.out.println("Olá! Seja Bem-Vindo(a) ao sistema de clientes da empresa Anhembi Morumbi!");

        do{
            System.out.println();    
            System.out.println("Digite o nome do cliente que deseja procurar (Se quiser sair do sistema é digitar 'exit')");
            nomeCliente = scanner.nextLine();

            if(nomeCliente.equals("exit")){
                i = 1;
            } else {
                String [] resultado = cliente.pesquisarCliente(clientes, nomeCliente);
    
                System.out.println(resultado[0]);
                System.out.println(resultado[1]);
            }
        } while(i==0);    

        scanner.close();
    }
}

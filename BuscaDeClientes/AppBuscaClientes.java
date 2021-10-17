/* INTEGRANTES:
    Rafaela Bomfim de Jesus RA.21249344
    Arthur Souza Silva RA.21265782
*/

package BuscaDeClientes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AppBuscaClientes {

    public static void main(String[] args) {
        String nomeCliente = "";
        int i = 0;
        ArrayList <Cliente> clientes = new ArrayList<>();
        ArquivoClientes dados = new ArquivoClientes();
        buscaCliente cliente = new buscaCliente();

        clientes = dados.dadosClientes();
        clientes = cliente.ordenacaoLista(clientes);

        JOptionPane.showMessageDialog(null, "Olá! Seja Bem-Vindo(a) ao sistema de clientes da empresa Anhembi Morumbi!");

        do{   
            nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente que deseja procurar (Se quiser sair do sistema basta digitar 'exit')");

            if(nomeCliente.equals("exit")){
                i = 1;
            } else {
                String [] resultado = cliente.pesquisarCliente(clientes, nomeCliente);
    
                if(resultado[2] != null){
                    JOptionPane.showMessageDialog(null, "Nome: " + resultado[2] + "\n" + "Sexo: " + resultado[3] + "\n" + "Endereço: " + resultado[4] + "\n" + "Estado: " + resultado[5] + "\n" + "Email: " + resultado[6] + "\n" + "Telefone: " + resultado[7] + "\n" + "Idade: " + resultado[8] + "\n" + "\n" + resultado[1]);
                } else {
                    JOptionPane.showMessageDialog(null, resultado[0] + "\n" + "\n" + resultado[1]);
                }
            }
        } while(i==0);   
    }
}

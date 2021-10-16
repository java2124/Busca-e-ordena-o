/* INTEGRANTES:
    Rafaela Bomfim de Jesus RA.21249344
    Arthur Souza Silva RA.21265782
*/

package BuscaDeClientes;

import java.util.ArrayList;

public class AppBuscaClientes {
    public static void main(String[] args) {

        ArrayList <Cliente> clientes = new ArrayList<>();
        ArquivoClientes dados = new ArquivoClientes();

        clientes = dados.dadosClientes();

       System.out.println(clientes.get(5823).getNome());
    }
}

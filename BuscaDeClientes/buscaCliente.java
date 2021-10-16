package BuscaDeClientes;

import java.util.ArrayList;

public class buscaCliente {
    public int totalComparacoes = 0;

    public String[] pesquisarCliente(ArrayList <Cliente> clientes, String chave) {
        int inicio, fim, meio;
        String [] retorno = new String[8];
        inicio = 0;
        fim = clientes.size() - 1;
        totalComparacoes = 0;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            totalComparacoes++;
            if (chave.equals(clientes.get(meio).getNome())) { 
                retorno[0] = "Cliente ecnontrado!";
                retorno[1] = "Total de Comparações: " + totalComparacoes;
                retorno[2] = clientes.get(meio).getNome();
                retorno[3] = clientes.get(meio).getSexo();
                retorno[4] = clientes.get(meio).getEndereco();
                retorno[5] = clientes.get(meio).getEstado();
                retorno[6] = clientes.get(meio).getEmail();
                retorno[7] = clientes.get(meio).getTelefone();
                return retorno;
            }
            totalComparacoes++;
            int comp = chave.compareTo(clientes.get(meio).getNome());
            if (comp < 0) { 
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        retorno[0] = "Cliente não encontrado!";
        retorno[1] = "Total de Comparações: " + totalComparacoes;
        return retorno; 
    }    
}

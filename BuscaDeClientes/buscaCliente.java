package BuscaDeClientes;

import java.util.ArrayList;
import java.text.Normalizer;

public class buscaCliente {
    public int totalComparacoes = 0;

    public ArrayList<Cliente> ordenacaoLista(ArrayList <Cliente> clientes) {
        int iteracao, i;
        boolean trocou = true;

        for (iteracao = 0; (iteracao < clientes.size() - 1) && trocou; iteracao++) {
            trocou = false;
            for (i = 0; i < clientes.size() - 1 - iteracao; i++) {
                String chave = Normalizer.normalize(clientes.get(i).getNome(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                String nome = Normalizer.normalize(clientes.get(i+1).getNome(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                int comp = chave.compareTo(nome);

                if (comp > 0) {
                    Cliente aux = new Cliente(clientes.get(i).getNome(), clientes.get(i).getSexo(), clientes.get(i).getEndereco(), clientes.get(i).getEstado(), clientes.get(i).getEmail(), clientes.get(i).getTelefone(), clientes.get(i).getIdade());
                    
                    clientes.get(i).setNome(clientes.get(i + 1).getNome());
                    clientes.get(i).setSexo(clientes.get(i + 1).getSexo());
                    clientes.get(i).setEndereco(clientes.get(i + 1).getEndereco());
                    clientes.get(i).setEstado(clientes.get(i + 1).getEstado());
                    clientes.get(i).setEmail(clientes.get(i + 1).getEmail());
                    clientes.get(i).setTelefone(clientes.get(i + 1).getTelefone());
                    clientes.get(i).setIdade(clientes.get(i + 1).getIdade());

                    clientes.get(i + 1).setNome(aux.getNome());
                    clientes.get(i + 1).setSexo(aux.getSexo());
                    clientes.get(i + 1).setEndereco(aux.getEndereco());
                    clientes.get(i + 1).setEstado(aux.getEstado());
                    clientes.get(i + 1).setEmail(aux.getEmail());
                    clientes.get(i + 1).setTelefone(aux.getTelefone());
                    clientes.get(i + 1).setIdade(aux.getIdade());
                    trocou = true;
                }
            }
        }

        return clientes;
    }


    public String[] pesquisarCliente(ArrayList <Cliente> clientes, String chave) {
        int inicio, fim, meio;
        String [] retorno = new String[9];
        inicio = 0;
        fim = clientes.size() - 1;
        totalComparacoes = 0;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            String chave2 = Normalizer.normalize(chave, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            String nome = Normalizer.normalize(clientes.get(meio).getNome(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            totalComparacoes++;
            if (chave2.equals(nome)) { 
                retorno[0] = "Cliente encontrado!";
                retorno[1] = "Total de Comparações: " + totalComparacoes;
                retorno[2] = clientes.get(meio).getNome();
                retorno[3] = clientes.get(meio).getSexo();
                retorno[4] = clientes.get(meio).getEndereco();
                retorno[5] = clientes.get(meio).getEstado();
                retorno[6] = clientes.get(meio).getEmail();
                retorno[7] = clientes.get(meio).getTelefone();
                retorno[8] = clientes.get(meio).getIdade();
                return retorno;
            }
            int comp = chave2.compareTo(nome);

            totalComparacoes++;
            if (comp < 0) { 
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        retorno[0] = "Nome não existe!";
        retorno[1] = "Total de Comparações: " + totalComparacoes;
        return retorno; 
    }    
}

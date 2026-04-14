import java.util.ArrayList;
import java.util.Iterator;

public class ListagemClientes{
    public static void main(String[] args) {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Lia");
        c1.setEmail("lia@gmail.com");
        c1.setCpf("000.000.000-01");
        c1.setFone("0988889121");
        lista.add(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Thayla");
        c2.setEmail("thayla@gmail.com");
        c2.setCpf("000.000.000-02");
        c2.setFone("890978712344");
        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Laryssa");
        c3.setEmail("lary@gmail.com");
        c3.setCpf("000.000.000-03");
        c3.setFone("685788970908");
        lista.add(c3);

        System.out.println("Percorrendo com 'iterator'");
        Iterator<Cliente> itCliente = lista.iterator();
        while(itCliente.hasNext()){
            Cliente c = itCliente.next();

            System.out.println("Nome: " + c.getNome() + " | "  + "CPF: " + c.getCpf());
        }

        System.out.println("");
        //remover item da lista com 'interator'
        Cliente clienteRemover = new Cliente();
        clienteRemover.setCpf("000.000.000-03");
        Iterator<Cliente> itRemover = lista.iterator();
        while(itRemover.hasNext()){
            if(itRemover.next().getCpf().equals(clienteRemover.getCpf())){
                System.out.println("Removendo o cliente de CPF " + clienteRemover.getCpf());
                itRemover.remove();
            }
        }
        
        System.out.println("");
        System.out.println("Percorrendo com 'foreach'");
        for(Cliente c : lista){
            System.out.println("Nome: " + c.getNome() + " | " + "CPF: " + c.getCpf());
        }
        System.out.println("");
        
        // //removendo com foreach -----> com erro. Verificar depois
        // clienteRemover = new Cliente();
        // clienteRemover.setCpf("000.000.000-02");
        // for(Cliente cli : lista){
        //     if(cli.getCpf().equals(clienteRemover.getCpf())){
        //         System.out.println("Removendo o cliente de CPF " + clienteRemover.getCpf());
        //         itRemover.remove();

        //         break;
        //     }
        // }

        // System.out.println("");
        // System.out.println("Percorrendo com 'foreach'");
        // for(Cliente c : lista){
        //     System.out.println("Nome: " + c.getNome() + " | " + "CPF: " + c.getCpf());
        // }
    }
}
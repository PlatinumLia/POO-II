import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCores{
    public static void main(String[] args) {
        String vetCores[] = {"Magenta", "Branco", "Verde", "Azul"};
        ArrayList<String> listaCores = new ArrayList<String>();

        System.out.println("Percorrer vetor com contador");
        for(int i = 0; i < vetCores.length; i++){
            System.out.println(vetCores[i]);
        }

        System.out.println("");
        System.out.println("Percorrer vetor com 'foreach'");
        for(String cor : vetCores){
            System.out.println(cor);
            listaCores.add(cor); //adicionando as cores no arrayList
        }

        System.out.println("");
        System.out.println("Percorrer o arrayList com 'for'");
        for(int count = 0; count < listaCores.size(); count++){
            System.out.println(listaCores.get(count));
        }

        System.out.println("");
        System.out.println("Percorrer o arrayList com 'iterator'");
        Iterator<String> it = listaCores.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        System.out.println("");
        System.out.println("Percorrer o arrayList com 'foreach'");
        for(String cor : listaCores){
            System.out.println(cor);
        }
    }
}
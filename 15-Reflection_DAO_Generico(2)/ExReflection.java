import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExReflection {
    public static void main(String[] args) {
        try {
            //se sei o nome da classe
            // Class c = Class.forName("Veiculo");
            
            Veiculo v = new Veiculo();
            Class<?> c = v.getClass();//se recebo um objeto e não sei seu tipo
            // <?> estou informando que vou receber um objeto, mas não sei de qual classe
            System.out.println(c.getName());
            System.out.println("----> Atributos");
            Field fields[] = c.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("Detalhado: " + f.toString());
                System.out.println("Somente nome: " + f.getName()
                    + " - tipo: " + f.getType());
            }

            System.out.println("----> Métodos");
            Method methods[] = c.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println("Detalhado: " + m.toString());
                System.out.println("Somente nome: " + m.getName());
                Parameter parameters[] = m.getParameters();
                for (Parameter p : parameters) {
                    //nome do param só é armazenado no .class se
                    //compilar com -parameters
                    System.out.println(p.getName());
                    System.out.println(p.getParameterizedType());
                }
                System.out.println("---");
                if(m.getName().equals("setAno")){
                    //chamando método de objeto existente
                    m.invoke(v, 2026);

                    //instanciando objeto e chamando método
                    m.invoke(c.getDeclaredConstructor().newInstance(), 2020);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

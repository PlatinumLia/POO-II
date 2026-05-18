public class UsaValoresEnum{
    public static void main(String[] args) {
        System.out.println("Dia: " + DiaSemanaEnum.SEX); //mostrando apenas o Enum, sem o valor associado
        System.out.println("Dia: " + DiaSemanaEnum.QUA.getDia()); //mostrando o valor associado ao Enum

        System.out.println("Campus: " + CampiIfprEnum.FOZ.getNome() + " | Inaugurado em: " + CampiIfprEnum.FOZ.getAnoCriacao());

        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("Livro: " + LivroEnum.A_METAMORFOSE.getTitulo() + " | Autor(a): " + LivroEnum.A_METAMORFOSE.getAutor() + " | Lançamento: " + LivroEnum.A_METAMORFOSE.getAnoLancamento() + " | Páginas: " + LivroEnum.A_METAMORFOSE.getQtdPaginas() + " | Gênero: " + LivroEnum.A_METAMORFOSE.getGeneroLiterario());
        
        System.out.println("");
        System.out.println("Livro: " + LivroEnum.VERITY.getTitulo() + " | Autor(a): " + LivroEnum.VERITY.getAutor() + " | Lançamento: " + LivroEnum.VERITY.getAnoLancamento() + " | Páginas: " + LivroEnum.VERITY.getQtdPaginas() + " | Gênero: " + LivroEnum.VERITY.getGeneroLiterario());
    }
}
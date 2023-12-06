import java.util.List;
import contracts.iAlunoRepository;
import exceptions.AlunoNaoEncontradoException;
import exceptions.MatriculaInvalidaException;
import models.Aluno;
import repositories.ArrayListAlunoRepository;

public class App {
    public static void main(String[] args) {
        iAlunoRepository alunoRepository = new ArrayListAlunoRepository();

        alunoRepository.adicionar(new Aluno("Eduardo", "7418529637"));
        alunoRepository.adicionar(new Aluno("Cuan", "9697418522"));
        alunoRepository.adicionar(new Aluno("Toin", "7419639518"));
        alunoRepository.adicionar(new Aluno("Carlos Juan Perez da Cunha Nobrega Ernando de irigo Montoia", "4567890123"));
        alunoRepository.adicionar(new Aluno("Buneca", "7894563218"));
        alunoRepository.adicionar(new Aluno("Django", "9517536548"));
        alunoRepository.adicionar(new Aluno("Michael", "7417532684"));
        alunoRepository.adicionar(new Aluno("Hugäo", "7591538658"));

        System.out.println("-----------------");
        System.out.println("Lista de Alunos:");
        System.out.println("-----------------");
        List<Aluno> alunos = alunoRepository.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
            System.out.println("---------------------------");
        System.out.println();

        try {

            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().length() != 10) {
                    throw new MatriculaInvalidaException(
                            "Matricula invalida: " + aluno.getNome() + ", " + aluno.getMatricula());
                }
            }
            Aluno alunoBuscado = alunoRepository.buscar("Ana");
            
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Aluno buscado e removido: " + alunoBuscado);
            System.out.println("--------------------------------------------------------------------");
            
            alunoRepository.remover(alunoBuscado);
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return;
        } catch (MatriculaInvalidaException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();

        System.out.println("Lista de Alunos após remoção:");
        alunos = alunoRepository.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}

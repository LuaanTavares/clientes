import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Servico {
    String nomeCliente;
    String descricao;
    String dataConclusao;

    Servico(String nomeCliente, String descricao, String dataConclusao) {
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente + ", Serviço: " + descricao + ", Data: " + dataConclusao;
    }
}

public class SistemaControle {
    List<Servico> historicoServicos = new ArrayList<>();

    void registrarServico(String nomeCliente, String descricao, String dataConclusao) {
        historicoServicos.add(new Servico(nomeCliente, descricao, dataConclusao));
        System.out.println("Serviço registrado!");
    }

    void listarServicos() {
        if (historicoServicos.isEmpty()) {
            System.out.println("Nenhum serviço registrado.");
        } else {
            for (Servico servico : historicoServicos) {
                System.out.println(servico);
            }
        }
    }

    public static void main(String[] args) {
        SistemaControle sistema = new SistemaControle();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Registrar Serviço");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            if (opcao == 1) {
                System.out.print("Nome do Cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.print("Descrição do Serviço: ");
                String descricao = scanner.nextLine();
                System.out.print("Data de Conclusão: ");
                String dataConclusao = scanner.nextLine();

                sistema.registrarServico(nomeCliente, descricao, dataConclusao);
            } else if (opcao == 2) {
                sistema.listarServicos();
            } else if (opcao == 3) {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
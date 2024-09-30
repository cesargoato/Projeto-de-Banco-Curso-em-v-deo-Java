import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Lista para armazenar várias contas
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    // Método para inicializar o menu
    public static void iniciarMenu() {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n===== Menu de Opções =====");
            System.out.println("1. Abrir Nova Conta");
            System.out.println("2. Fechar Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Consultar Status da Conta");
            System.out.println("7. Listar Todas as Contas");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    abrirConta();
                    break;

                case 2:
                    fecharConta();
                    break;

                case 3:
                    depositar();
                    break;

                case 4:
                    sacar();
                    break;

                case 5:
                    consultarSaldo();
                    break;

                case 6:
                    consultarStatus();
                    break;

                case 7:
                    listarContas();
                    break;

                case 8:
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Método para abrir uma nova conta
    public static void abrirConta() {
        System.out.print("Informe o tipo da conta (CC para Conta Corrente, CP para Conta Poupança): ");
        String tipo = teclado.next();
        System.out.print("Informe o nome do titular: ");
        String nome = teclado.next();

        ContaBancaria novaConta = new ContaBancaria();
        novaConta.setNumConta(contas.size() + 1); // Definindo número da conta automaticamente
        novaConta.setDono(nome);
        novaConta.abrirConta(tipo);

        contas.add(novaConta);
        System.out.println("Conta número " + novaConta.getNumConta() + " criada com sucesso!");
    }

    // Método para fechar uma conta
    public static void fecharConta() {
        ContaBancaria conta = buscarConta();
        if (conta != null) {
            conta.fecharConta();
        }
    }

    // Método para depositar em uma conta
    public static void depositar() {
        ContaBancaria conta = buscarConta();
        if (conta != null) {
            System.out.print("Informe o valor do depósito: ");
            double valor = teclado.nextDouble();
            conta.depositar(valor);
        }
    }

    // Método para sacar de uma conta
    public static void sacar() {
        ContaBancaria conta = buscarConta();
        if (conta != null) {
            System.out.print("Informe o valor do saque: ");
            double valor = teclado.nextDouble();
            conta.sacar(valor);
        }
    }

    // Método para consultar saldo de uma conta
    public static void consultarSaldo() {
        ContaBancaria conta = buscarConta();
        if (conta != null) {
            System.out.println("Saldo atual: R$" + conta.getSaldo());
        }
    }

    // Método para consultar o status da conta
    public static void consultarStatus() {
        ContaBancaria conta = buscarConta();
        if (conta != null) {
            if (conta.isStatus()) {
                System.out.println("A conta está ativa.");
            } else {
                System.out.println("A conta está inativa.");
            }
        }
    }

    // Método para listar todas as contas
    public static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria conta : contas) {
                System.out.println("Conta número: " + conta.getNumConta() + " - Titular: " + conta.getDono() + " - Saldo: R$" + conta.getSaldo() + " - Status: " + (conta.isStatus() ? "Ativa" : "Inativa"));
            }
        }
    }

    // Método para buscar uma conta por número
    public static ContaBancaria buscarConta() {
        System.out.print("Informe o número da conta: ");
        int numConta = teclado.nextInt();
        for (ContaBancaria conta : contas) {
            if (conta.getNumConta() == numConta) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public static void main(String[] args) {
        iniciarMenu();
    }
}
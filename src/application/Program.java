package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Digite os dados da conta: ");
            System.out.print("Número: ");
            Integer numero = sc.nextInt();
            System.out.print("Titular: ");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print("Saldo inicial: R$ ");
            Double saldoInicial = sc.nextDouble();
            System.out.print("Limite de saque: R$ ");
            Double limiteDeSaque = sc.nextDouble();

            Conta conta = new Conta(numero, titular, saldoInicial, limiteDeSaque);

            System.out.println();
            System.out.print("Digite o valor que deseja sacar: R$ ");
            Double valor = sc.nextDouble();

            conta.saque(valor);

            System.out.printf("Novo saldo: R$ %.2f\n", conta.getSaldo());
        }
        catch (DomainException e) {
            System.out.println("Erro de saque: " + e.getMessage()); /* e.getMessage() o objeto "e" do tipo DomainException irá chamar a mensagem
                                                                   * de erro armazenada no throw new DomainException(""), que está no método saque.
                                                                   */
        }
        catch(RuntimeException e) {
            System.out.println("Erro inesperado.");
        }

    }

}


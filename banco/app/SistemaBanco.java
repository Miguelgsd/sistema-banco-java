package banco.app;

import javax.swing.JOptionPane;
import banco.model.Cliente;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;
import banco.service.BancoService;

public class SistemaBanco {
    public static void main(String[] args){
        int opcao = -1;
        do{
            String menu = "---------- SISTEMA BANCÁRIO ----------\n" + "\n1 - Cadastrar conta corrente" + "\n2 - Cadastrar conta poupança\n" + "3 - Depositar\n" + "4 - Sacar\n" + "5 - Consultar saldo\n" + "6 - Exibir extrato da conta\n" + "7 - Exibir histórico de transações\n" + "8 - Listar todas as contas\n" + "9 - Relatório geral do banco\n" + "0 - Encerrar sistema";
            String entrada = JOptionPane.showInputDialog(menu);

            opcao = Integer.parseInt(entrada);

            switch(opcao){
                case 1:
                    String nome = JOptionPane.showInputDialog("Insira seu nome completo:");
                    String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
                    String telefone = JOptionPane.showInputDialog("Insira seu telefone: ");
                    Cliente cliente = new Cliente(nome, cpf, telefone);

                    String numero = JOptionPane.showInputDialog("Crie um número para a sua conta: ");
                    ContaCorrente conta = new ContaCorrente(numero, cliente, 0.0, 500.0);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso.", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
                    break;
                
                case 2:

                    break;
                
                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Insira uma opção válida para prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while(opcao != 0);
    }
}
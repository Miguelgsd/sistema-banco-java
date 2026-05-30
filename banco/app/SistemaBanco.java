package banco.app;

import javax.swing.JOptionPane;
import banco.model.Cliente;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;
import banco.service.BancoService;
import banco.model.ContaBancaria;

public class SistemaBanco {
    public static void main(String[] args){
        int opcao = -1;
        Cliente cliente = null;
        BancoService banco = new BancoService();
        do{
            String menu = "---------- SISTEMA BANCÁRIO ----------\n" + "\n1 - Cadastrar conta corrente" + "\n2 - Cadastrar conta poupança\n" + "3 - Depositar\n" + "4 - Sacar\n" + "5 - Consultar saldo\n" + "6 - Exibir extrato da conta\n" + "7 - Exibir histórico de transações\n" + "8 - Listar todas as contas\n" + "9 - Relatório geral do banco\n" + "0 - Encerrar sistema";
            String entrada = JOptionPane.showInputDialog(menu);

            opcao = Integer.parseInt(entrada);

            String busca;
            ContaBancaria contaAuxiliar;
            switch(opcao){
                case 1:
                    if(cliente == null){
                        String nome = JOptionPane.showInputDialog("Insira seu nome completo:");
                        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
                        String telefone = JOptionPane.showInputDialog("Insira seu telefone: ");
                        cliente = new Cliente(nome, cpf, telefone);
                    }

                    String numeroC = JOptionPane.showInputDialog("Crie um número para a sua conta: ");
                    ContaCorrente contaC = new ContaCorrente(numeroC, cliente, 0.0, 500.0);
                    banco.cadastrarContaCorrente(contaC);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso.", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
                    break;
                
                case 2:
                    if(cliente == null){
                        String nome = JOptionPane.showInputDialog("Insira seu nome completo:");
                        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
                        String telefone = JOptionPane.showInputDialog("Insira seu telefone: ");
                        cliente = new Cliente(nome, cpf, telefone);
                    }

                    String numeroP = JOptionPane.showInputDialog("Crie um número para a conta: ");

                    ContaPoupanca contaP = new ContaPoupanca(numeroP, cliente, 0.0, 0.01);
                    banco.cadastrarContaPoupanca(contaP);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso.", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
                    break;
                
                case 3:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);
                    
                    if (contaAuxiliar != null) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
                        contaAuxiliar.depositar(valor);
                        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
                    }
                    break;

                case 4:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);
                    
                    if (contaAuxiliar != null) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para sacar:"));
                        contaAuxiliar.sacar(valor);
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
                    }
                    break;

                case 5:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);

                    JOptionPane.showMessageDialog(null, "Saldo disponível: R$" + contaAuxiliar.getSaldo(), "Saldo Bancário", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Insira uma opção válida para prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while(opcao != 0);
    }
}
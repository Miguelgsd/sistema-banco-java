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
            String regexCpf = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
            switch(opcao){
                case 1:
                    if(cliente == null){
                        String nome = JOptionPane.showInputDialog("Insira seu nome completo:");
                        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
                        if(!cpf.matches(regexCpf)){
                            JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        String telefone = JOptionPane.showInputDialog("Insira seu telefone: ");
                        cliente = new Cliente(nome, cpf, telefone);
                    }

                    String numeroC = JOptionPane.showInputDialog("Crie um número para a sua conta: ");
                    ContaBancaria existenteC = banco.buscarConta(numeroC);

                    if(existenteC != null){
                        JOptionPane.showMessageDialog(null, "Já existe uma conta com este número. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        ContaCorrente contaC = new ContaCorrente(numeroC, cliente, 0.0, 500.0);
                        banco.cadastrarContaCorrente(contaC);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso.", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                
                case 2:
                    if(cliente == null){
                        String nome = JOptionPane.showInputDialog("Insira seu nome completo:");
                        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
                        if(!cpf.matches(regexCpf)){
                            JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        String telefone = JOptionPane.showInputDialog("Insira seu telefone: ");
                        cliente = new Cliente(nome, cpf, telefone);
                    }

                    String numeroP = JOptionPane.showInputDialog("Crie um número para a conta: ");
                    ContaBancaria existenteP = banco.buscarConta(numeroP);

                    if(existenteP != null){
                        JOptionPane.showMessageDialog(null, "Já existe uma conta com este número. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        ContaPoupanca contaP = new ContaPoupanca(numeroP, cliente, 0.0, 0.01);
                        banco.cadastrarContaPoupanca(contaP);
                        JOptionPane.showMessageDialog(null, "Conta criada com sucesso.", "Operação realizada", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                
                case 3:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);
                    
                    if (contaAuxiliar != null) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar:"));
                        contaAuxiliar.depositar(valor);
                    } else {JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);}
                    break;

                case 4:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);
                    
                    if (contaAuxiliar != null) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para sacar:"));
                        contaAuxiliar.sacar(valor);
                    } else {JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);}
                    break;

                case 5:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);

                    if(contaAuxiliar != null){
                        JOptionPane.showMessageDialog(null, "Saldo disponível: R$" + String.format("%.2f", contaAuxiliar.getSaldo()), "Saldo Bancário", JOptionPane.INFORMATION_MESSAGE);
                    } else {JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);}                    
                    break;

                case 6:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);

                    if(contaAuxiliar != null){
                        contaAuxiliar.gerarExtrato();
                    } else {JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);}
                    break;

                case 7:
                    busca = JOptionPane.showInputDialog("Digite o número da conta:");
                    contaAuxiliar = banco.buscarConta(busca);

                    if(contaAuxiliar != null){
                    contaAuxiliar.exibirHistorico();
                    } else {JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);}
                    break;

                case 8:
                    banco.listarTodasAsContas();
                    break;

                case 9:
                    banco.exibirRelatorioGeral();
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Insira uma opção válida para prosseguir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while(opcao != 0);
    }
}
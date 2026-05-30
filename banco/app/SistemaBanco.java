package banco.app;

import javax.swing.JOptionPane;

public class SistemaBanco {
    public static void main(String[] args){
        int opcao = -1;
        do{
            String menu = "---------- SISTEMA BANCÁRIO ----------\n" + "\n1 - Cadastrar conta corrente" + "\n2 - Cadastrar conta poupança\n" + "3 - Depositar\n" + "4 - Sacar\n" + "5 - Consultar saldo\n" + "6 - Exibir extrato da conta\n" + "7 - Exibir histórico de transações\n" + "8 - Listar todas as contas\n" + "9 - Relatório geral do banco\n" + "0 - Encerrar sistema";
            String entrada = JOptionPane.showInputDialog(menu);

            opcao = Integer.parseInt(entrada);
        } while(opcao != 0);
    }
}
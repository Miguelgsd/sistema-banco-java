# Sistema Bancário Java

Este projeto implementa um sistema bancário simples em Java, com cadastro e gerenciamento de contas correntes e poupança. O sistema oferece um menu interativo via JOptionPane, permitindo criar contas, depositar, sacar, consultar saldo, exibir extratos e históricos, listar contas e gerar relatório geral do banco.

## Tecnologias utilizadas

- Java 21
- IDE: VS Code
- Interface gráfica leve: javax.swing.JOptionPane

## Como compilar e executar

1. Abra o terminal na raiz do projeto.
2. Compile os arquivos Java com:

```
javac banco/**/*.java
```

3. Execute o sistema principal com:

```
java banco.app.SistemaBanco
```

## Estrutura do projeto

O projeto está organizado em pacotes Java:

- `banco.app` - contém a classe principal do sistema e o menu de interação.
- `banco.interfaces` - define contratos que todas as contas devem cumprir.
- `banco.model` - contém as classes de domínio do banco, como cliente e contas.
- `banco.service` - gerencia a lógica de negócio e armazenamento das contas.

## Descrição dos pacotes e classes

### `banco.app`

- `SistemaBanco` - classe principal com o método `main`. Apresenta o menu em loop e trata as opções do usuário usando JOptionPane. Cria e gerencia a instância de `BancoService` para localizar contas e executar operações.

### `banco.interfaces`

- `Operavel` - interface que define o contrato mínimo para qualquer conta bancária do sistema:
  - `depositar(double valor)`
  - `sacar(double valor)`
  - `exibirSaldo()`

### `banco.model`

- `Cliente` - representa o titular de uma conta, com `nome`, `cpf` e `telefone`. Possui construtor parametrizado, getters, setters e `toString()` para apresentação textual.

- `ContaBancaria` - classe abstrata base para todas as contas. Implementa `Operavel` e centraliza atributos e comportamentos comuns:
  - `numeroConta`
  - `titular`
  - `saldo`
  - `historico de transações`
  - métodos de depósito, saque, exibição de saldo, registro e exibição de histórico
  - método abstrato `gerarExtrato()` para ser implementado por cada tipo de conta.

- `ContaCorrente` - herda `ContaBancaria` e representa uma conta corrente com limite de cheque especial:
  - atributo `limiteChequEspecial`
  - sobrescreve `sacar` para permitir uso de cheque especial quando necessário
  - método `usarChequeEspecial(double valor)` para consumo manual do limite
  - implementa `gerarExtrato()` exibindo detalhes do titular, número da conta, saldo, limite e histórico

- `ContaPoupanca` - herda `ContaBancaria` e representa uma conta poupança com rendimento mensal:
  - atributo `taxaRendimentoMensal`
  - método `calcularRendimento()` para calcular o rendimento do saldo
  - método `aplicarRendimento()` para aplicar o rendimento e registrar a transação
  - implementa `gerarExtrato()` exibindo titular, número da conta, saldo, taxa, rendimento estimado e histórico

### `banco.service`

- `BancoService` - classe responsável pela lógica de negócio do banco e pelo armazenamento das contas em listas:
  - lista de `ContaCorrente`
  - lista de `ContaPoupanca`
  - métodos para cadastrar contas, buscar conta por número, listar todas as contas, calcular patrimônio total e exibir relatório geral

## Diagrama textual da hierarquia de classes

```text
Operavel (interface)
  ↑
ContaBancaria (abstract class)
  ↑             ↑
ContaCorrente    ContaPoupanca
```

## Feito por
- **Miguel, 2º período**

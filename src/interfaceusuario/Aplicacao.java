package principal.interfaceusuario;
import principal.dados.*;
import java.util.*;

public class Aplicacao {
    private Scanner scanner = new Scanner(System.in);
    private List<Banco> bancos = new ArrayList<>();
    public void executar(){
        int opcao;
        do{
            System.out.println("\n" + //
                                "--------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Criar banco");
            System.out.println("2. Criar conta");
            System.out.println("3. Imprimir extrato do banco");
            System.out.println("4. Imprimir extrato da conta");
            System.out.println("5. Depositar");
            System.out.println("6. Retirar");
            System.out.println("7. Transferencia");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> criarBanco();
                case 2 -> criarConta(); 
                case 3 -> extratoBanco();
                case 4 -> extratoConta();
                case 5 -> deposito();
                case 6 -> retirada();
                case 7 -> transferencia();
            }
        } while(opcao != 0);
    }

    

    private Banco buscarBanco(){
        System.out.print("Insira o nome do banco: ");
        String nome = scanner.nextLine();
        for(Banco b : bancos){
            if(b.getNome().equalsIgnoreCase(nome)) return b;
        }
        System.out.println("Banco não encontrada.");
        return null;
    }

    private Conta buscarConta(){
        Banco b = buscarBanco();
        if(b == null) return null;
        System.out.print("Insira o nome do titular da conta: ");
        String nome = scanner.nextLine();
        for(Conta c : b.getConta()){
            if(c.getCliente().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }
    

    private void criarBanco(){
        System.out.print("Nome do banco: ");
        String nome = scanner.nextLine();
        bancos.add(new Banco(nome));
        System.out.println("Banco criado.");
    } 

    private void criarConta(){
        Banco b = buscarBanco();
        if(b == null) return;

        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();
        System.out.print("Saldo da conta: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine();  //Usado para consumir o "espaço" do teclado, senão o codigo morre toda vez que adicionar uma conta
        Conta c = new Conta(nome, saldo);
        b.adicionarConta(c);
        System.out.println("Conta criada.");
    }

    private void extratoConta(){
        Conta c = buscarConta();
        if(c == null) return;
        c.imprimirExtrato();
    }

    private void extratoBanco(){
        Banco b = buscarBanco();
        if(b == null) return;
        b.imprimirExtrato();
    }

    private void deposito(){
        Conta c = buscarConta();
        if(c == null) return;

        System.out.print("Insira o valor que sera depositado: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine();
        c.depositar(saldo);
        System.out.println("Deposito concluido.");
    }

    private void retirada(){
        Conta c = buscarConta();
        if(c == null) return;

        System.out.print("Insira o valor que sera retirado: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine();
        c.retirar(saldo);
        System.out.println("Retirada concluida.");
    }

    private void transferencia(){
        System.out.print("Dados do recebedor \n");
        Conta c = buscarConta();
        if(c == null) return;

        System.out.print("Dados do pagador \n");
        Conta c2 = buscarConta();
        if(c2 == null) return;

        System.out.print("Insira o valor que sera transferido: ");
        float saldo = scanner.nextFloat();
        scanner.nextLine();
        
        c.transferir(c2, saldo);
        System.out.println("Transferência concluida.");
    }

}

package sistema.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import sistema.tarefas.Tarefa;
import sistema.service.GerenciadorTarefa;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        GerenciadorTarefa gerenciador = new GerenciadorTarefa();
        boolean rodando = true;

        while(rodando){

            System.out.println(" ------Gerenciador de Tarefas ------ ");
            System.out.println("""
                    |1. Adicionar nova tarefa\s
                    |2. Listar todas as tarefas\s
                    |3. Listar apenas pendente
                    |4. Marcar tarefa como concluída\s
                    |5. Remover tarefa\s
                    |6. Adicionar prioridades\s
                    |0. Sair""");

            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){

                case 1:

                    System.out.println("Digite o titulo da tarefa: ");
                    String titulo = scan.nextLine();
                    System.out.println("Digite a descrição da tarefa: ");
                    String descricao = scan.nextLine();

                    gerenciador.adicionarTarefa(titulo, descricao);

                    break;

                case 2:

                    gerenciador.listarTodasTarefas();
                    break;

                case 3:

                    gerenciador.listarTarefaPendente();
                    break;

                case 4:

                    if(!gerenciador.listarTarefaPendente()){
                        break;
                    }
                    System.out.println("|Digite o ID da tarefa que deseja concluir: ");

                    try{
                        int idConcluir = scan.nextInt();
                        scan.nextLine();
                        gerenciador.concluirTarefa(idConcluir);
                    }catch(InputMismatchException e){
                        System.out.println("ERRO! Digite apenas números válidos para o ID!");
                        scan.nextLine();
                    }

                    break;

                case 5:

                    if(!gerenciador.listarTodasTarefas()){
                        break;
                    }
                    System.out.println("|Digite o ID da tarefa que deseja remover: ");

                    try{
                        int idRemover = scan.nextInt();
                        scan.nextLine();
                        gerenciador.removerTarefa(idRemover);
                    }catch(InputMismatchException e){
                        System.out.println("ERRO! Digite apenas números válidos para o ID!");
                        scan.nextLine();
                    }

                    break;

                case 6:

                    if(!gerenciador.listarTodasTarefas()){
                        break;
                    }
                    System.out.println("|Digite o ID da tarefa que deseja adicionar prioridade: ");

                    try{
                        int idPrioridade = scan.nextInt();
                        scan.nextLine();
                        System.out.println("""
                                |Escolha: 
                                |1. Baixa\s
                                |2. Media\s
                                |3. Alta""");
                        int escolha = scan.nextInt();
                        scan.nextLine();
                        gerenciador.adicionarPrioridade(idPrioridade, escolha);
                    }catch(InputMismatchException e){
                        System.out.println("ERRO! Digite apenas números válidos para o ID!");
                        scan.nextLine();
                    }

                    break;

                case 0:
                    gerenciador.salvarCsv();
                    rodando = false;
                    System.out.println("Saindo.");
                    break;
            }

        }

    }
}

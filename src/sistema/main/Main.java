package sistema.main;

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
            System.out.println("|1. Adicionar nova tarefa \n|2. Listar todas as tarefas \n|3. Listar apenas pendente" +
                                "\n4. Marcar tarefa como concluída \n5. Remover tarefa \n0. Sair");

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

                    gerenciador.listarTarefaPendente();
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

                case 0:
                    rodando = false;
                    break;
            }

        }

    }
}

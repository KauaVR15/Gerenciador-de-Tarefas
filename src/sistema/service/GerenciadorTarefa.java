package sistema.service;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import sistema.tarefas.Tarefa;

import java.util.ArrayList;

public class GerenciadorTarefa {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String titulo, String descricao){
        if(titulo == null || titulo.isBlank()){
            System.out.println("Erro! O título da tarefa não pode estar em branco!");
            return;
        }

        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");

    }

    public void listarTodasTarefas(){
        if(tarefas.isEmpty()){
            System.out.println("Parabens! Você não tem nenhuma tarefa pendente!");
            return;
        }

        System.out.println("Todas as tarefas");
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
        }

    }

    public void listarTarefaPendente(){
        boolean temPendente = false;

        System.out.println("Tarefas Pendentes");

        for(Tarefa tarefa : tarefas){
            if(!tarefa.isConcluida()){
                System.out.println(tarefa);
                temPendente = true;
            }
        }

        if(!temPendente){
            System.out.println("Nenhuma tarefa pendente no momento!");
        }

    }

    public void concluirTarefa(int id){
        for(Tarefa tarefa : tarefas){
            if(tarefa.getId() == id){
                if(tarefa.isConcluida()){
                    System.out.println("Esta tarefa já está concluída!");
                }
                else{
                    tarefa.marcarComoConcluida();
                    System.out.println("Parabens! Você concluiu sua tarefa com sucesso!");
                }
                return;
            }
        }

        System.out.println("Nenhuma tarefa encontrada com o ID fornecido!");
    }



}

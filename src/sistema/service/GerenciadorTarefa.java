package sistema.service;

import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import sistema.tarefas.Prioridade;
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

    public boolean listarTodasTarefas(){
        if(tarefas.isEmpty()){
            System.out.println("Parabens! Você não tem nenhuma tarefa no momento!");
            return false;
        }

        System.out.println("Todas as tarefas");
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
            System.out.println("|Descrição: "  + tarefa.getDescricao());
            System.out.println("|Prioridade: "  + tarefa.getPrioridade());

        }
        return true;
    }

    public boolean listarTarefaPendente(){
        boolean temPendente = false;

        System.out.println("Tarefas Pendentes");

        for(Tarefa tarefa : tarefas){
            if(!tarefa.isConcluida()){
                System.out.println(tarefa);
                System.out.println("|Descrição: "  + tarefa.getDescricao());
                System.out.println("|Prioridade: "  + tarefa.getPrioridade());
                temPendente = true;
            }
        }

        if(!temPendente){
            System.out.println("Nenhuma tarefa pendente no momento!");
            return false;
        }
        return true;
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

    public void removerTarefa(int id){
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
        System.out.println("Tarefa removida com sucesso!");
    }

    public void adicionarPrioridade(int id, int escolha){

         for(Tarefa tarefa : tarefas){
             if(tarefa.getId() == id){

                 switch(escolha){

                     case 1:
                         tarefa.setPrioridade(Prioridade.Baixa);
                         System.out.println("Prioridade baixa adicionada com sucesso!");
                         break;

                     case 2:

                         tarefa.setPrioridade(Prioridade.Media);
                         System.out.println("Prioridade media adicionada com sucesso!");
                         break;

                     case 3:
                         tarefa.setPrioridade(Prioridade.Alta);
                         System.out.println("Prioridade alta adicionada com sucesso!");
                         break;
                 }
             }
             else{
                 System.out.println("Nenhuma tarefa encontrada com o ID fornecido!");
             }
         }
    }

}

package sistema.tarefas;

public class Tarefa {

    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String descricao;
    boolean concluida = false;

    public Tarefa(){}

    public Tarefa(String titulo, String descricao){

        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void marcarComoConcluida(){
        this.concluida = true;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString(){
        String status = this.concluida ? "[X]" : "[ ]";
        return status + " " + this.id + " - " + this.titulo;
    }

}

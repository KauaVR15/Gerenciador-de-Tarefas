package sistema.tarefas;

public class Tarefa {

    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    boolean concluida = false;

    public Tarefa(){}

    public Tarefa(String titulo, String descricao){

        this.id = contadorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = Prioridade.Baixa;
        this.concluida = false;
    }

    public Tarefa(int id, String titulo, String descricao, boolean concluida, Prioridade prioridade){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.prioridade = prioridade;

        if(id >= contadorId){
            contadorId = id + 1;
        }

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

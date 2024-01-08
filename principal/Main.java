package principal;


import trab2.lists.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> dedos = new LinkedList<>();

        //insercao com 1 parametro
        dedos.add("Mindinho");

        dedos.add("Pai de Todos");
        dedos.add("Furabolo");
        dedos.add("Mata Piolho");
        dedos.add("e a Fumiguinha?");



        //prints
        System.out.println("Lista antes da inserção:");
        dedos.print();

        //inserindo elem. na posicao determinada
        dedos.add(1,"Seu Vizinho");                  //por algum motivo nao funciona, talvez tenha relaçao com o metodo de percorrer a lista

        //excluindo um elemento
        dedos.remove(2);                                 //por algum motivo nao funciona, talvez tenha relaçao com o metodo de percorrer a lista

        //prints
        System.out.println("\nLista após a inserção:");
        dedos.print();
    }
}

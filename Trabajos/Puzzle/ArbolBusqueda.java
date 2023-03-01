package Puzzle;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mario R�os
 */
public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    String estadoInicial = "12578 346";


    Nodo a = new Nodo(estadoInicial);
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Queue<Nodo> estadosPorVisitar = new LinkedList<Nodo>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }

            }
            nodoActual = estadosPorVisitar.poll();    
            a.imprimeSolucion(raiz, nodoActual);
            System.out.println("\n------");

        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    public void busquedaPorProfundidad()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack<>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }

            }
            nodoActual = estadosPorVisitar.pop();           
            // a.imprimeSolucion(raiz, nodoActual);
            System.out.println("\n------");

        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    public void busquedaPorAnchuraHeuristica(){
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    // nHijo.costo = Heuristica1(nHijo.getEstado(), objetivo); 
                    // nHijo.costo = Heuristica2(nHijo.getEstado(), objetivo);
                    nHijo.costo = Heuristica3(nHijo.getEstado(), objetivo);

                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }

            }
            nodoActual = estadosPorVisitar.poll();    
            a.imprimeSolucion(raiz, nodoActual);
            System.out.println("\n------");

        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    public void busquedaPorProfundidadHeuristica(){
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack<>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }

            }
            nodoActual = estadosPorVisitar.pop();           
            // a.imprimeSolucion(raiz, nodoActual);
            System.out.println("\n------");

        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }

    private int Heuristica1(String estado, String objetivo2)
    {
        int resultado = 0;

        for (int i = 0; i < estado.length(); i++) {
            if (estado.charAt(i) != objetivo.charAt(i)) {
                resultado++;
            }
        }
        return resultado;
    }

    private int Heuristica2(String estado, String objetivo2)
    {
        int resultado = 0;
        int num1, num2;

        for (int i = 0; i < estado.length(); i++) {
            num1 = Character.getNumericValue(estado.charAt(i));
            if (estado.charAt(i) == ' ') {
                num1 = 0;
            }

            num2 = Character.getNumericValue(objetivo2.charAt(i));
            if (estado.charAt(i) == ' ') {
                num2 = 0;
            }

            resultado = resultado + Math.abs(num1 - num2);
        }
        return resultado;
    }

    private int Heuristica3(String estado, String objetivo2)
    {
        int resultado = 0;

        int posE1 = 3, posE2 = 6, posO1 = 3, posO2 = 6;

        int numEstado1 = 0,numEstado2 = 0,numEstado3 = 0;
        int numObjetivo1 = 0, numObjetivo2 = 0, numObjetivo3 = 0;

        int sumEstado, sumObjetivo;

        for (int i = 0; i <= estado.length(); i++) {

            //Estado
            if (i < 3) {
                numEstado1 = numEstado1 + Character.getNumericValue(estado.charAt(i));
                if (estado.charAt(i) == ' ') 
                    numEstado1 = 0;
            }

            if (i < 6) {
                numEstado2 = numEstado2 + Character.getNumericValue(estado.charAt(posE1));
                if (estado.charAt(i) == ' ') 
                    numEstado2 = 0;
                posE1++;
            }

            if (i < 9) {
                numEstado3 = numEstado3 + Character.getNumericValue(estado.charAt(posE2));
                if (estado.charAt(posE2) == ' ') 
                    numEstado3 = 0;
                posE2++;
            }
            
            //Objetivo
            if (i < 3) {
                numObjetivo1 = numObjetivo1 + Character.getNumericValue(objetivo2.charAt(i));
                if (objetivo2.charAt(i) == ' ') 
                    numObjetivo1 = 0;
            }

            if (i < 6) {
                numObjetivo2 = numObjetivo2 + Character.getNumericValue(objetivo2.charAt(posO1));
                if (objetivo2.charAt(posO1) == ' ') 
                    numObjetivo2 = 0;
                posO1++;
            }

            if (i < 9) {
                numObjetivo3 = numObjetivo3 + Character.getNumericValue(objetivo2.charAt(posO2));
                if (objetivo2.charAt(posO2) == ' ') 
                    numObjetivo3 = 0;
                posO2++;
            }

            sumEstado = numEstado1 + numEstado2 + numEstado3;
            sumObjetivo = numObjetivo1 + numObjetivo2 + numObjetivo3;

            resultado = resultado + Math.abs(sumEstado - sumObjetivo);
        }
        return resultado;
    }
    
}

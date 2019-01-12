package Aula_12;

import Aula9eAula10.ElementNotFoundException;
import java.util.Iterator;

public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_SIZE = 10;
    protected int numVertices;
    protected boolean[][] adjMatrix;
    protected T[] vertices;
    protected int code;

    public Graph() {
        this.numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
        this.vertices = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity(); //TODO expandCapacity of vertices length and matrix length
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    private int getIndex(T vertex) throws ElementNotFoundException {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        throw new ElementNotFoundException("the graph");
    }

        // 4 ciclos, dois a dois 
        // por linhas e colunas dos valores que queremos remover a falso e fazer shift das linhas e colunas para tras
        // ou então fazer como o joão disse, passar a última coluna e linha para a linha e coluna do vértice que queremos remover
    @Override
    public void removeVertex(T vertex) {
        
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        adjMatrix[getIndex(vertex1)][getIndex(vertex2)] = true;
        adjMatrix[getIndex(vertex2)][getIndex(vertex1)] = true;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        adjMatrix[getIndex(vertex1)][getIndex(vertex2)] = false;
        adjMatrix[getIndex(vertex2)][getIndex(vertex1)] = false;
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iteratorDFS(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        if (numVertices == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public int size() {
        return numVertices;
    }

    public void expandCapacity() {

    }

}

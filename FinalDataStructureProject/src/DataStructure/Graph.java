
package DataStructure;

import java.util.ArrayList;

/**
 *   a directed graph implementation using adjacency matrix
 */
public class Graph {


    /* number of vertices: */
    private int num_vertices;

    /* adjacency matrix  */
    private int adj_matrix[][];
        
    
    public Graph(int num_vertices) {
        this.num_vertices = num_vertices;
        /* initialize adjacency matrix: */
        adj_matrix = new int[num_vertices][num_vertices];
        for(int i = 0; i < num_vertices; i++)
        {
            for(int j = 0; j < num_vertices; j++)
            {
                adj_matrix[i][j] = 0;
            }
        }
    }

    /**
     * add and edge from vertex_start from vertex_end
     * @param vertex_start index of starting vertex
     * @param vertex_end index of end vertex
     * @param weight weight of the edge (arc)
     */
    public void add_edge(int vertex_start, int vertex_end, int weight)
    {
        adj_matrix[ vertex_start - 1 ] [ vertex_end -1 ] = weight;
    }

    /**
     * how many edges _____ from vertex_index
     * @param vertex_index
     * @return
     */
    public int out_deg(int vertex_index)
    {
        int degree=0;
        /* traverse row */
       for(int i = 0; i < num_vertices; i++)
       {
           if(adj_matrix[vertex_index-1][i] > 0)
             degree++;
       }
       return degree;
    }

    /**
     * how many edges _____ to vertex_index
     * @param vertex_index
     * @return
     */
    public int in_deg(int vertex_index)
    {
        int degree=0;
        /* traverse column:*/
        for(int i = 0; i < num_vertices; i++)
        {
            if(adj_matrix[i][vertex_index-1] > 0)
                degree++;
        }
        return degree;
    }

    /**
     *
     * @param vertex_index
     * @return
     */
    public int total_degree(int vertex_index)
    {
       return (in_deg(vertex_index) + out_deg(vertex_index));
    }


    /**
     * 
     * @param vertex1 index of firts vertex
     * @param vertex2 index of second vertex
     * @return true if there is a path between two vertices, false otherwise
     */
    public boolean isPath(int vertex1, int vertex2){
        boolean result = false;
        ArrayList<Graph> array = new ArrayList<Graph>();
        for (int i = 0; i < num_vertices; i++) {
            if (adj_matrix[vertex1-1][i]==1) {
                if(adj_matrix[vertex1][vertex2]==1){
                    result = true;
                    return result;
                }
                if (vertex1>vertex2) {
                    vertex1 = vertex1-1;
                    isPath(vertex1, vertex2);
                }
                else{
                    vertex1 = vertex1+1;
                    isPath(vertex1, vertex2);
                }
            }
        }
        return result;
    }

    
}

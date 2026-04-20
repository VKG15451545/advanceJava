package org.example.important;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijastraAlgorithm {
    static class Node{
        int vertex;
        int dist;
        public Node(int v,int dist){
            this.vertex = v;
            this.dist = dist;
        }
    }
    public void implementation(int src, List<List<Node>> graph){
        int totalV = graph.size();
        int[] distances = new int[totalV];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.dist-b.dist));
        pq.add(new Node(src,0));
        while (!pq.isEmpty()){
            Node currNode = pq.poll();
            for(int i=0;i<graph.get(currNode.vertex).size();i++){
                Node adjNode = graph.get(currNode.vertex).get(i);
                int dist = adjNode.dist + currNode.dist;
                if(distances[adjNode.vertex] <= dist) continue;
                distances[adjNode.vertex] = dist;
                pq.add(adjNode);
            }
        }

    }
    public void revision(){

    }
}

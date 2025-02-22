package Solution;

import org.w3c.dom.Node;

import strucher.TreeNode;

import java.util.*;

public class Graph {

    /*
     1971. Find if Path Exists in Graph

        There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

        You want to determine if there is a valid path that exists from vertex source to vertex destination.

        Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: BFS using a queue
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If we reach the destination, return true
            if (node == destination) {
                return true;
            }

            // Traverse all neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark as visited
                    queue.add(neighbor);     // Add to the queue
                }
            }
        }

        // If we exhaust the queue and don't find the destination, return false
        return false;
    }

    /*
     * 513. Find Bottom Left Tree Value

        Given the root of a binary tree, return the leftmost value in the last row of the tree.
     */

    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        findBottomLeftValue(root,ans,0);
        int level =ans.size();
        int ans2 =ans.get(level-1).get(0);
        return ans2;
    }

    public void findBottomLeftValue(TreeNode root,List<List<Integer>> ans,int level) {
        if(root==null){
            return;
        }
        if(level>=ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        findBottomLeftValue(root.left,ans,level+1);
        findBottomLeftValue(root.right,ans,level+1);
        
    }


    
}

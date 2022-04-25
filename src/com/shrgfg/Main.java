package com.shrgfg;

import java.io.BufferedReader;

 //Bellman Ford Algorithem
class Node
{
    private int u;
    private int v;
    private int weight;

    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

    Node() {}

    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}
public class Main {




    class Main {
        void bellmanFord(<Node> edges, int N, int src) {
            int dist[] = new int[N];
            for (int i = 0; i < N; i++) dist[i] = 10000000;

            dist[src] = 0;

            for (int i = 1; i <= N - 1; i++) {
                for (Node node : edges) {
                    if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                        dist[node.getV()] = dist[node.getU()] + node.getWeight();
                    }
                }
            }

            int fl = 0;
            for (Node node : edges) {
                if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    fl = 1;
                    System.out.println("Negative Cycle");
                    break;
                }
            }

            if (fl == 0) {
                for (int i = 0; i < N; i++) {
                    System.out.println(i + " " + dist[i]);
                }
            }
        }

        public static void main(String args[]) {
            int n = 6;
            ArrayList<Node> adj = new ArrayList<Node>();


            adj.add(new Node(3, 2, 6));
            adj.add(new Node(5, 3, 1));
            adj.add(new Node(0, 1, 5));
            adj.add(new Node(1, 5, -3));
            adj.add(new Node(1, 2, -2));
            adj.add(new Node(3, 4, -2));
            adj.add(new Node(2, 4, 3));


            Main obj = new Main();
            obj.bellmanFord(adj, n, 0);


        }
    }
    /*

     //Topological  Sorting
            public static void main(String[] args) throws IOException {
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                int t = Integer.parseInt(read.readLine());

                while (t-- > 0) {
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    String st[] = read.readLine().trim().split("\\s+");
                    int edg = Integer.parseInt(st[0]);
                    int nov = Integer.parseInt(st[1]);

                    for (int i = 0; i < nov + 1; i++)
                        list.add(i, new ArrayList<Integer>());

                    int p = 0;
                    for (int i = 1; i <= edg; i++) {
                        String s[] = read.readLine().trim().split("\\s+");
                        int u = Integer.parseInt(s[0]);
                        int v = Integer.parseInt(s[1]);
                        list.get(u).add(v);
                    }

                    int[] res = new Solution().topoSort(nov, list);

                    if (check(list, nov, res) == true)
                        System.out.println("1");
                    else
                        System.out.println("0");
                }
            }
            static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
                int[] map = new int[V];
                for (int i = 0; i < V; i++) {
                    map[res[i]] = i;
                }
                for (int i = 0; i < V; i++) {
                    for (int v : list.get(i)) {
                        if (map[i] > map[v]) return false;
                    }
                }
                return true;
            }
        }
// } Driver Code Ends


        /*Complete the function below*/

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
        class Solution {
            static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
                vis[node] = 1;
                for(Integer it: adj.get(node)) {
                    if(vis[it] == 0) {
                        findTopoSort(it, vis, adj, st);
                    }
                }
                st.push(node);
            }
            static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
                Stack<Integer> st = new Stack<Integer>();
                int vis[] = new int[N];

                for(int i = 0;i<N;i++) {
                    if(vis[i] == 0) {
                        findTopoSort(i, vis, adj, st);
                    }
                }

                int topo[] = new int[N];
                int ind = 0;
                while(!st.isEmpty()) {
                    topo[ind++] = st.pop();
                }
                // for(int i = 0;i<N;i++) System.out.println(topo[i] + " ");
                return topo;
            }
        }
}

 */
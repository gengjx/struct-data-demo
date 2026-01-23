package com.struct.practice;

import java.util.*;

/**
 * 图算法练习
 * 练习内容：
 * 1. 图的表示（邻接矩阵、邻接表）
 * 2. 深度优先搜索（DFS）
 * 3. 广度优先搜索（BFS）
 * 4. 最短路径（Dijkstra、Floyd）
 * 5. 最小生成树（Prim、Kruskal）
 * 6. 拓扑排序
 */
public class GraphAlgorithmPractice {

    /**
     * 练习1：图的邻接表表示
     */
    public static class Graph {
        private int vertices;
        private List<List<Integer>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // TODO: 添加边（无向图）
        public void addEdge(int src, int dest) {
            // 在src的邻接表中添加dest
            // 在dest的邻接表中添加src（无向图）
        }

        // TODO: 添加边（有向图）
        public void addDirectedEdge(int src, int dest) {
            // 只在src的邻接表中添加dest
        }

        public int getVertices() {
            return vertices;
        }

        public List<Integer> getNeighbors(int vertex) {
            return adjList.get(vertex);
        }
    }

    /**
     * 练习2：深度优先搜索（DFS）递归
     */
    public static void dfsRecursive(Graph graph, int start) {
        boolean[] visited = new boolean[graph.getVertices()];
        dfsRecursive(graph, start, visited);
    }

    private static void dfsRecursive(Graph graph, int vertex, boolean[] visited) {
        // TODO: 实现DFS递归
        // 1. 标记当前节点为已访问
        // 2. 访问当前节点（打印或处理）
        // 3. 递归访问所有未访问的邻居节点
    }

    /**
     * 练习3：深度优先搜索（DFS）迭代
     */
    public static void dfsIterative(Graph graph, int start) {
        // TODO: 实现DFS迭代
        // 1. 使用栈存储待访问节点
        // 2. 将起始节点入栈
        // 3. 当栈不为空时：
        //    - 弹出栈顶节点
        //    - 如果未访问，标记为已访问并处理
        //    - 将所有未访问的邻居入栈
    }

    /**
     * 练习4：广度优先搜索（BFS）
     */
    public static void bfs(Graph graph, int start) {
        // TODO: 实现BFS
        // 1. 使用队列存储待访问节点
        // 2. 将起始节点入队并标记为已访问
        // 3. 当队列不为空时：
        //    - 出队一个节点并处理
        //    - 将所有未访问的邻居入队并标记为已访问
    }

    /**
     * 练习5：Dijkstra最短路径算法
     * 任务：找到单源最短路径
     */
    public static int[] dijkstra(Graph graph, int start) {
        // TODO: 实现Dijkstra算法
        // 1. 初始化距离数组dist[]，dist[start] = 0，其他为无穷大
        // 2. 创建优先队列（最小堆），存储(距离, 节点)
        // 3. 将起始节点入队
        // 4. 当队列不为空时：
        //    - 取出距离最小的节点u
        //    - 如果u已被访问，跳过
        //    - 标记u为已访问
        //    - 更新u的所有邻居的距离
        // 5. 返回距离数组
        
        // 注意：这里需要带权图，需要修改Graph类支持权重
        return new int[graph.getVertices()];
    }

    /**
     * 练习6：Floyd最短路径算法
     * 任务：找到所有节点对之间的最短路径
     */
    public static int[][] floyd(int[][] graph) {
        // TODO: 实现Floyd算法
        // graph[i][j]表示节点i到节点j的距离，如果不可达则为无穷大
        // 1. 初始化距离矩阵dist = graph
        // 2. 三重循环：k, i, j
        //    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        // 3. 返回dist矩阵
        return new int[graph.length][graph.length];
    }

    /**
     * 练习7：Prim最小生成树算法
     * 任务：找到连通图的最小生成树
     */
    public static int primMST(int[][] graph) {
        // TODO: 实现Prim算法
        // graph[i][j]表示节点i到节点j的权重
        // 1. 选择任意起始节点
        // 2. 初始化：已访问节点集合，未访问节点集合
        // 3. 重复以下步骤直到所有节点都被访问：
        //    - 找到连接已访问和未访问节点的最小权重边
        //    - 将该边加入MST
        //    - 将新节点标记为已访问
        // 4. 返回MST的总权重
        return 0;
    }

    /**
     * 练习8：Kruskal最小生成树算法
     * 任务：使用并查集实现Kruskal算法
     */
    public static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int kruskalMST(List<Edge> edges, int vertices) {
        // TODO: 实现Kruskal算法
        // 1. 对边按权重排序
        // 2. 初始化并查集
        // 3. 遍历排序后的边：
        //    - 如果边的两个节点不在同一集合中，加入MST
        //    - 合并两个节点所在的集合
        // 4. 返回MST的总权重
        return 0;
    }

    /**
     * 练习9：拓扑排序
     * 任务：对有向无环图（DAG）进行拓扑排序
     */
    public static List<Integer> topologicalSort(Graph graph) {
        // TODO: 实现拓扑排序
        // 1. 计算每个节点的入度
        // 2. 将所有入度为0的节点入队
        // 3. 当队列不为空时：
        //    - 出队一个节点并加入结果
        //    - 将该节点的所有邻居的入度减1
        //    - 如果邻居的入度变为0，入队
        // 4. 如果结果包含所有节点，返回结果；否则说明有环
        return new ArrayList<>();
    }

    /**
     * 练习10：检测图中是否有环
     * 任务：检测有向图和无向图中是否存在环
     */
    public static boolean hasCycle(Graph graph) {
        // TODO: 检测有向图中的环
        // 使用DFS，如果遇到已访问的节点（在递归栈中），说明有环
        return false;
    }

    public static boolean hasCycleUndirected(Graph graph) {
        // TODO: 检测无向图中的环
        // 使用DFS，如果遇到已访问的节点且不是父节点，说明有环
        return false;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 图算法练习 ===");
        
        // 创建测试图
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        
        // 测试DFS
        System.out.println("DFS遍历:");
        dfsRecursive(graph, 0);
        
        // 测试BFS
        System.out.println("\nBFS遍历:");
        bfs(graph, 0);
    }
}


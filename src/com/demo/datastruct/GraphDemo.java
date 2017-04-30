package com.demo.datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class GraphDemo {
	public static void main(String[] args) {
		GraphM m=new GraphM();
		int[][] a={{0,1},{1,3},{1,2},{3,2},{2,4},{4,5},{5,0}};
		m.createGraph(a);
		//m.dfs(0);
		System.out.println();
		m.bfs(0);
	}
}

//=======邻接表============

/*
 * 边节点
 */
class ArcNode{
	int adjvex;//连接的节点
	int weight;//权值
	ArcNode next;//指向另一边
}
/*
 * 顶点节点
 */
class VNode{
	int data;//顶点的值
	ArcNode fist;
}

//=======邻接矩阵============

class GraphM{
	
	int[][] m;//图的邻接矩阵
	int n;//边数
	boolean[] visited;
	public void createGraph(int[][] a){
		n=a.length;
		m=new int[a.length][a.length];
		visited= new boolean[n];
		for(int i=0;i<a.length;i++){
//			m[a[i][0]][a[i][1]]=1;  有向图 ,不需要两次赋值，因为矩阵不对称。
			m[a[i][0]][a[i][1]]=1;
		//	m[a[i][1]][a[i][0]]=1;//无向图
		}
	}
	
	//深度优先遍历
	public void dfs(int v){
		visited[v]=true;
		System.out.print(v+" ");
	    for(int i=0;i<n;i++)
	        if(m[v][i]!=0&&m[v][i]!=Integer.MAX_VALUE&&!visited[i])
	            dfs(i);
	}
	//广度优先遍历
	public void bfs(int v){
		 Queue<Integer> temp=new LinkedList<Integer>();
		 System.out.print(v+" ");
		 visited[v]=true;
         temp.offer(v);
         while(!temp.isEmpty()){
        	 int j=temp.poll();
        	 for(int i=0;i<n;i++){
        		 if(m[j][i]!=0&&m[j][i]!=Integer.MAX_VALUE&&!visited[i]){
        			 System.out.print(i+" ");
        			 visited[i]=true;
                     temp.offer(i);
        		 }
        	 }
         }
	}
}
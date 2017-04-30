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

//=======�ڽӱ�============

/*
 * �߽ڵ�
 */
class ArcNode{
	int adjvex;//���ӵĽڵ�
	int weight;//Ȩֵ
	ArcNode next;//ָ����һ��
}
/*
 * ����ڵ�
 */
class VNode{
	int data;//�����ֵ
	ArcNode fist;
}

//=======�ڽӾ���============

class GraphM{
	
	int[][] m;//ͼ���ڽӾ���
	int n;//����
	boolean[] visited;
	public void createGraph(int[][] a){
		n=a.length;
		m=new int[a.length][a.length];
		visited= new boolean[n];
		for(int i=0;i<a.length;i++){
//			m[a[i][0]][a[i][1]]=1;  ����ͼ ,����Ҫ���θ�ֵ����Ϊ���󲻶Գơ�
			m[a[i][0]][a[i][1]]=1;
		//	m[a[i][1]][a[i][0]]=1;//����ͼ
		}
	}
	
	//������ȱ���
	public void dfs(int v){
		visited[v]=true;
		System.out.print(v+" ");
	    for(int i=0;i<n;i++)
	        if(m[v][i]!=0&&m[v][i]!=Integer.MAX_VALUE&&!visited[i])
	            dfs(i);
	}
	//������ȱ���
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
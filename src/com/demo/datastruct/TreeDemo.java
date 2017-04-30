package com.demo.datastruct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的遍历
 * @author Entity
 *
 */
public class TreeDemo {

	
	/*
	 * 递归先序
	 */
	public static void preOrderRecur(Node root){
		if(root==null)
			return;
		System.out.println(root.value);
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	/*
	 * 递归中序
	 */
	public static void inOrderRecur(Node root){
		if(root==null)
			return;
		preOrderRecur(root.left);
		System.out.println(root.value);
		preOrderRecur(root.right);
	}
	/*
	 * 递归先后序
	 */
	public static void posOrderRecur(Node root){
		if(root==null)
			return;
		preOrderRecur(root.left);
		preOrderRecur(root.right);
		System.out.println(root.value);
	}
	
	/*
	 * 非递归先序遍历
	 */
	public static void preOrderUnRecur(Node root){
		if(root!=null){
			Stack<Node> s=new Stack<Node>();
			s.add(root);
			while(!s.isEmpty()){
				root=s.pop();
				System.out.println(root.value);
				if(root.right!=null)
					s.push(root.right);
				if(root.left!=null)
					s.push(root.left);
			}
		}
	}
	/*
	 * 非递归中序遍历
	 */
	public static void inOrderUnRecur(Node root){
		if(root!=null){
			Stack<Node> s=new Stack<Node>();
			while(!s.isEmpty()||root!=null){
				if(root!=null){
					s.push(root);
					root=root.left;
				}
				else{
					root=s.pop();
					System.out.println(root.value);
					root=root.right;
				}
			}
		}
	}
	/*
	 * 非递归后序遍历
	 */
	public static void posOrderUnRecur(Node root){
		if(root!=null){
			Stack<Node> s1=new Stack<Node>();
			Stack<Node> s2=new Stack<Node>();
			s1.push(root);
			while(!s1.isEmpty()){
				root=s1.pop();
				s2.push(root);
				if(root.left!=null)
					s1.push(root.left);
				if(root.right!=null)
					s1.push(root.right);
			}
			while(!s2.isEmpty())
				System.out.println(s1.pop().value);
		}
	}
	
	/*
	 * 先序遍历树的序列化
	 */
	public static String serialByPre(Node root){
		if(root==null)
			return "#!";
		String res=root.value+"!";
		res+=serialByPre(root.left);
		res+=serialByPre(root.right);
		return res;
	}
	/*
	 * 根据先序序列发序列化
	 */
	public static Node reconByPreString(String str){
		String[] values=str.split("!");
		Queue<String> queue=new LinkedList<String>();
		for(int i=0;i!=values.length;i++)
			queue.offer(values[i]);
		return reconPreOrder(queue);
	}
	public static Node reconPreOrder(Queue<String> queue){
		String value=queue.poll();
		if(value.equals("#"))
			return null;
		Node node=new Node(Integer.parseInt(value));
		node.left=reconPreOrder(queue);
		node.right=reconPreOrder(queue);
		return node;
		
	}
}

/*
 * 定义树节点
 */
class Node{
	public int value;
	public Node left;
	public Node right;
	public Node(int value){
		this.value=value;
	}
}

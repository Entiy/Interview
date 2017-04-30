package com.demo.datastruct;

import java.util.Stack;

public class DataDemo {

	public static void main(String[] args) {
		DataDemo demo = new DataDemo();
		// demo.FBNQ();
		// for(int i=0;i<40;i++){
		// System.out.println(demo.Fbi(i));
		// }
		//demo.afterResolveValue("931-3*+82/+".toCharArray());
//		for(int a:demo.getNext("bbcab"))
//			System.out.println(a);
//		System.out.println(kmp("bbbacadacadas","cadas"));
		
		
	}

	// 斐波那契数列,打印前40位(非递归)
	public void FBNQ() {

		int a[] = new int[40];
		a[0] = 0;
		a[1] = 1;
		System.out.println(a[0]);
		System.out.println(a[1]);
		for (int i = 2; i < 40; i++) {
			a[i] = a[i - 1] + a[i - 2];
			System.out.println(a[i]);
		}
	}

	// 递归的斐波那契数列
	public int Fbi(int i) {
		if (i < 2)
			return i == 0 ? 0 : 1;
		return Fbi(i - 1) + Fbi(i - 2);
	}

	// 后缀表达式求值
	public void afterResolveValue(char a[]) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= '0' && a[i] <= '9') {
				stack.push(a[i] - '0');
			} else {
				int x = stack.pop();
				int y = stack.pop();
				switch (a[i]) {
				case '+':
					stack.push(x + y);
					break;
				case '-':
					stack.push(y - x);
					break;
				case '*':
					stack.push(x * y);
					break;
				case '/':
					stack.push(y / x);
					break; // 暂不做检查
				}
			}
		}
		System.out.println(stack.pop());// 暂不做检查
	}

	// KMP 求next数组
	public static int[] getNext(String sub) {
		char[] t = sub.toCharArray();
		int[] next = new int[t.length];
		next[0] = -1;
		int i = 0;
		int j = -1;
		while (i < t.length - 1) {
			if (j == -1 || t[i] == t[j]) {
				i++;
				j++;
				if (t[i] != t[j]) {
					next[i] = j;
				} else {
					next[i] = next[j];
				}
			} else {
				j = next[j];
			}
		}
		return next;
	}
	//优化之后的kmp算法 O(n+m)
	public static int kmp(String ss, String tt) {  

        int[] next = getNext(tt);  
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; // 返回模式串在主串中的头下标  
    }  

	
}

/*
 * 二叉树
 */
class BTree {

	class BNode {
		char data;// 数据域
		BNode lchild;// 左孩子
		BNode rchild;// 右孩子

		public BNode(char data) {
			this.lchild = null;
			this.rchild = null;
			this.data = data;
		}
	}
	static int i = 0;
	static char[] data = null;
	static BNode root=null;
	public BNode createBTree() {
		if (data[i] == '#') {
			return null;
		} else {
			BNode node = new BNode(data[i++]);
			node.lchild = createBTree();
			node.rchild = createBTree();
			return node;
		}

	}
	
	public void frontTraverse(BNode root) {
	        if (root == null) {
	            return;
	        }
	        System.out.print(root.data);
	        frontTraverse(root.lchild);
	        frontTraverse(root.rchild);
	    }

}
package com.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListDemo {

	// 给定链表进行深度拷贝
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode tmp = head;
		RandomListNode headCopy = new RandomListNode(head.label);
		RandomListNode copy = headCopy;
		while (tmp.next != null) {
			copy.next = new RandomListNode(tmp.next.label);
			tmp = tmp.next;
			copy = copy.next;
		}

		tmp = head;
		copy = headCopy;
		headCopy.random = head.random;
		while (tmp.next != null) {
			copy.next.random = tmp.next.random;
			tmp = tmp.next;
			copy = copy.next;
		}
		return headCopy;
	}

	// 给定数组，每个数都出现3次，其中一个只出现一次，求只出现一次的数
	public int singleNumber(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i] == A[j])
					sum++;
			}
			if (sum != 3)
				return A[i];
			sum = 0;
		}

		return 0;

		// int result=0;
		// for(int i=0;i<32;i++){
		// int bits=0;
		// for(int j=0;j<A.length;j++)
		// bits+=(A[j]>>>i)&1;
		// result|=(bits%3)<<i;
		// }
		// return result;
	}

	// 根据排好序的链表创建平衡BST
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(Integer.valueOf(head.val));
			head = head.next;
		}
		return getBST(0, list.size() - 1, list);
	}

	public TreeNode getBST(int low, int high, List list) {
		if (low <= high) {
			int mid = (low + high + 1) / 2;
			TreeNode root = new TreeNode((int) list.get(mid));
			root.left = getBST(low, mid - 1, list);
			root.right = getBST(mid + 1, high, list);
			return root;
		} else
			return null;

	}

	// 链表排序
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		return mergeList(sortList(head), sortList(midNext));

	}

	// 合并两个有序链表
	public ListNode mergeList(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return head1 == null ? head2 : head1;
		ListNode head = head1.val < head2.val ? head1 : head2;
		ListNode c1 = head == head1 ? head1 : head2;
		ListNode c2 = head == head1 ? head2 : head1;
		ListNode pre = null;
		ListNode tmp = null;
		while (c1 != null && c2 != null) {
			if (c2.val >= c1.val) {
				pre = c1;
				c1 = c1.next;
			} else {
				tmp = c2.next;
				pre.next = c2;
				c2.next = c1;
				pre = c2;
				c2 = tmp;
			}
		}
		pre.next = c1 == null ? c2 : c1;
		return head;
	}

	// 查找链表的中间节点
	public ListNode findMid(ListNode head) {
		ListNode fast, low;
		fast = low = head;
		while (fast.next != null && fast.next.next != null) {
			low = low.next;
			fast = fast.next.next;
		}
		return low;
	}

	/*
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
	 * L0→Ln→L1→Ln-1→L2→Ln-2→… You must do this in-place without altering the
	 * nodes' values. For example, Given{1,2,3,4}, reorder it to{1,4,2,3}.
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		while (midNext.next != null) {
			ListNode tmp = midNext.next;
			midNext.next = tmp.next;
			tmp.next = mid.next;
			mid.next = tmp;
		}
		midNext = mid.next;
		mid.next = null;
		ListNode h = head;
		while (midNext != null) {
			ListNode tmp = midNext.next;
			midNext.next = h.next;
			h.next = midNext;
			h = midNext.next;
			midNext = tmp;
		}
	}

	// 判断一个链表是否有环
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow, fast;
		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}

	// 如果一个链表有环，找出环开始的节点
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow, fast;
		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return head;
			}
		}
		return null;
	}

	/*
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative. For example: Given1->2->3->4->5->NULLand k =2,
	 * return4->5->1->2->3->NULL.
	 */
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0)
			return head;
		ListNode h = head;
		ListNode last = null;
		int size = 0;
		while (h != null) {
			last = h;
			h = h.next;
			size++;
		}
		if (n >= size && size != 0)
			n %= size;
		if (n == 0)
			return head;
		last.next = head;
		h = head;
		int m = size - n;
		while (m != 0) {
			last = h;
			h = h.next;
			m--;
		}
		last.next = null;
		return h;
	}

	// 合并两个有序链表
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode p1 = l1 == head ? l1 : l2;
		ListNode p2 = l1 == head ? l2 : l1;
		ListNode pre = null;
		while (p2 != null && p1 != null) {
			if (p1.val <= p2.val) {
				pre = p1;
				p1 = p1.next;
			} else {
				pre.next = p2;
				pre = p2;
				p2 = p2.next;
				pre.next = p1;
			}
		}
		pre.next = p1 == null ? p2 : p1;
		return head;
	}

	/*
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass. For example: Given1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return1->4->3->2->5->NULL. Note: Given m, n satisfy the following
	 * condition: 1 ≤ m ≤ n ≤ length of list.
	 * 
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;
		ListNode tmp = new ListNode(0);
		tmp.next = head;
		ListNode p = head, pre = tmp;
		for (int i = 1; i < m; i++) {
			pre = p;
			p = p.next;
		}
		for (int i = 1; i <= n - m; i++) {
			ListNode t = p.next;
			p.next = t.next;
			t.next = pre.next;
			pre.next = t;
		}
		return tmp.next;
	}

	// 删除有序链表中的重复节点
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p, pre;
		pre = head;
		p = head.next;
		while (p != null) {
			if (pre.val == p.val) {
				pre.next = p.next;
				p = pre.next;
			} else {
				pre = p;
				p = p.next;
			}
		}
		return head;
	}

	/*
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x. You should preserve
	 * the original relative order of the nodes in each of the two partitions.
	 * For example, Given1->4->3->2->5->2and x = 3, return1->2->2->4->3->
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		ListNode h1 = new ListNode(0);
		h1.next = head;
		ListNode hCur = h, pre = h1, p = head;
		while (p != null) {
			if (p.val >= x) {
				pre.next = p.next;
				hCur.next = p;
				hCur = p;
				hCur.next = null;
				p = pre.next;
			} else {
				pre = p;
				p = p.next;
			}
		}
		pre.next = h.next;
		return h1.next;
	}

	/*
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list. For example,
	 * Given1->2->3->3->4->4->5, return1->2->5. Given1->1->1->2->3, return2->3.
	 */
	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode cur = h;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val != cur.next.next.val)
				cur = cur.next;
			else {
				ListNode t = cur.next;
				while (t.next != null && t.val == t.next.val)
					t = t.next;
				cur.next = t.next;
			}
		}
		return h.next;
	}

	// 两个排序数组找中位数
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int[] mn = new int[m + n];
		int a = 0, b = 0, i = 0;
		while (a < m && b < n)
			mn[i++] = A[a] < B[b] ? A[a++] : B[b++];
		while (a < m)
			mn[i++] = A[a++];
		while (b < n)
			mn[i++] = B[b++];
		if ((m + n) % 2 == 0)
			return (mn[(m + n) / 2] + mn[(m + n) / 2 - 1]) / 2.0;
		else
			return mn[(m + n) / 2];
	}
	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list. Input:
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return null;
		ListNode p1 = l1, pre = p1;
		ListNode p2 = l2;
		int m = 0, n = 0;
		while (p1 != null && p2 != null) {
			n = p1.val + p2.val + m;
			p1.val = n % 10;
			m = n / 10;
			pre = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		pre.next = (p1 == null ? p2 : p1);
		while (pre.next != null && m != 0) {
			n = pre.next.val + m;
			m = n / 10;
			pre.next.val = n % 10;
			p2 = pre;
			pre = pre.next;
		}
		if (pre.next == null && m != 0)
			pre.next = new ListNode(m);
		return l1;
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return null;
		ListNode h1 = reverseList(l1);
		ListNode h2 = reverseList(l2);
		ListNode c1 = h1, c2 = h2;
		ListNode pre = h1;
		int m = 0;
		while (c1 != null && c2 != null) {
			int c = c1.val + c2.val + m;
			c1.val = c % 10;
			m = c / 10;
			pre = c1;
			c1 = c1.next;
			c2 = c2.next;
		}
		pre.next = (c1 == null ? c2 : c1);
		while (pre.next != null && m != 0) {
			int n = pre.next.val + m;
			m = n / 10;
			pre.next.val = n % 10;
			c2 = pre;
			pre = pre.next;
		}
		if (pre.next == null && m != 0)
			pre.next = new ListNode(m);
		return h1;

	}

	/*
	 * 翻转链表
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode cur = head;
		while (cur.next != null) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = h.next;
			h.next = tmp;
		}
		return h.next;
	}

	/*
	 * 求数组中，连续子序列和的最大值
	 */
	public int subArraySum(int[] m) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m.length; i++) {
			sum += m[i];
			if (max < sum)
				max = sum;
			else if (sum < 0)
				sum = 0;
		}
		return max;
	}

	/*
	 * 求数组中，连续子序列和的最大值,返回子序列下标
	 */
	public ArrayList<Integer> subArraySumIndex(int[] A) {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int start = 0, end = 0, tmp = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (max < sum) {
				start = tmp;
				end = i;
				max = sum;
			}
			if (sum < 0) {
				tmp = i + 1;
				sum = 0;
			}
		}
		list.add(start);
		list.add(end);
		return list;

	}

	/*
	 * 给定K，翻转前K链表
	 */
	public ListNode reverseKIndex(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode next = null, tmp = head, cur = head;
		for (int i = 1; i < k; i++) {
			cur = cur.next;
			if (cur == null)
				return head;
		}
		next = cur.next;
		while (head.next != next) {
			tmp = head.next;
			head.next = tmp.next;
			tmp.next = h.next;
			h.next = tmp;
		}
		return h.next;
	}

	/*
	 * 给定K，以K为一组翻转链表
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode next = null, tmp = head, cur = head;
		for (int i = 1; i < k; i++) {
			cur = cur.next;
			if (cur == null)
				return head;
		}
		next = cur.next;
		while (head.next != next) {
			tmp = head.next;
			head.next = tmp.next;
			tmp.next = h.next;
			h.next = tmp;
		}
		head.next = reverseKGroup(next, k);
		return h.next;
	}

	/*
	 * 合并一组有序数组
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 1)
			return lists.get(0);
		if (lists.size() == 2)
			return mergeTwoLists(lists.get(0), lists.get(1));
		ListNode tmp = null;
		tmp = mergeTwoLists(lists.get(0), lists.get(1));
		for (int i = 2; i < lists.size(); i++) {
			tmp = mergeTwoLists(tmp, lists.get(i));
		}
		return tmp;
	}

	/*
	 * 在一个链表中，从后往前删除第n个数
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 0)
            return head;
        int size = 0;
        ListNode h=new ListNode(0);
        ListNode cur = h;
        h.next=head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        cur = h;
        for (int i = 1; i < size - n; i++)
            cur = cur.next;
        cur.next = cur.next.next;
        return h.next;
	}

	/*
	 * 矩阵的最小路径和
	 */
	public int minPathSum(int[][] m){
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
			return 0;
		int row=m.length;
		int col=m[0].length;
		int[][] dp=new int[row][col];
		dp[0][0]=m[0][0];
		for(int i=1;i<col;i++)
			dp[0][i]=dp[0][i-1]+m[0][i];
		for(int i=1;i<row;i++)
			dp[i][0]=dp[i-1][0]+m[i][0];
		for(int i=1;i<row;i++)
			for(int j=1;j<col;j++)
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
		return dp[row-1][col-1];

	}
	/*
	 * 矩阵的最小路径和,数组压缩法
	 */
	public int minPathSum1(int[][] m){
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
			return 0;
		int more=Math.max(m.length,m[0].length);
		int less=Math.min(m.length,m[0].length);
		boolean rowmore=more==m.length;
		int[] dp=new int[less];
		dp[0]=m[0][0];
		for(int i=1;i<less;i++)
			dp[i]=dp[i-1]+(rowmore?m[0][i]:m[i][0]);
		for(int i=1;i<more;i++){
			dp[0]=dp[0]+(rowmore?m[i][0]:m[0][i]);
			for(int j=1;j<less;j++)
				dp[j]=Math.min(dp[j-1], dp[j])+(rowmore?m[i][j]:m[j][i]);
		}
		return dp[less-1];

	}
	public static void main(String[] args) {
		ListDemo demo = new ListDemo();
		int[] m = { -3, 1, 3, -3, 4 };
		ArrayList list = new ListDemo().subArraySumIndex(m);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
//Program to print the longest path from root node to leaf npde
package labsession.Question2;

import java.util.ArrayList;

class LongestPath{
	//Binary Tree Node
	static class Node
	{
		Node left;
		Node right;
		int data;
	};
	
	//Function to create a new Binary Node
	
	static Node newNode(int data)
	{
		Node temp = new Node();
		
		temp.data = data;
		temp.left = null;
		temp.right = null;
		
		return temp;		
	}
	
	//Function to find and return the longest path
	public static ArrayList<Integer> findLongestPath(Node root)
	{
		//If root is empty means there is no binary tree
		//so return empty vector
		if(root == null)
		{	
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		
		//Recursive call on root.right
		ArrayList<Integer> right = findLongestPath(root.right);
		
		//Recursive call on root.left
		ArrayList<Integer> left = findLongestPath(root.left);
		
		//Comparing the sizes of the two ArrayList 
		//and insert current node accordingly
		if (right.size() < left.size())
		{
			left.add(root.data);
		}
		else 
		{
			right.add(root.data);
		}
		
		//Return the appropriate ArrayList
		return (left.size() > right.size() ? left : right);
	}
	
	//Driver Code
	public static void main(String[] args) 
	{
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		
		ArrayList<Integer> output = findLongestPath(root);
		int size = output.size();
		
		System.out.print(output.get(size - 1));
		for (int i = size - 2; i >= 0; i--) 
		{
			System.out.print("->" + output.get(i));
		}
		
	}
}


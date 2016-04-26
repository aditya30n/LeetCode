/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Using inroder traversal O(n)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack stack = new Stack();
        TreeNode current = root;
        while(current != null){
            stack.add(current);
            current = current.left;
        }
     
        int i =0;
        while(!stack.isEmpty()){
            current = (TreeNode)stack.pop();
            if(++i == k)
                return current.val;
            
            if(current != null)
                current = current.right;
            while(current != null){
                stack.add(current);
                current = current.left;
            }
        }
        return -1;
    }
}


// Using binary Search O(h) h-> height of tree
#include <stdio.h>
#include <stdlib.h>

#define ARRAY_SIZE(arr) sizeof(arr)/sizeof(arr[0])

typedef struct node_t node_t;

/* Binary tree node */
struct node_t
{
	int data;
	int lCount;

	node_t* left;
	node_t* right;
};

/* Iterative insertion
Recursion is least preferred unless we gain something
*/
node_t *insert_node(node_t *root, node_t* node)
{
	/* A crawling pointer */
	node_t *pTraverse = root;
	node_t *currentParent = root;

	// Traverse till appropriate node
	while(pTraverse)
	{
		currentParent = pTraverse;

		if( node->data < pTraverse->data )
		{
			/* We are branching to left subtree
			increment node count */
			pTraverse->lCount++;
			/* left subtree */
			pTraverse = pTraverse->left;
		}
		else
		{
			/* right subtree */
			pTraverse = pTraverse->right;
		}
	}

	/* If the tree is empty, make it as root node */
	if( !root )
	{
		root = node;
	}
	else if( node->data < currentParent->data )
	{
		/* Insert on left side */
		currentParent->left = node;
	}
	else
	{
		/* Insert on right side */
		currentParent->right = node;
	}

	return root;
}

/* Elements are in an array. The function builds binary tree */
node_t* binary_search_tree(node_t *root, int keys[], int const size)
{
	int iterator;
	node_t *new_node = NULL;

	for(iterator = 0; iterator < size; iterator++)
	{
		new_node = (node_t *)malloc( sizeof(node_t) );

		/* initialize */
		new_node->data = keys[iterator];
		new_node->lCount = 0;
		new_node->left = NULL;
		new_node->right = NULL;

		/* insert into BST */
		root = insert_node(root, new_node);
	}

	return root;
}

int k_smallest_element(node_t *root, int k)
{
	int ret = -1;

	if( root )
	{
		/* A crawling pointer */
		node_t *pTraverse = root;

		/* Go to k-th smallest */
		while(pTraverse)
		{
			if( (pTraverse->lCount + 1) == k )
			{
				ret = pTraverse->data;
				break;
			}
			else if( k > pTraverse->lCount )
			{
				/* There are less nodes on left subtree
					Go to right subtree */
				k = k - (pTraverse->lCount + 1);
				pTraverse = pTraverse->right;
			}
			else
			{
				/* The node is on left subtree */
				pTraverse = pTraverse->left;
			}
		}
	}

	return ret;
}

/* Driver program to test above functions */
int main(void)
{
	/* just add elements to test */
	/* NOTE: A sorted array results in skewed tree */
	int ele[] = { 20, 8, 22, 4, 12, 10, 14 };
	int i;
	node_t* root = NULL;

	/* Creating the tree given in the above diagram */
	root = binary_search_tree(root, ele, ARRAY_SIZE(ele));

	/* It should print the sorted array */
	for(i = 1; i <= ARRAY_SIZE(ele); i++)
	{
		printf("\n kth smallest elment for k = %d is %d",
				i, k_smallest_element(root, i));
	}

	getchar();
	return 0;
}

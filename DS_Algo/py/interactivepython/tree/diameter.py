__author__ = 'harshul'
#What is diameter of binary tree?
#A longest path or route between any two nodes in a tree. The path may or may not for through the root.

from interactivepython.basic.tree import Node
from binarytree import tree, pprint, Node

def tree_height(n):
    """Returns height of the tree.
    :param n: node
    """
    if n is None:
        return 0
    return 1 + max(tree_height(n.left), tree_height(n.right))


def tree_diameter(n):
    """Returns diameter of a binary tree.
    :param n: root node of the binary tree

    Algo: O(n2)
        find the height of left subtree
        find the height of right subtree
        find left diameter
        find right diameter
        return the max
    """

    if n is None:
        return 0
    lheight = tree_height(n.left)
    rheight = tree_height(n.right)

    ldiameter = tree_diameter(n.left)
    rdiameter = tree_diameter(n.right)

    return max(lheight+rheight+1, max(ldiameter, rdiameter))

#improving above code by find­ing the height of tree and diam­e­ter in the same iteration.
def tree_diameter_o_n(root):
    d_and_h = []
    leftResult = []
    rightResult = []
    if root is not None:
        leftResult = [tree_diameter_o_n(root.left)]
        rightResult = [tree_diameter_o_n(root.right)]

        height = max(leftResult[0], rightResult[0]) + 1
        rootDiameter = leftResult[0] + rightResult[0] + 1
        finalDiameter = max(leftResult[1], rightResult[1], rootDiameter)

        d_and_h[0] = height
        d_and_h[1] = finalDiameter
    return d_and_h



#testing above code
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.right.right = Node(5)

print(tree_diameter_o_n(root))

#testing with python's binarytree package
random_tree = tree(4, False)
pprint(random_tree)
print(tree_diameter_o_n(random_tree))


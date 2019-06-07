__author__ = 'harshul'

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

#Sample binary tree
def sample_tree():
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(6)
    root.right.right.left = Node(7)
    root.right.right.right = Node(8)
    return root




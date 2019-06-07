__author__ = 'harshul'

from interactivepython.basic.tree import Node
#using python package for binary tree: https://pypi.python.org/pypi/binarytree
from binarytree import tree, pprint, inspect, convert, heapify

mytree = tree(height=2, balanced=True)
#pprint(mytree)

my_list = [5, 4, 6, 3, 1, 2, 7, 8]

# Convert the list into a tree and return its root
my_tree = convert(my_list)
pprint(my_tree)

# Convert the list into a heap and return its root
heapify(my_list)
my_tree = convert(my_list)
pprint(my_tree)

# Convert the tree back to a list
my_list = convert(my_tree)

# Pretty-printing also works on lists
pprint(my_list)


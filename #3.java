// Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

// For example, given the following Node class

// class Node:
//     def __init__(self, val, left=None, right=None):
//         self.val = val
//         self.left = left
//         self.right = right
// The following test should pass:

// node = Node('root', Node('left', Node('left.left')), Node('right'))
// assert deserialize(serialize(node)).left.left.val == 'left.left'
//

[2,3,6]

1

R [6, 18, 36]
S [2, 6, 36]

[ 18, 12 , 6 ]

{

if i=0  R[0] * S[i+1]

if i=L-1  R[i-1] * S[L-1]

    S[i-1] * S[i+1]         }

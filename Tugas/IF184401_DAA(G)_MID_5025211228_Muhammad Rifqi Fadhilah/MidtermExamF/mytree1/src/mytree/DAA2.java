package mytree;

//AVL Tree = Height-Balanced (HB) Tree

public class DAA2 extends DAA1 {

	// 4. isHeightBalanced() [10 points]
	public static boolean isHeightBalanced(MyTree t) {
		if(t.getEmpty()) {
			return true;
		}
		else {
			int rightheight = MyTreeOps.height(t.getRight());
			int leftheight = MyTreeOps.height(t.getLeft());
			if (Math.abs(leftheight - rightheight) <= 1) {
				return (isHeightBalanced(t.getLeft()) && isHeightBalanced(t.getRight()));
			}
			else {
				return false;
			}
		}
	}

	// 5. insertHB() [10 points]
	public static MyTree insertHB(int n, MyTree t) {
		if(t.getEmpty()) {
			return new MyTree(n, new MyTree(), new MyTree());
		}
		
		else if(n < t.getValue()) {
			MyTree value = rebalanceForLeft(new MyTree(t.getValue(),
					insertHB(n, t.getLeft()), t.getRight()));
			return value;
		}
		
		else if ( n > t.getValue()) {
			MyTree value = rebalanceForRight(new MyTree(t.getValue(),
					t.getRight(), insertHB(n, t.getLeft())));
			return value;
		}
		
		else {
			throw new RuntimeException("Error Key");
		}
	}

	// rebalanceForLeft is called when the left subtree of t may have
	// grown taller by one notch.
	// If it is indeed taller than the right subtree by two notches,
	// return a height-balanced version of t using single or double rotations.
	// The subtrees of t are assumed to be already height-balanced and
	// no effort is made to rebalance them.
	//
	// Likewise, for the case of the right subtree -> rebalanceForRight
	// Both rebalanceForLeft & rebalanceForRight will be used by insertHB() and deleteHB()
	// 6. rebalanceForLeft() [15 points]	
	private static MyTree rebalanceForLeft(MyTree t) {
		if(MyTreeOps.height(t.getLeft()) <= (MyTreeOps.height(t.getRight()) + 1)) {
			return t;
		}
		
		else {
			MyTree left = t.getLeft();
			MyTree right = t.getRight();
			MyTree leftleftNode = left.getLeft();
			MyTree leftrightNode = left.getRight();
				if(MyTreeOps.height(leftleftNode) > MyTreeOps.height(right)) {
					return new MyTree(left.getValue(), leftleftNode, new MyTree(t.getValue(),
							leftrightNode, right));
				}
				else {
					return new MyTree(leftrightNode.getValue(), new MyTree(left.getValue(), left.getLeft(), leftrightNode.getLeft()), 
							new MyTree(t.getValue(), leftrightNode.getRight(), t.getRight()));
				}
			}
	}

	// 7. rebalanceForRight() [15 points]	
	private static MyTree rebalanceForRight(MyTree t) {
		if(MyTreeOps.height(t.getRight()) <= (MyTreeOps.height(t.getLeft()) + 1)) {
			return t;
		}
		
		else {
			MyTree left = t.getLeft();
			MyTree right = t.getRight();
			MyTree rightleftNode = right.getLeft();
			MyTree rightrightNode = right.getRight();
				if (MyTreeOps.height(rightrightNode) > MyTreeOps.height(left)) {
					return new MyTree(right.getValue(), new MyTree(t.getValue(), left, rightleftNode), rightrightNode);
				}
				
				else {
					return new MyTree(rightleftNode.getValue(), new MyTree(t.getValue(), t.getLeft(), rightleftNode.getLeft()),
							new MyTree(right.getValue(), rightleftNode.getRight(), right.getRight()));
				}
			}
	}
	
	// 8. deleteHB() [10 points]
	/**
	 * Deletes the value 'x' from the given tree, if it exists, and returns the new
	 * Tree.
	 *
	 * Otherwise, the original tree will be returned.
	 */
	public static MyTree deleteHB(MyTree t, int x) {
		if(t.getEmpty()) {
			return t;
		}
		
		else {
			int value = t.getValue();
			MyTree left = t.getLeft();
			MyTree right = t.getRight();
			if(x > value) {
				MyTree newRight = deleteHB(right, x);
				return rebalanceForLeft(new MyTree(t.getValue(), left, newRight));
			}
			else if(x < value) {
				MyTree newLeft = deleteHB(left, x);
				return rebalanceForRight(new MyTree(t.getValue(), newLeft, right));
			}
			else {
				if(left.getEmpty()) {
					return right;
				}
				else if(right.getEmpty()) {
					return left;
				}
				else {
					int last = max(left);
					return rebalanceForRight(new MyTree(last, deleteHB(left, last), right));
				}
			}
		}
	}

}
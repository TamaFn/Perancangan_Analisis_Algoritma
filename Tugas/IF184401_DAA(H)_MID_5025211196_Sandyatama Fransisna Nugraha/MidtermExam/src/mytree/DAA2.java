package mytree;

// AVL Tree = Height-Balanced (HB) Tree

public class DAA2 extends DAA1 {

	// 4. isHeightBalanced() [10 points]
	public static boolean isHeightBalanced(MyTree t) {
		if (t.getEmpty()) {
			return true;
		}
		else {
			 int leftHeight = MyTreeOps.height(t.getLeft());
	         int rightHeight = MyTreeOps.height(t.getRight());
	         int diff = Math.abs(leftHeight - rightHeight);
	         return diff <= 1 && isHeightBalanced(t.getLeft()) && isHeightBalanced(t.getRight());
		}
	}

	// 5. insertHB() [10 points]
	public static MyTree insertHB(int n, MyTree t) {
		if (t.getEmpty()) {
            return new MyTree(n, emptyTree, emptyTree);
        }
		else if (n < t.getValue()) {
	        t = new MyTree(t.getValue(), insertHB(n, t.getLeft()), t.getRight());
	    } 
		else if (n > t.getValue()) {
	        t = new MyTree(t.getValue(), t.getLeft(), insertHB(n, t.getRight()));
	    }
	        t = rebalanceForLeft(t);
	        t = rebalanceForRight(t);
	    return t;
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
		// Write your codes in here
		if(MyTreeOps.height(t.getLeft()) <= (MyTreeOps.height(t.getRight()) + 1)) {
			return t;
		}
		
		else {
			//Double node is checked
			MyTree leftleftNode = t.getLeft().getLeft();
			MyTree leftrightNode = t.getLeft().getRight();
				if(MyTreeOps.height(leftleftNode) > MyTreeOps.height(t.getRight())) {
					return new MyTree(t.getLeft().getValue(), leftleftNode, new MyTree(t.getValue(),
							leftrightNode, t.getRight()));
				}
				else {
					return new MyTree(leftrightNode.getValue(), new MyTree(t.getLeft().getValue(), t.getLeft().getLeft(), leftrightNode.getLeft()), 
							new MyTree(t.getValue(), leftrightNode.getRight(), t.getRight()));
				}
			}
		
        // Write your codes in here
	}
	
	// 7. rebalanceForRight() [15 points]
	private static MyTree rebalanceForRight(MyTree t) {
		// Write your codes in here
		if(MyTreeOps.height(t.getRight()) <= (MyTreeOps.height(t.getLeft()) + 1)) {
			return t;
		}
		
		else {
	
			MyTree rightleftNode = t.getRight().getLeft();
			MyTree rightrightNode = t.getRight().getRight();
				if (MyTreeOps.height(rightrightNode) > MyTreeOps.height(t.getLeft())) {
					return new MyTree(t.getRight().getValue(), new MyTree(t.getValue(), t.getLeft(), rightleftNode), rightrightNode);
				}
				
				else {
					return new MyTree(rightleftNode.getValue(), new MyTree(t.getValue(), t.getLeft(), rightleftNode.getLeft()),
							new MyTree(t.getRight().getValue(), rightleftNode.getRight(), t.getRight().getRight()));
				}
			}
        // Write your codes in here
	}
	
	// 8. deleteHB() [10 points]
	/**
	 * Deletes the value 'x' from the given tree, if it exists, and returns the new
	 * Tree.
	 *
	 * Otherwise, the original tree will be returned.
	 */
	public static MyTree deleteHB(MyTree t, int x) {
		// Write your codes in here
		if(t.getEmpty()) {
			return t;
		}
		
		else {
			if(x > t.getValue()) {
				MyTree newRight = deleteHB(t.getRight(), x);
				return rebalanceForLeft(new MyTree(t.getValue(), t.getLeft(), newRight));
			}
			else if(x < t.getValue()) {
				MyTree newLeft = deleteHB(t.getLeft(), x);
				return rebalanceForRight(new MyTree(t.getValue(), newLeft, t.getRight()));
			}
			else {
				if(t.getLeft().getEmpty()) {
					return t.getRight();
				}
				else if(t.getRight().getEmpty()) {
					return t.getLeft();
				}
				else {
					int last = max(t.getLeft());
					return rebalanceForRight(new MyTree(last, deleteHB(t.getLeft(), last), t.getRight()));
				}
			}
		}
        // Write your codes in here
	}
	
	
}
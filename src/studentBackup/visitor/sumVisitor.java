package studentBackup.visitor;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class sumVisitor implements Visitor
{

	private static int sum = 0;

	public static int getSum()
	{
		return sum;
	}

	public static void setSum(int sum)
	{
		sumVisitor.sum = sum;
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void visit(BST tree)
	{
		sum = 0;
		getSum(tree.getRoot());
		System.out.println("Sum = " + sum);
	}

	/**
	 * 
	 * @return void
	 */
	private void getSum(Node item)
	{
		if (item == null)
			return;

		getSum(item.getLeft());
		sum = sum + item.getbNumber();
		getSum(item.getRight());
	}
	
	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "Sum = "+ sum;
	}

}

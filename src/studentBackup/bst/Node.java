package studentBackup.bst;

public class Node
{

	private int bNumber;
	private Node left;
	private Node right;

	public int getbNumber()
	{
		return bNumber;
	}

	public void setbNumber(int bNumber)
	{
		this.bNumber = bNumber;
	}

	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}

	public Node(int bNo)
	{
		bNumber = bNo;

	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "value of node is " + getbNumber();
	}

}

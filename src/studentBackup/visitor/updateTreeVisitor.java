package studentBackup.visitor;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class updateTreeVisitor implements Visitor
{
	private int updateValue, cnt = 0;

	public updateTreeVisitor(int value)
	{
		updateValue = value;
	}

	public int getUpdateValue()
	{
		return updateValue;
	}

	public void setUpdateValue(int updateValue)
	{
		this.updateValue = updateValue;
	}

	public int getCnt()
	{
		return cnt;
	}

	public void setCnt(int cnt)
	{
		this.cnt = cnt;
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void visit(BST tree)
	{
		cnt = 0;
		addNo(tree.getRoot(), this.getUpdateValue(), tree);

	}

	/**
	 * 
	 * @return void
	 */
	private void addNo(Node item, int val, BST tree)
	{
		try
		{
			if (item == null)
				return;

			addNo(item.getLeft(), val, tree);
			item.setbNumber(item.getbNumber() + val);
			cnt++;
			tree.setPosition(cnt);
			tree.setValue(item.getbNumber());
			tree.notifyObservers();

			addNo(item.getRight(), val, tree);
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public String toString()
	{
		return "Update Value = "+updateValue;
	}
}

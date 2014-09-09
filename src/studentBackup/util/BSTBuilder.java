package studentBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;

import studentBackup.bst.BST;

public class BSTBuilder
{

	private String fName;
	private BST mainBST;
	private BST backupBST1;
	private BST backupBST2;

	public BSTBuilder(String fileName)
	{
		fName = fileName;
		mainBST = new BST();
		backupBST1 = new BST();
		backupBST2 = new BST();
	}

	public String getfName()
	{
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public BST getMainBST()
	{
		return mainBST;
	}

	public void setMainBST(BST mainBST)
	{
		this.mainBST = mainBST;
	}

	public BST getBackupBST1()
	{
		return backupBST1;
	}

	public void setBackupBST1(BST backupBST1)
	{
		this.backupBST1 = backupBST1;
	}

	public BST getBackupBST2()
	{
		return backupBST2;
	}

	public void setBackupBST2(BST backupBST2)
	{
		this.backupBST2 = backupBST2;
	}

	/**
	 * 
	 * @return void
	 */
	public void buildTree()
	{
		try
		{
			String line;
			BufferedReader br = new BufferedReader(new FileReader(fName));
			while ((line = br.readLine()) != null)
			{
				line = line.trim();
				if (!line.equals(""))
				{
					int val = Integer.parseInt(line);
					mainBST.insert(val);
					backupBST1.insert(val);
					backupBST2.insert(val);
				}
			}
			br.close();
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "Main tree root - " + mainBST.getRoot().getbNumber() + "Backup1 root - " + backupBST1.getRoot().getbNumber()
				+ "Backup2 root - " + backupBST2.getRoot().getbNumber();
	}

}

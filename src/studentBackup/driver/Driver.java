package studentBackup.driver;

import studentBackup.bst.BST;
import studentBackup.observer.Observer;
import studentBackup.observer.Subject;
import studentBackup.util.BSTBuilder;
import studentBackup.visitor.Visitor;
import studentBackup.visitor.sumVisitor;
import studentBackup.visitor.updateTreeVisitor;

public class Driver
{
	public static void main(String[] args)
	{
		try
		{
			String fName = args[0];
			int updateValue = Integer.parseInt(args[1]);
			BSTBuilder treeBuilder = new BSTBuilder(fName);
			treeBuilder.buildTree();
			BST mainTree = treeBuilder.getMainBST();
			BST backup1 = treeBuilder.getBackupBST1();
			BST backup2 = treeBuilder.getBackupBST2();

			System.out.println("Main Tree inorder traversal");
			mainTree.printInorder(mainTree.getRoot());
			System.out.println("\n\nBackup1 inorder traversal");
			backup1.printInorder(backup1.getRoot());
			System.out.println("\n\nBackup2 inorder traversal");
			backup2.printInorder(backup2.getRoot());

			Visitor sumVisit = new sumVisitor();
			Visitor updateVisit = new updateTreeVisitor(updateValue);

			System.out.println("\n\nSum of nodes for main tree");
			mainTree.accept(sumVisit);
			System.out.println("\nSum of nodes for backup1");
			backup1.accept(sumVisit);
			System.out.println("\nSum of nodes for backup2");
			backup2.accept(sumVisit);

			Subject subjectTree = mainTree;
			Observer observer1 = backup1;
			Observer observer2 = backup2;
			subjectTree.registerObserver(observer1);
			subjectTree.registerObserver(observer2);

			mainTree.accept(updateVisit);
			System.out.println("\n*** After Update ***\n");
			System.out.println("Main Tree inorder traversal");
			mainTree.printInorder(mainTree.getRoot());
			System.out.println("\n\nBackup1 inorder traversal");
			backup1.printInorder(backup1.getRoot());
			System.out.println("\n\nBackup2 inorder traversal");
			backup2.printInorder(backup2.getRoot());

			System.out.println("\n\nSum of nodes for main tree");
			mainTree.accept(sumVisit);
			System.out.println("\nSum of nodes for backup1");
			backup1.accept(sumVisit);
			System.out.println("\nSum of nodes for backup2");
			backup2.accept(sumVisit);
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
}

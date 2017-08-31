package com.companyname.exercise;

import com.companyname.exercise.model.OrgTreeItem;
import com.companyname.exercise.model.OrgTreeType;
import com.companyname.exercise.model.TreeNode;

public class OrgTreeValidator {
	
	
	/**
	 * Verify that a tree has a valid structure
	 * The top level is a single company.
	 * The second level is departments. A company can have zero or more departments.
	 * The third level is users. A department can have zero or more users.
	 * Users should not have any children.
	 * 
	 * @param orgTree An organizational tree
	 * @param type
	 * @return
	 */
	public boolean validate(TreeNode<OrgTreeItem> orgTree,OrgTreeType type){
		boolean result = false;
		if(orgTree.getData().getType().equals(type)){
			System.out.println(String.format("Org tree item %s is a %s with %s children",orgTree.getData().getName(),type,orgTree.getChildren().size()));
			if (!orgTree.isLeaf()){
				for(TreeNode<OrgTreeItem> node : orgTree.getChildren()){
					
					if(type.equals(OrgTreeType.COMPANY)){
						result = validate(node,OrgTreeType.DEPARTMENT);
					}else if (type.equals(OrgTreeType.DEPARTMENT)){
						result = validate(node,OrgTreeType.USER);
					}else if (type.equals(OrgTreeType.USER)){
						//Users should be leafs this indicates a user was under another user in the tree so to the isLeaf condition above
						result = false;
						System.out.println("INVALID: user node shouldn't have children");
					}
					
				}
			}else{
				System.out.println(String.format("Org tree item %s is a a leaf",orgTree.getData().getName()));	
				return true;
			}
		}else{
			System.out.println(String.format("INVALID: Org tree item %s should have been %s",orgTree.getData().getName(),type));
		}
		return result;
		
	}
}

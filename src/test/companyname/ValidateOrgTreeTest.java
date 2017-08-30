package test.companyname;

import org.junit.Assert;

import java.util.List;







import org.junit.Test;

import com.companyname.model.Company;
import com.companyname.model.Department;
import com.companyname.model.OrgTreeItem;
import com.companyname.model.OrgTreeType;
import com.companyname.model.TreeNode;
import com.companyname.model.User;
import com.companyname.util.CompanyGenerator;
import com.companyname.util.DepartmentGenerator;
import com.companyname.util.UserGenerator;

public class ValidateOrgTreeTest {

	@Test
	public void testOrgChartValid() {
		//For these random Users identify the distinct companies and then create a valid org chart for each
		List<User> userList = UserGenerator.getRandomListOfUsers(3000);
		
		TreeNode<OrgTreeItem> orgTree;
		
		
		
		Assert.fail("Not yet implemented");
	}
	
	@Test
	/*
	 * Valid Tree
	 * 	company -> dept -> user
	        	-> dept -> user
	        	-> dept -> user
	        	-> dept -> user 
	 * 
	 */
	public void testValidTree(){
		//Good tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		TreeNode<OrgTreeItem> testDept2 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept2.addChild(UserGenerator.getRandomUser(comp,(Department)testDept2.getData()));
		
		TreeNode<OrgTreeItem> testDept3 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept3.addChild(UserGenerator.getRandomUser(comp,(Department)testDept3.getData()));
		
		TreeNode<OrgTreeItem> testDept4 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept4.addChild(UserGenerator.getRandomUser(comp,(Department)testDept4.getData()));
		
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertTrue("Not a valid orgTree",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}
	

	@Test
	/*
	 * Invalid Tree
	 * 	company -> dept -> user
	        	-> dept -> user
	        	-> dept -> user
	        	-> dept -> dept
	 */        
	public void testInvalidTreeNestedDepartment(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		TreeNode<OrgTreeItem> testDept2 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept2.addChild(UserGenerator.getRandomUser(comp,(Department)testDept2.getData()));
		
		TreeNode<OrgTreeItem> testDept3 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept3.addChild(UserGenerator.getRandomUser(comp,(Department)testDept3.getData()));
		
		TreeNode<OrgTreeItem> testDept4 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		//adding a department below a depatment should fail
		testDept4.addChild(DepartmentGenerator.getRandomDepartment(comp));
		
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, epected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}

	@Test
	/*
	 * Invalid Tree
	 * 	company -> dept -> user
	        	-> dept -> user
	        	-> dept -> user
	        	-> dept -> company
	 */     
	public void testInvalidTreeNestedCustomer(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		TreeNode<OrgTreeItem> testDept2 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept2.getData()));
		
		TreeNode<OrgTreeItem> testDept3 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept3.getData()));
		
		TreeNode<OrgTreeItem> testDept4 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		//Adding a company node under the department should fail
		testDept4.addChild(CompanyGenerator.getRandomCompany());
	
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, epected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}

	@Test
	/*
	 * Invalid Tree
	 * 		company -> company
	 */     
	public void testInvalidTreeNestedCustomer2(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		testOrg.addChild(CompanyGenerator.getRandomCompany());
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, epected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}
	
	@Test
	/*
	 * Invalid Tree
	 * 	company -> dept -> user
	        	-> dept -> user
	        	-> dept -> user
	        	-> dept -> user -> user
	 * 
	 */
	public void testInvalidTreeNestedUser(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		TreeNode<OrgTreeItem> testDept2 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept2.addChild(UserGenerator.getRandomUser(comp,(Department)testDept2.getData()));
		
		TreeNode<OrgTreeItem> testDept3 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept3.addChild(UserGenerator.getRandomUser(comp,(Department)testDept3.getData()));
		
		TreeNode<OrgTreeItem> testDept4 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		TreeNode<OrgTreeItem> testUser1 = testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept4.getData()));
		//Adding a user below another user should fail the test
		testUser1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept4.getData()));
		
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, expected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}
	
	@Test
	/*
	 * Invalid Tree
	 * 	company -> dept -> user -> user
	        	-> dept -> user
	        	-> dept -> user
	        	-> dept -> user
	 * 
	 */
	public void testInvalidTreeNestedUser2(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		
		TreeNode<OrgTreeItem> testUser1 = testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		//Adding a user below another user should fail the test
		testUser1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		TreeNode<OrgTreeItem> testDept2 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept2.addChild(UserGenerator.getRandomUser(comp,(Department)testDept2.getData()));
		
		TreeNode<OrgTreeItem> testDept3 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept3.addChild(UserGenerator.getRandomUser(comp,(Department)testDept3.getData()));
		
		TreeNode<OrgTreeItem> testDept4 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		testDept4.addChild(UserGenerator.getRandomUser(comp,(Department)testDept4.getData()));
		
		
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, expected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}
	
	@Test
	/*
	 * Invalid Tree
	 * 	company -> dept -> user -> user -> user
	 * 
	 */
	public void testInvalidTreeNestedUser3(){
		//Bad tree structure
		Company comp = CompanyGenerator.getRandomCompany();
		TreeNode<OrgTreeItem> testOrg = new TreeNode<OrgTreeItem>(comp);
		TreeNode<OrgTreeItem> testDept1 = testOrg.addChild(DepartmentGenerator.getRandomDepartment(comp));
		
		TreeNode<OrgTreeItem> testUser1 = testDept1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		//Adding a user below another user should fail the test
		TreeNode<OrgTreeItem> testUser2 = testUser1.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		TreeNode<OrgTreeItem> testUser3 = testUser2.addChild(UserGenerator.getRandomUser(comp,(Department)testDept1.getData()));
		
		
		
		
		System.out.println(String.format("----Starting test of %s", testOrg.getData().getName()));
		Assert.assertFalse("This is a valid tree, expected a failure",isValidOrgTree(testOrg,OrgTreeType.COMPANY));
	}
	
	
	
	// Verify a treenode and it's subnodes
	// USER parent must be DEPARTMENT
	// DEPARTMENT parent must be COMPANY
	// USERs shoudl have no children
	private boolean isValidOrgTree(TreeNode<OrgTreeItem> orgTree,OrgTreeType type){
		boolean result = false;
		if(orgTree.getData().getType().equals(type)){
			System.out.println(String.format("Org tree item %s is a %s with %s children",orgTree.getData().getName(),type,orgTree.getChildren().size()));
			if (!orgTree.isLeaf()){
				for(TreeNode<OrgTreeItem> node : orgTree.getChildren()){
					
					if(type.equals(OrgTreeType.COMPANY)){
						result = isValidOrgTree(node,OrgTreeType.DEPARTMENT);
					}else if (type.equals(OrgTreeType.DEPARTMENT)){
						result = isValidOrgTree(node,OrgTreeType.USER);
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

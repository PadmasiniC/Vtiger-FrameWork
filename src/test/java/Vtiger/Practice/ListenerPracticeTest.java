package Vtiger.Practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.ListenerImplementation;

@Listeners

public class ListenerPracticeTest  {
	@Test
	public void test1()
	{
		ListenerImplementation li=new ListenerImplementation();
		li.onStart(null);
		
		System.out.println("Demo test");
		
		li.onFinish(null);
	}

}

package com.cTechInfoSys.linkList;

import com.graphbuilder.struc.Stack;

public class StakeClass{
    public static void main(String args[])    {
        Stack mystack1 = new Stack();
        Stack mystack2 = new Stack();
        int x=0;
        /* push some numbers onto the stack */
        for(int i=0; i<10; i++)
        {
        	 mystack1.push(i);
        }
        for(int j=10; j<20; j++)
        {
            mystack2.push(j);
        }
        
        /* pop those numbers off the stack */
        System.out.println("Stack in mystack1 :");
        for(int i=0; i<10; i++)
        {
            System.out.println(mystack1.pop());
        }
        
        System.out.println("Stack in mystack2 :");
        for(int j=10; j<20; j++)
        {
            System.out.println(mystack2.pop());
        }
		
    }
}
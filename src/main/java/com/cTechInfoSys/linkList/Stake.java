package com.cTechInfoSys.linkList;

public class Stake {

    int stackkn[] = new int[10];
    int tos;
    
    /* initialize top-of-stack */
    public Stake() {
        tos = -1;
    }
    
    /* push an item onto the stack */
    int push(int item){
        System.out.println("Ram Namo");
    	if(tos == 9) {
            System.out.println("Stack is full..!!");
        }
        else {
            stackkn[++tos] = item;
            System.out.println("Tos++ : "+tos);
        }
    	return tos;
    }
    
    /* pop an item from the stack */
    int pop()  {
        System.out.println("Tos -- : "+tos);
        return tos < 0? 0 : stackkn[tos--];
    }
}

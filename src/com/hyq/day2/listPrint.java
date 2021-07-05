package com.hyq.day2;

/**
 * @ClassName listPrint
 * @Description TODO  打印单向链表
 * @Author huangyq
 * @Date 2021/2/25 16:31
 * @Version
 **/
public class listPrint {

    public static void main(String[] args) {
        Node n = new Node();
        Node n1=n;
        for(int i=0;i<10;i++){
            n1.value=i;
            n1.nextNode=new Node();
            n1=n1.nextNode;
        }
        Node n2=null;        //考虑空链表的边界条件

        printNodeList(n);

    }

    public static void printNodeList(Node n){
//未考虑空链表
        if(n.nextNode!=null){
            printNodeList(n.nextNode);
        }
            System.out.println(n);

    }
}

class Node{

    public int value;
    public Node nextNode;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


}
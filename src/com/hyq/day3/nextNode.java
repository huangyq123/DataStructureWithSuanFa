package com.hyq.day3;

/**
 * @ClassName nextNode
 * @Description TODO  查找二叉樹下一個節點
 *                    思路：分類討論——如果存在右子樹，直接得到下一節點；如果不存在右子樹，往父節點查找
 * @Author huangyq
 * @Date 2021/2/26 10:02
 * @Version
 **/
public class nextNode {

    public static newTreeNode findNextNode(newTreeNode n){
        if(n==null){
            return null;
        }//邊界條件

        if(n.RightNode!=null){
            newTreeNode t1 = n.RightNode;
            while(t1.LeftNode!=null){
                t1=t1.LeftNode;
            }
            return t1;
        }
        if(n.RightNode==null){
            newTreeNode t2 = n.FatherNode;
//            if(t2==null){
//                return null;
//            }
            //省略
            while(t2!=null){
                if(t2.LeftNode==n){
                    return t2;
                }else if(t2.RightNode==n){
                    n=t2;
                    t2 = t2.FatherNode;
                }
            }
        }
        return null;
    }
}

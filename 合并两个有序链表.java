/**
*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
*/
/**
* 递归
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}




/**
* 合并
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        List<Integer> list = new ArrayList<>();
        while(l1 != null){
          list.add(l1.val);
          l1 = l1.next;

      };
        while(l2 != null){
            list.add(l2.val);
            l2 = l2.next;

        };
        list.sort(Comparator.comparing(Integer::new));
        ListNode head = new ListNode(0);
        for(Integer num: list){
            addByOrder(new ListNode(num),head);                         
        }
        return head.next;

    }

    //有序添加 插入
    public void addByOrder(ListNode heroNode,ListNode head){
        //因为头节点不能动 所以设置一个辅助移动的节点用于找到要添加的位置
        //单链表 要找添加位置的前一个结点 temp是位于添加位置的前一个节点，否则插入不了
        ListNode temp=head;
        boolean flag=false;//标识添加的编号是否存在
        while(true){
            if(temp.next==null){
                //说明temp已经移到链表的最后
                break;
            }
            if(temp.next.val>heroNode.val){//位置找到，就在temp后边添加
                break;
            }else if(temp.next.val==heroNode.val){//说明希望添加的节点的编号已经存在 不可添加
                flag=true;
                break;
            }
            temp=temp.next;//后移 遍历
        }

            heroNode.next=temp.next;
            temp.next=heroNode;

    }
}

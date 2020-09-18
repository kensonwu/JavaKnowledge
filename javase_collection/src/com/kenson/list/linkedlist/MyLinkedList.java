package com.kenson.list.linkedlist;

/**
 * 自己实现一个LinkedList帮助我们更好的理解LinkedList的底层结构
 *
 * @author wuchun
 */
public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public void add(Object obj) {
        Node n = new Node();
        if (first == null) {
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            // 在整个链表中， 这个节点既是first 又是last。所以将n也赋值给last
            last = n;
        } else {
            // 直接往last节点后增加新的节点
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);

            last = n;
        }
        size++;
    }

    public void add(Object obj, int index) {
        Node temp = node(index);
        Node newNode = new Node();
        newNode.obj = obj;
        if (temp != null) {
            Node preNode = temp.previous;
            preNode.next = newNode;
            newNode.previous = preNode;
            newNode.next = temp;
            temp.previous = newNode;
            size++;
        }
    }

    public Object get(int index) {
        // 检查越界
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null) {
            return temp.obj;
        }
        return null;
    }

    public void remove(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null) {
            Node preNode = temp.previous;
            Node nextNode = temp.next;
            temp.previous = nextNode;
            temp.next = preNode;
            size--;
        }

    }

    public int size() {
        return size;
    }

    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            if (index < (size >> 1)) {// 如果size>2
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            } else {
                temp = last;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.previous;
                }
            }
        }
        return temp;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        MyLinkedList list2 = new MyLinkedList();
        list2.add("aaa");
        list2.add("bbb");
        list2.add("ccc");
        list2.add("ddd");
        list2.add("eeee");

        System.out.println(list2.get(2));

    }

}

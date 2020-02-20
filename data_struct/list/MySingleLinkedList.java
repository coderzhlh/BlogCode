package data_struct.list;

import data_struct.common.MyAbstractList;

public class MySingleLinkedList<E> extends MyAbstractList<E> {
    /**
     * 存储数据的节点
     *
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 节点的数据
         */
        E element;
        /**
         * 下个节点的地址(指针)
         */
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

    }

    /**
     * 头结点
     */
    private Node<E> first;

    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        if (index == 0) {
            this.first = new Node<>(e, first);
        } else {
            Node<E> prev = this.node(index - 1);
            prev.next = new Node<>(e, prev.next);
        }
        this.size++;
    }

    @Override
    public E get(int index) {
        return this.node(index).element;
    }

    @Override
    public E set(int index, E e) {
        Node<E> node = this.node(index);
        E temp = node.element;
        node.element = e;
        return temp;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        this.size--;
        return node.element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (e == null && node.element == null) {
                return i;
            } else if (e != null && e.equals(node.element)) {
                return i;
            }
            node = node.next;
        }
        return ELEMENT_NOT_FOUND_INDEX_RESULT;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * 根据索引获取节点
     *
     * @param index 要获取节点的索引值
     * @return 该索引对应的节点
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

}

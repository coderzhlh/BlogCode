package data_struct.list;

import data_struct.common.MyAbstractList;

public class MyArrayList<E> extends MyAbstractList<E> {
    /**
     * 初始化时默认大小
     */
    protected static int DEFAULT_INIT_CAPACITY = 10;
    /**
     * 以数组作为数据的容器
     */
    protected E[] elements;

    /**
     * 构造方法 可以指定数组的默认容量，如果指定的值大于默认值才有效
     *
     * @param capacity 数组的默认容量
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        capacity = capacity < DEFAULT_INIT_CAPACITY ? DEFAULT_INIT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 默认无参构造方法,数组为默认容量
     */
    public MyArrayList() {
        this(DEFAULT_INIT_CAPACITY);
    }

    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        /*
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }*/
        System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
        elements[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E e) {
        rangeCheck(index);
        E temp = elements[index];
        elements[index] = e;
        return temp;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E e = this.elements[index];
        /*
        for(int i=index+1;i<size;i++){
            elements[i-1] = elements[i];
        }
        */
        System.arraycopy(this.elements, index + 1, this.elements, index + 1 - 1, this.size - index + 1);
        this.elements[this.size - 1] = null;
        this.size--;
        this.trim();
        return e;
    }

    @Override
    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND_INDEX_RESULT;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    /**
     * 扩容方法
     *
     * @param capacity 需要的容量大小
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = this.elements.length;
        if (oldCapacity < capacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            /*
            for(int i=0;i<size;i++){
                newElements[i] = elements[i];
            }*/
            System.arraycopy(elements, 0, newElements, 0, size);
            this.elements = newElements;
        }
    }

    /**
     * 缩容方法
     */
    private void trim() {
        int capacity = this.elements.length;
        int newCapacity = capacity >> 1;
        if (this.size >= newCapacity || capacity <= DEFAULT_INIT_CAPACITY) {
            return;
        }
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(this.elements, 0, newElements, 0, this.size);
        elements = newElements;
    }
}

package data_struct.common;

public abstract class MyAbstractList<E> implements MyList<E> {
    /**
     * 元素个数
     */
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != ELEMENT_NOT_FOUND_INDEX_RESULT;
    }

    @Override
    public void add(E e) {
        this.add(size, e);
    }

    /**
     * 判断索引值是否合法
     *
     * @param index 要校验的索引值
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException size " + this.size + ", want " + index);
        }
    }

    /**
     * 添加时校验索引值 此时索引是可以等于size的
     *
     * @param index 要校验的索引值
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException size " + this.size + ", want " + index);
        }
    }
}

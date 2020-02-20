package data_struct.common;

/**
 * 自定义线性表接口
 *
 * @param <E>
 */
public interface MyList<E> {
    /**
     * 元素不存在则返回的索引值
     */
    int ELEMENT_NOT_FOUND_INDEX_RESULT = -1;

    /**
     * 元素数量
     */
    int size();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 是否包含某元素
     *
     * @param e 要查找的元素
     * @return 是否包含该元素
     */
    boolean contains(E e);

    /**
     * 添加元素到末尾
     *
     * @param e 要添加的元素
     */
    void add(E e);

    /**
     * 将元素添加到index位置
     *
     * @param index 要添加的位置
     * @param e     要添加的元素
     */
    void add(int index, E e);

    /**
     * 获取索引位置的元素
     *
     * @param index 要获取的索引值
     * @return 该索引位置上的元素
     */
    E get(int index);

    /**
     * 给对应索引位置的元素赋值
     *
     * @param index 要赋值的索引位置
     * @param e     值
     * @return 该位置上原来的元素
     */
    E set(int index, E e);

    /**
     * 删除对应位置上的索引值
     *
     * @param index 要删除的索引
     * @return 该索引上原来的值
     */
    E remove(int index);

    /**
     * 返回元素对应的索引位置
     *
     * @param e 要获取索引的元素
     * @return 该元素对应的索引值 如不存在 则返回上面定义的常量值
     */
    int indexOf(E e);

    /**
     * 清空
     */
    void clear();
}

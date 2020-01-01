package cn.commdata.cleardatabase.service;


/**
 * 函数式接口
 * @param <T>
 */

@FunctionalInterface
public interface MyPredicate<T> {

    /**
     * 查询结果
     * @param t 范型
     * @return boolean
     */
     boolean query(T t);

}

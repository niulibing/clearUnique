package cn.commdata.cleardatabase.controller;


import java.util.ArrayList;
import java.util.List;

/**
 * 强大的streamAPI
 * 流是什么？
 * 是数据渠道，用于操作数据源（集合、数组等）所生成的元素排序
 * <p>
 * 集合讲的是数据，流讲的是计算
 * <p>
 * 注意：
 * 1。stream自己不会存储元素
 * 2。stream不会改变源对象。相反，他们会返回一个持有结果的新stream
 * 3。stream操作将是延迟执行的。着意味着他们会等到需要结果的时候才执行
 * <p>
 * stream操作的三个步骤
 * <p>
 * 创建stream
 * 一个数据源（如：集合、数组），获取一个流
 * 中间操作
 * 一个中间操作链，对数据源的数据进行处理
 * 终止操组（终端操作）
 * 一个终止操作，执行中间操作链，并产生结果
 *
 *
 * 筛选与切片
 * filter -接收Lambda,从流中排除某些元素
 * limit -截断流，使其元素不超过给定数量
 * skip（n）-跳过元素，返回扔掉流前n个元素的流。若流中元素不足n个，则返回一个空流。与limit（n）互补
 * distinct-筛选，通过流所生成元素的hashcode（）和equals（）去除重复元素
 *
 * 映射
 * map -接收lambda，将元素转换成其他形式或者提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 * flatMap-接收一个函数作为参数，将流中的每个值都替换成另一个流，然后把所有流连接成一个流
 *
 *
 * 排序
 * sorted（）-自然排序
 * sorted（compartor com）-定制排序
 *
 * 终止操作
 *
 * 查找与匹配
 * allMatch- 检查是否匹配所有元素
 * anyMatch-检查是否至少匹配一个元素
 * noneMatch-检查是否没有匹配所有元素
 * findFirst-返回第一个元素
 * findAny-返回当前流中的任意元素
 * count-返回流中元素的总个数
 * max-返回流中最大值
 * min-返回流中最小值
 */
public class StreamAPI {

    //1.创建stream


    public static void main(String[] args) {


        List<Double> objects = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            objects.add(Math.random()*1000);
        }


    }

}

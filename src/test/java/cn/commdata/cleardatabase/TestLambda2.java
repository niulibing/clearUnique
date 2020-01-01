package cn.commdata.cleardatabase;


import org.junit.jupiter.api.Test;
import org.omg.CORBA.SetOverrideType;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * yi,lambda 表达式基础语法    "->" 该操作符称为箭头操作符或者Lambda操作符 ，箭头操作符将lambda表达式拆分为两部分
 * <p>
 * 左侧：lambda表达式的参数列表
 * 右侧：lambda表达式中所要执行的功能，即lambda体
 * <p>
 * 语法格式一： 无参数，无返回值
 * ()->System.out.println("hello Lambda");
 * <p>
 * 语法格式二：有一个参数，无返回值
 * (x)-> System.out.println(x)
 * 语法格式三：若有一个参数，小括号可以不写
 * <p>
 * 语法格式四：有两个以上的参数，并且lambds体中有多条语句
 * 左右遇一括号省略，左侧推断类型省，能省则省
 *
 * Lambda 表达式需要函数式接口的支持
 */
public class TestLambda2 {

    @Test
    public void test01() {

        //普通实现

        Runnable hello_lambda = new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>>>>hello Lambda<<<<<<<<<");
            }
        };
        hello_lambda.run();

        //lambda实现
        Runnable hello_lambda1 = () -> System.out.println(">>>>>>>>hello Lambda<<<<<<<<<");

        hello_lambda1.run();

    }

    @Test
    public void test02() {

        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("nihao");
    }

    @Test
    public void test03() {

        Comparator<Integer> comparator = Integer::compare;
        int compare = comparator.compare(8, 8);
        System.out.println(compare);


    }


}

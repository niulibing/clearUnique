package cn.commdata.cleardatabase;

import cn.commdata.cleardatabase.model.Employee;
import cn.commdata.cleardatabase.service.MyPredicate;
import cn.commdata.cleardatabase.service.impl.FilterEmployByAge;
import cn.commdata.cleardatabase.service.impl.FilterEmployBySalary;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootTest
class ClearDatabaseApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void getEmployeeList() {

        List<Employee> employees = Arrays.asList(
                new Employee("zhangsan", 12, 4800.99),
                new Employee("lisi", 35, 4900.99),
                new Employee("wangwu", 20, 5800.99),
                new Employee("zhaoqi", 25, 6800.99),
                new Employee("tianba", 45, 7800.99));

        //获取当前公司中员工年龄大于20岁的员工信息

/*        filterEmployeesByDesign(employees, new FilterEmployByAge()).forEach(System.out::println);
        System.out.println(">>>>>>><<<<<<<<<<<<");
        filterEmployeesByDesign(employees, new FilterEmployBySalary()).forEach(System.out::println);
        System.out.println(">>>>>>><<<<<<<<<<<<");

        //获取当前员工中工资大于4000的员工信息

        //优化方式，通过匿名内部类
        //1.通过工资过滤
        filterEmployeesByDesign(employees, new MyPredicate<Employee>() {
            @Override
            public boolean query(Employee employee) {
                return employee.getSalary()>4000;
            }
        }).forEach(System.out::println);*/

        //2。通过lambda表达式优化

        //filterEmployeesByDesign(employees, e->e.getSalary()>4000).forEach(System.out::println);
        //4.优化方式 StreamAPI
        employees.stream()
                .filter(e -> e.getSalary() > 4000 && e.getAge() >= 20)
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .limit(2)
                .map(Employee::getName)
                .collect(Collectors.toList()).forEach(System.out::println);


    }


    //通过设计模式优化
    public List<Employee> filterEmployeesByDesign(List<Employee> list, MyPredicate<Employee> em) {

        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (em.query(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }


}

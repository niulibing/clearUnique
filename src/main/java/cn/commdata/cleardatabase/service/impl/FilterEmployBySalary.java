package cn.commdata.cleardatabase.service.impl;

import cn.commdata.cleardatabase.model.Employee;
import cn.commdata.cleardatabase.service.MyPredicate;


/**
 * 通过工资筛选员工信息
 */
public class FilterEmployBySalary implements MyPredicate<Employee> {

    /**
     * 工资
     */
   private static final double SALARY = 4000;


    @Override
    public boolean query(Employee employee) {
        return employee.getSalary() > SALARY;
    }
}

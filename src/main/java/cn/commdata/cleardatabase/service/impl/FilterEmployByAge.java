package cn.commdata.cleardatabase.service.impl;

import cn.commdata.cleardatabase.model.Employee;
import cn.commdata.cleardatabase.service.MyPredicate;


/**
 * 通过年龄筛选员工信息
 */
public class FilterEmployByAge implements MyPredicate<Employee> {

    /**
     * 年龄
     */
    private static final int AGE = 20;

    @Override
    public boolean query(Employee employee) {
        return employee.getAge() > AGE;
    }
}

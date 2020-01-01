package cn.commdata.cleardatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 员工实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 工资
     */
    private double salary;


}

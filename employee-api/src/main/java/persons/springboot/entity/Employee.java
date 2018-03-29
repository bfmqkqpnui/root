package persons.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户表实体映射类
 */
@Entity(name = "t_user")
public class Employee implements Serializable {
    /**
     * 自增长编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    /**
     * 用户编号
     */
    @Column(nullable = false, unique = true)
    private String user_Id;
    /**
     * 用户名字
     */
    @Column(nullable = false)
    private String user_Name;
    /**
     * 出生日期
     */
    @Column(nullable = false)
    private String birthday;
    /**
     * 用户性别
     */
    @Column(nullable = false)
    private String gender;
    /**
     * 用户工资
     */
    @Column(nullable = false)
    private String salary;
    /**
     * 用户奖金
     */
    @Column(nullable = false)
    private String bonus;
    /**
     * 创建日期
     */
    @Column
    private String create_Date;
    /**
     * 创建时间
     */
    @Column
    private String create_Time;
    /**
     * 更新日期
     */
    @Column
    private String update_Date;
    /**
     * 更新时间
     */
    @Column
    private String update_Time;
    /**
     * 用户状态  0:正常  1:冻结  2:注销  3:删除
     */
    @Column
    private String status = "0";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(String create_Date) {
        this.create_Date = create_Date;
    }

    public String getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(String create_Time) {
        this.create_Time = create_Time;
    }

    public String getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(String update_Date) {
        this.update_Date = update_Date;
    }

    public String getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(String update_Time) {
        this.update_Time = update_Time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

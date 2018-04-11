package persons.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import persons.springboot.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeApiMapper {

    @Select("select * from t_user where id = #{id}")
    Employee findById(@Param(value="id") Long id);

    @Select("select * from t_user order by birthday limit #{pageNum},#{pageSize}")
    List<Employee> queryList(@Param(value="pageNum") Long pageNum, @Param(value="pageSize")Long pageSize);
}

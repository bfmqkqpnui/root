package persons.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import persons.springboot.entity.Employee;

@Mapper
public interface EmployeeApiMapper {

    @Select("select * from t_user where id = #{id}")
    Employee findById(@Param(value="id") Long id);
}

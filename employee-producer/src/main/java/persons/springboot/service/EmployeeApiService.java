package persons.springboot.service;

import persons.springboot.entity.Employee;
import persons.springboot.vo.ReturnDTO;

import java.util.List;

public interface EmployeeApiService {

    ReturnDTO findEmpById(Long id);

    ReturnDTO addEmps(List<Employee> emps);

    ReturnDTO queryEmps(Long pageNum,Long pageSize);
}

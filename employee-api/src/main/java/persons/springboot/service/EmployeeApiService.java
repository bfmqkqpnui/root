package persons.springboot.service;

import persons.springboot.vo.ReturnDTO;

public interface EmployeeApiService {

    ReturnDTO findEmpById(Long id);
}

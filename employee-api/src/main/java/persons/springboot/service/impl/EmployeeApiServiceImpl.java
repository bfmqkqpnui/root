package persons.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persons.springboot.mapper.EmployeeApiMapper;
import persons.springboot.service.EmployeeApiService;
import persons.springboot.entity.Employee;
import persons.springboot.utils.JsonUtils;
import persons.springboot.vo.EmpVo;
import persons.springboot.vo.ReturnDTO;

import java.io.IOException;

@Service(value = "EmployeeApiService")
public class EmployeeApiServiceImpl implements EmployeeApiService {

    @Autowired
    private EmployeeApiMapper employeeApiMapper;

    @Override
    public ReturnDTO findEmpById(Long id) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        Employee employee = employeeApiMapper.findById(id);
        if (null != employee) {
            dto.setSuccess(true);
            dto.setResCode("200");
            try {
                EmpVo empVo = JsonUtils.jsonString2Bean(JsonUtils.object2JsonString(employee),EmpVo.class);
                System.out.println(empVo);
                if (null != empVo) {
                   dto.setObj(empVo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            dto.setObj(employee);
        }
        return dto;
    }
}

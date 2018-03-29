package persons.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import persons.springboot.service.EmployeeApiService;
import persons.springboot.vo.ReturnDTO;

@RestController
public class EmployeeApiController {
    //日志
    private Logger logger = LoggerFactory.getLogger(EmployeeApiController.class);

    @Autowired
    private EmployeeApiService employeeApiService;

    @GetMapping(value = "/emp/queryById/{id}")
    public ReturnDTO findEmployeeById(@PathVariable("id") Long id) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        try {
            dto = employeeApiService.findEmpById(id);
        } catch (Exception e) {
            logger.error("查询失败:", e);
        }
        return dto;
    }
}

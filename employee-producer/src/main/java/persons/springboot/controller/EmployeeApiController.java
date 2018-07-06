package persons.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persons.springboot.service.EmployeeApiService;
import persons.springboot.utils.CommonUtils;
import persons.springboot.utils.JsonUtils;
import persons.springboot.vo.ReturnDTO;

import java.util.Map;

@RestController
public class EmployeeApiController {
    //日志
    private Logger logger = LoggerFactory.getLogger(EmployeeApiController.class);

    @Autowired
    private EmployeeApiService employeeApiService;

    @GetMapping(value = "/emp/queryById/{id}")
    public ReturnDTO findEmployeeById(@PathVariable("id") Long id) {
        ReturnDTO dto = new ReturnDTO();
        try {
            dto = employeeApiService.findEmpById(id);
        } catch (Exception e) {
            logger.error("查询失败:", e);
        }
        return dto;
    }

    @PostMapping(value = "/emp/queryList")
    public ReturnDTO queryList(@RequestBody Map<String, Object> params) {
        logger.info(JsonUtils.object2JsonString(params));
        ReturnDTO dto = new ReturnDTO();
        if (CommonUtils.isExist(params)) {
            String pageNum = params.get("pageNum") == null ? "" : params.get("pageNum").toString();
            String pageSize = params.get("pageSize") == null ? "" : params.get("pageSize").toString();

            try {
                dto = employeeApiService.queryEmps(Long.valueOf(pageNum), Long.valueOf(pageSize));
            } catch (Exception e) {
                logger.error("查询失败:", e);
            }
        }
        return dto;
    }
}

package persons.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persons.springboot.mapper.EmployeeApiMapper;
import persons.springboot.service.EmployeeApiService;
import persons.springboot.entity.Employee;
import persons.springboot.utils.CommonUtils;
import persons.springboot.utils.JsonUtils;
import persons.springboot.vo.EmpVo;
import persons.springboot.vo.ReturnDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "EmployeeApiService")
public class EmployeeApiServiceImpl implements EmployeeApiService {

    @Autowired
    private EmployeeApiMapper employeeApiMapper;

    /**
     * 用于批处理
     */
    @PersistenceContext
    protected EntityManager em;

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

    @Transactional
    @Override
    public ReturnDTO addEmps(List<Employee> emps) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if (CommonUtils.isExist(emps)) {
            for (int i = 0; i < emps.size(); i++) {
                em.persist(emps.get(i));
                if (i % 30 == 0) {
                    em.flush();
                    em.clear();
                }
            }
            dto.setSuccess(true);
            dto.setResCode("200");
        }

        return dto;
    }

    @Override
    public ReturnDTO queryEmps(Long pageNum, Long pageSize) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if(null != pageNum && null != pageSize){
            pageNum = (pageNum.longValue() - 1) * pageSize.longValue();

            List<Employee> employee = employeeApiMapper.queryList(pageNum,pageSize);
            if (null != employee && employee.size() > 0) {
                dto.setSuccess(true);
                dto.setResCode("200");
                try {
                    List<EmpVo> empVos = new ArrayList<EmpVo>();
                    for(Employee emp : employee){
                        if(null != emp){
                            EmpVo empVo = JsonUtils.jsonString2Bean(JsonUtils.object2JsonString(emp),EmpVo.class);
                            if (null != empVo) {
                                empVos.add(empVo);
                            }
                        }
                    }
                    if(null != empVos && empVos.size() > 0){
                        dto.setObj(empVos);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dto;
    }
}

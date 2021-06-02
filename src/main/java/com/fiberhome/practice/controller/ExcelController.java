package com.fiberhome.practice.controller;



import com.fiberhome.practice.annocation.TableInfos;
import com.fiberhome.practice.domain.Parameter;
import com.fiberhome.practice.service.BaseService;
import com.fiberhome.practice.utils.ExcelUtil;
import com.fiberhome.practice.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/api/excel")
public class ExcelController {
    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);




    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public void exportExcel(@RequestBody Parameter parameter) throws ClassNotFoundException {
        HttpServletResponse response =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        String className="com.fiberhome.practice.domain."+parameter.getEntityName();
        String[]ids=parameter.getIds();
        Class cls=Class.forName(className);
        TableInfos tableInfos=(TableInfos)cls.getAnnotation(TableInfos.class);
        Class<?> serviceClass= tableInfos.serviceClass();
        BaseService service = (BaseService) SpringUtil.getBean(serviceClass);
        List<Object> dataList=service.selectBatch(ids);
        ExcelUtil.writeExcel(response,dataList,cls);
    }

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(@RequestParam(value="file") MultipartFile file,@RequestParam("entityName") String entityName){
            String className="com.fiberhome.practice.domain."+entityName;
        try {
            Class cls=Class.forName(className);
            List<Object> dataList= ExcelUtil.readExcel(cls,file);
             TableInfos tableInfos=(TableInfos)cls.getAnnotation(TableInfos.class);
             Class<?> serviceClass= tableInfos.serviceClass();
             BaseService service = (BaseService) SpringUtil.getBean(serviceClass);
                for (Object object:dataList){
                    service.insert(object);
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

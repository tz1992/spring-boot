package com.fiberhome.practice.controller;



import com.fiberhome.practice.annocation.TableInfos;
import com.fiberhome.practice.service.BaseService;
import com.fiberhome.practice.utils.ExcelUtil;
import com.fiberhome.practice.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping("/api/excel")
public class ExcelController {
    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);



    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public void exportExcel(@RequestBody String data)   {

    }

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(@RequestParam(value="file") MultipartFile file,@RequestParam("entityName") String entityName){
            String className="com.fiberhome.practice."+entityName;
        try {
            Class cls=Class.forName(className);
            List<T> dataList= ExcelUtil.readExcel(cls,file);
             TableInfos tableInfos=(TableInfos)cls.getAnnotation(TableInfos.class);
             Class<?> serviceClass= tableInfos.serviceClass();
             BaseService service = (BaseService) SpringUtil.getBean(serviceClass);
                for (T t:dataList){
                    service.insert(t);
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

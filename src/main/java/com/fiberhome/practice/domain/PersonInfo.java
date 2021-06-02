package com.fiberhome.practice.domain;


import com.fiberhome.practice.annocation.Excel;
import com.fiberhome.practice.annocation.TableInfos;
import com.fiberhome.practice.service.PersonService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableInfos(serviceClass = PersonService.class)
public class PersonInfo{
	private String id;

	@Excel(name="姓名",col = 0)
	private String name;

	@Excel(name="证件类型(必填)",prompt="cerType",required=true,col = 1)
	private String idType;

	@Excel(name="证件号码(必填)",required=true,col = 2)
	private String idNumber;

	@Excel(name="性别",prompt="sex",col = 3)
	private String sex;

	@Excel(name="国籍",prompt="nation",col = 4)
	private String nationality;

	@Excel(name="民族",prompt="native",col = 5)
	private String nation;

}

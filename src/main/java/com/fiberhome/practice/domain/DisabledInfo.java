package com.fiberhome.practice.domain;

import com.fiberhome.practice.annocation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DisabledInfo  {


	private String id;

	@Excel(name="姓名(必填)", required = true)
	private String name;

	@Excel(name="证件号码(必填)", required = true)
	private String idNumber;

	@Excel(name="持证情况",prompt="YES")
	private String holdCertificates;

	@Excel(name="生活自理能力",prompt="ZL")
    private String selfcareAbility;

	@Excel(name="参加社保情况",prompt="YES")
	private String socialSecurityType;

	@Excel(name="残疾证号")
	private String certificatesNumber;

	@Excel(name="残疾类别",prompt="disableType")
	private String disabilityType;

	@Excel(name="残疾等级",prompt="disableRank")
	private String disabilityLevel;





}

package com.fiberhome.practice.domain;

import com.fiberhome.practice.annocation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DisabledInfo  {

	@ApiModelProperty(value="唯一键")
	private String id;

	@Excel(name="姓名(必填)", required = true)
	@ApiModelProperty(value="姓名")
	private String name;

	@Excel(name="证件号码(必填)", required = true)
	@ApiModelProperty(value="证件号码")
	private String idNumber;

	@Excel(name="持证情况",prompt="DM_042")
	@ApiModelProperty(value="持证情况 DM_042")
	private String holdCertificates;

	@Excel(name="生活自理能力",prompt="DM_042")
	@ApiModelProperty(value="生活自理能力 DM_042")
	private String selfcareAbility;

	@Excel(name="参加社保情况",prompt="DM_046")
	@ApiModelProperty(value="参加社保情况 DM_046")
	private String socialSecurityType;

	@Excel(name="联系人姓名")
	@ApiModelProperty(value="联系人姓名")
	private String connectionName;

	@Excel(name="联系人电话")
	@ApiModelProperty(value="联系人电话")
	private String connectionPhone;

	@Excel(name="残疾证号")
	@ApiModelProperty(value="残疾证号")
	private String certificatesNumber;

	@Excel(name="残疾类别",prompt="DM_043")
	@ApiModelProperty(value="残疾类别 DM_043")
	private String disabilityType;

	@Excel(name="残疾等级",prompt="DM_044")
	@ApiModelProperty(value="残疾等级 DM_044")
	private String disabilityLevel;

	@Excel(name="残疾原因",prompt="DM_045")
	@ApiModelProperty(value="致残原因 DM_045")
	private String disabilityReason;

	@Excel(name="残疾时间")
	@ApiModelProperty(value="致残时间")
	private Date disabilityDate;

	@ApiModelProperty(value="是否删除 0否，1 是")
	private String delFlag;

	@ApiModelProperty(value="是否列表 0否，1 是")
	private String displayType;


}

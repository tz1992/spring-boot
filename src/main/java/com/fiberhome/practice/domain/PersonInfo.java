package com.fiberhome.practice.domain;


import com.fiberhome.practice.annocation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PersonInfo{

	@ApiModelProperty(value = "人员id")
	private String id;

	@Excel(name="姓名(必填)",required=true)
	@ApiModelProperty(value = "姓名")
	private String name;

	@Excel(name="证件类型(必填)",prompt="DM_026",required=true)
	@ApiModelProperty(value="证件类型 DM_026")
	private String idType;

	@Excel(name="证件号码(必填)",required=true)
	@ApiModelProperty(value="证件号码")
	private String idNumber;

	@Excel(name="性别",prompt="DM_016")
	@ApiModelProperty(value = "性别 DM_016")
	private String sex;

	@Excel(name="国籍",prompt="DM_017")
	@ApiModelProperty(value="国籍 DM_017")
	private String nationality;

	@Excel(name="民族",prompt="DM_018")
	@ApiModelProperty(value="民族 DM_018")
	private String nation;

	@Excel(name="出生年月")
	@ApiModelProperty(value="出生年月")
	private Date birthday;

	@Excel(name="文化程度",prompt="DM_019")
	@ApiModelProperty(value="文化程度 DM_019")
	private String education;

	@Excel(name="政治面貌",prompt="DM_020")
	@ApiModelProperty(value="政治面貌 DM_020")
	private String politicalStatus;

	@Excel(name="宗教信仰",prompt="DM_022")
	@ApiModelProperty(value="宗教信仰 DM_022")
	private String faithType;

	@Excel(name="所属社区",prompt="DM_080")
	@ApiModelProperty(value="所属社区")
	private String branch;

	@Excel(name="移动电话")
	@ApiModelProperty(value="移动电话")
	private String mobilePhone;

	@Excel(name="固定电话")
	@ApiModelProperty(value="固定电话")
	private String fixedPhone;

	@Excel(name="居民状态",prompt="DM_090")
	@ApiModelProperty(value="居民状态 DM_090")
	private String residentStatus;

	@Excel(name="网格编号")
	@ApiModelProperty(value="网格编号")
	private String gridNumber;

	@Excel(name="是否港澳台胞",prompt="DM_024")
	@ApiModelProperty(value="是否港澳台胞/台属 DM_024")
	private String hongkongMacaoTaiwan;

	@Excel(name="是否归侨/侨眷",prompt="DM_023")
	@ApiModelProperty(value="是否归侨/侨眷 DM_023")
	private String returnedOverseasChinese;

	@Excel(name="是否现(退)役军人",prompt="DM_025")
	@ApiModelProperty(value="是否现(退)役军人 DM_025")
	private String notSoldier;

	@Excel(name="特殊人群种类",prompt="DM_027")
	@ApiModelProperty(value="特殊人群种类 DM_027")
	private String particularType;

	@Excel(name="是否残疾人",prompt="DM_034")
	@ApiModelProperty(value="是否残疾 DM_034")
	private String notDisabled;

	@Excel(name="个人信用信息",prompt="DM_021")
	@ApiModelProperty(value="个人信用信息 DM_021")
	private String creditType;

	@Excel(name="个人信用备注")
	@ApiModelProperty(value="个人信用备注")
	private String creditDetail;
	
	@ApiModelProperty(value="唯一识别证件号")
	private String onlyNumber;

	@ApiModelProperty(value="是否删除 0否，1 是")
	private String delFlag;

	private String totalWholePercent;
	private String totalWholePercentDesc;
	private  String wholePercent;
	private  String wholePercentDesc;

}

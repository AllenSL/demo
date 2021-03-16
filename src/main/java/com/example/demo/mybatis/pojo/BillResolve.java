package com.example.demo.mybatis.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
//@TableName("nt_bill_resolve")
public class BillResolve {

    @TableId(value = "TRANS_NO")
    @Excel(name = "transNo", orderNum = "0", width = 20)
    private Long transNo;

    @Excel(name = "payCode", orderNum = "1")
    private String payCode;

    @Excel(name = "delimitBizType", orderNum = "2")
    private Byte delimitBizType;

    @Excel(name = "budgetLevel", orderNum = "3")
    private Byte budgetLevel;

    @Excel(name = "delimitType", orderNum = "4")
    private Byte delimitType;

    @Excel(name = "delimitFinOrgCode", orderNum = "5")
    private String delimitFinOrgCode;

    @Excel(name = "delimitFinOrgName", orderNum = "6")
    private String delimitFinOrgName;

    @Excel(name = "delimitAdmdivCode", orderNum = "7")
    private String delimitAdmdivCode;

    private String delimitAdmdivName;

    private String batchNo;

    private String delimitDate;

    private String admdivCode;

    private String agencyId;

    private String agencyCode;

    private String agencyName;

    private String nonTaxCode;

    private String nonTaxName;

    private String nonTaxTypeCode;

    private String nonTaxTypeName;

    private BigDecimal delimitAmount;

    private BigDecimal curDelimitAmount;

    private String incExpCode;

    private String incExpName;

    private String payeeName;

    private String payeeAcctNo;

    private String payeeOpbk;

    private String payeeAcctBankNo;

    private Integer year;

    private Long lastVer;

    private Long billTypeId;

    private String bizTypeCode;

    private Byte auditStatus;

    @Excel(name = "创建日期", orderNum = "8", format = "yyyy-MM-dd HH:mm:ss", width = 30)
    private Date auditDate;

    private Date billDate;

    private Byte caculateStatus;

    private String agentOrgCode;

    private Byte recordStatus;

    private String recordDate;

    private Long recordId;

    private Long recordNo;

    private Long delimitBatchNo;

    private Byte sendPlatStatus;

    private String sendMessage;

    private String sendTime;

    //    @Excel(name = "公司LOGO", type = 2 ,width = 40 , height = 30,imageType = 1,orderNum = "9")
    private String propFlag;

    private Byte checkStatus;

}
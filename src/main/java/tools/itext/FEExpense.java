package tools.itext;

import java.io.Serializable;
public class FEExpense implements Serializable {

	private static final long serialVersionUID = 1L;
	private String expenseNo;//报销单编号
	private String type;//报销类型编号
	private String payee;//收款方（F_EB_PAYEE）
	private String proNo;//报销项目编号
	private String proName;//报销单项目名称
	private String proDeptNo;//报销项目归属部门编号
	private String proType;//报销项目类型
	private String expensePerDeptNo;//报销人所属部门编号
	private String expenseBearNo;//费用承担方工号
	private String expenseBearDeptno;//费用承担方所属部门
	private String expenseGoal;//报销目的 （rebs_expense_goal）
	private String invoiceTitle;//发票抬头
	private String paymentMethod;//付款方式(F_EB_PAYMENT_METHOD)
	private String paymentMethodName;//付款方式名称
	private String reportingMatters;//报告事项 (最大240字节)
	private String isJtfxe;//交通费是否定额
	private String isHfqzkq;//是否有行方签字考勤
	private String isAcceptance;//是否验收
	private String totalAmount;//报销总金额
	private String estimateAcceptanceDate;//预计验收时间
	private String state;//报销单状态
	private String expensePerDate;//报销单创建时间
	private String expensePerNo;//报销人
	private String expensePerName;//报销人姓名
	private String updateDate;//修改时间
	private String updateNo;//修改人
	private String cardNo;//报销卡号
	private String isPlatform;//是否平台费用
	private String submitDate;//提交事件
    private String withdrawReason;//撤回原因
    private String isDrop;//是否废弃
    private String voucherNo;//凭证号
    private String remark;//特殊事项说明
    private String exception;//校验预算异常信息
    private String accountBank;//供应商开户行
    private String vendorNum;//供应商编号
    private String vendorName;//供应商名称
	private String accountName;//供应商户名
	private String isWriteOff;//是否冲销
	private String expenseType;//报销单类型
	private String expenseTypeName;//报销单类型名称f_e_expense_type


	//报销单中字典项或员工，部门中文名称
	private String typeName;//报销类型名称
	private String payeeName;//收款方
	private String proDeptName;//报销单项目归属部门名称
	private String expensePerDeptName;//报销人所属部门名称
	private String expenseBearName;//费用承担方名称
	private String expenseBearDeptName;//费用承担方所属部门
	private String expenseGoalName;//报销目的
	private String invoiceTitleName;//发票抬头
	private String isJtfxeName;//交通费是否定额
	private String isHfqzkqName;//是否有行方签字考勤
	private String isAcceptanceName;//是否验收
	private String stateName;//报销单状态
	
	//业务字段
	private String approvalPosition;//当前审批岗位
	private String approvalPositionName;//当前审批岗位
    private String approvalUserNo;//当前审批人
	private String approvalUserName;//当前审批人
	private String stafflevelName;//员工职级
	private String invoiceCount;//管理发票张数
	private String workplaceName;//工作母地
	private String firstTrialUserno;//财务初审人工号
	private String firstTrialUserName;//财务初审人名称
	private String retrialUserno;//财务复审人工号
	private String retrialUserName;//财务复审人
	private String firstreceiver;//领取人-初审
	private String firstreceiverName;//领取人名称-初审
	private String reviewreceiver;//领取人-复审
	private String reviewreceiverName;//领取人名称-复审
	private String listexpenseTypeName;//报销单关联费用类型列表
	private String currentAuditRole;//当前审核岗位
	private String currentAuditRoleName;//当前审核岗位
	private String destroyAmount;//本次核销金额
	private String isWriteOffName;//是否冲销
	
	
	public String getExpenseNo() {
		return expenseNo;
	}
	public void setExpenseNo(String expenseNo) {
		this.expenseNo = expenseNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDeptNo() {
		return proDeptNo;
	}
	public void setProDeptNo(String proDeptNo) {
		this.proDeptNo = proDeptNo;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getExpensePerDeptNo() {
		return expensePerDeptNo;
	}
	public void setExpensePerDeptNo(String expensePerDeptNo) {
		this.expensePerDeptNo = expensePerDeptNo;
	}
	public String getExpenseBearNo() {
		return expenseBearNo;
	}
	public void setExpenseBearNo(String expenseBearNo) {
		this.expenseBearNo = expenseBearNo;
	}
	public String getExpenseBearDeptno() {
		return expenseBearDeptno;
	}
	public void setExpenseBearDeptno(String expenseBearDeptno) {
		this.expenseBearDeptno = expenseBearDeptno;
	}
	public String getExpenseGoal() {
		return expenseGoal;
	}
	public void setExpenseGoal(String expenseGoal) {
		this.expenseGoal = expenseGoal;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getReportingMatters() {
		return reportingMatters;
	}
	public void setReportingMatters(String reportingMatters) {
		this.reportingMatters = reportingMatters;
	}
	public String getIsJtfxe() {
		return isJtfxe;
	}
	public void setIsJtfxe(String isJtfxe) {
		this.isJtfxe = isJtfxe;
	}
	public String getIsHfqzkq() {
		return isHfqzkq;
	}
	public void setIsHfqzkq(String isHfqzkq) {
		this.isHfqzkq = isHfqzkq;
	}
	public String getIsAcceptance() {
		return isAcceptance;
	}
	public void setIsAcceptance(String isAcceptance) {
		this.isAcceptance = isAcceptance;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getEstimateAcceptanceDate() {
		return estimateAcceptanceDate;
	}
	public void setEstimateAcceptanceDate(String estimateAcceptanceDate) {
		this.estimateAcceptanceDate = estimateAcceptanceDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getExpensePerDate() {
		return expensePerDate;
	}
	public void setExpensePerDate(String expensePerDate) {
		this.expensePerDate = expensePerDate;
	}
	public String getExpensePerNo() {
		return expensePerNo;
	}
	public void setExpensePerNo(String expensePerNo) {
		this.expensePerNo = expensePerNo;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateNo() {
		return updateNo;
	}
	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getIsPlatform() {
		return isPlatform;
	}
	public void setIsPlatform(String isPlatform) {
		this.isPlatform = isPlatform;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getWithdrawReason() {
		return withdrawReason;
	}
	public void setWithdrawReason(String withdrawReason) {
		this.withdrawReason = withdrawReason;
	}
	public String getIsDrop() {
		return isDrop;
	}
	public void setIsDrop(String isDrop) {
		this.isDrop = isDrop;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getAccountBank() {
		return accountBank;
	}
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	public String getVendorNum() {
		return vendorNum;
	}
	public void setVendorNum(String vendorNum) {
		this.vendorNum = vendorNum;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getProDeptName() {
		return proDeptName;
	}
	public void setProDeptName(String proDeptName) {
		this.proDeptName = proDeptName;
	}
	public String getExpensePerDeptName() {
		return expensePerDeptName;
	}
	public void setExpensePerDeptName(String expensePerDeptName) {
		this.expensePerDeptName = expensePerDeptName;
	}
	public String getExpenseBearName() {
		return expenseBearName;
	}
	public void setExpenseBearName(String expenseBearName) {
		this.expenseBearName = expenseBearName;
	}
	public String getExpenseBearDeptName() {
		return expenseBearDeptName;
	}
	public void setExpenseBearDeptName(String expenseBearDeptName) {
		this.expenseBearDeptName = expenseBearDeptName;
	}
	public String getExpenseGoalName() {
		return expenseGoalName;
	}
	public void setExpenseGoalName(String expenseGoalName) {
		this.expenseGoalName = expenseGoalName;
	}
	public String getInvoiceTitleName() {
		return invoiceTitleName;
	}
	public void setInvoiceTitleName(String invoiceTitleName) {
		this.invoiceTitleName = invoiceTitleName;
	}
	public String getIsJtfxeName() {
		return isJtfxeName;
	}
	public void setIsJtfxeName(String isJtfxeName) {
		this.isJtfxeName = isJtfxeName;
	}
	public String getIsHfqzkqName() {
		return isHfqzkqName;
	}
	public void setIsHfqzkqName(String isHfqzkqName) {
		this.isHfqzkqName = isHfqzkqName;
	}
	public String getIsAcceptanceName() {
		return isAcceptanceName;
	}
	public void setIsAcceptanceName(String isAcceptanceName) {
		this.isAcceptanceName = isAcceptanceName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getExpensePerName() {
		return expensePerName;
	}
	public void setExpensePerName(String expensePerName) {
		this.expensePerName = expensePerName;
	}
	public String getApprovalPosition() {
		return approvalPosition;
	}
	public void setApprovalPosition(String approvalPosition) {
		this.approvalPosition = approvalPosition;
	}
	public String getApprovalPositionName() {
		return approvalPositionName;
	}
	public void setApprovalPositionName(String approvalPositionName) {
		this.approvalPositionName = approvalPositionName;
	}
	public String getApprovalUserNo() {
		return approvalUserNo;
	}
	public void setApprovalUserNo(String approvalUserNo) {
		this.approvalUserNo = approvalUserNo;
	}
	public String getApprovalUserName() {
		return approvalUserName;
	}
	public void setApprovalUserName(String approvalUserName) {
		this.approvalUserName = approvalUserName;
	}
	public String getStafflevelName() {
		return stafflevelName;
	}
	public void setStafflevelName(String stafflevelName) {
		this.stafflevelName = stafflevelName;
	}
	public String getInvoiceCount() {
		return invoiceCount;
	}
	public void setInvoiceCount(String invoiceCount) {
		this.invoiceCount = invoiceCount;
	}
	public String getWorkplaceName() {
		return workplaceName;
	}
	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}
	public String getFirstTrialUserno() {
		return firstTrialUserno;
	}
	public void setFirstTrialUserno(String firstTrialUserno) {
		this.firstTrialUserno = firstTrialUserno;
	}
	public String getFirstTrialUserName() {
		return firstTrialUserName;
	}
	public void setFirstTrialUserName(String firstTrialUserName) {
		this.firstTrialUserName = firstTrialUserName;
	}
	public String getRetrialUserno() {
		return retrialUserno;
	}
	public void setRetrialUserno(String retrialUserno) {
		this.retrialUserno = retrialUserno;
	}
	public String getRetrialUserName() {
		return retrialUserName;
	}
	public void setRetrialUserName(String retrialUserName) {
		this.retrialUserName = retrialUserName;
	}
	public String getFirstreceiver() {
		return firstreceiver;
	}
	public void setFirstreceiver(String firstreceiver) {
		this.firstreceiver = firstreceiver;
	}
	public String getFirstreceiverName() {
		return firstreceiverName;
	}
	public void setFirstreceiverName(String firstreceiverName) {
		this.firstreceiverName = firstreceiverName;
	}
	public String getReviewreceiver() {
		return reviewreceiver;
	}
	public void setReviewreceiver(String reviewreceiver) {
		this.reviewreceiver = reviewreceiver;
	}
	public String getReviewreceiverName() {
		return reviewreceiverName;
	}
	public void setReviewreceiverName(String reviewreceiverName) {
		this.reviewreceiverName = reviewreceiverName;
	}
	public String getListexpenseTypeName() {
		return listexpenseTypeName;
	}
	public void setListexpenseTypeName(String listexpenseTypeName) {
		this.listexpenseTypeName = listexpenseTypeName;
	}
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getDestroyAmount() {
		return destroyAmount;
	}
	public void setDestroyAmount(String destroyAmount) {
		this.destroyAmount = destroyAmount;
	}
	public String getCurrentAuditRole() {
		return currentAuditRole;
	}
	public void setCurrentAuditRole(String currentAuditRole) {
		this.currentAuditRole = currentAuditRole;
	}
	public String getCurrentAuditRoleName() {
		return currentAuditRoleName;
	}
	public void setCurrentAuditRoleName(String currentAuditRoleName) {
		this.currentAuditRoleName = currentAuditRoleName;
	}
	public String getIsWriteOff() {
		return isWriteOff;
	}
	public void setIsWriteOff(String isWriteOff) {
		this.isWriteOff = isWriteOff;
	}
	public String getIsWriteOffName() {
		return isWriteOffName;
	}
	public void setIsWriteOffName(String isWriteOffName) {
		this.isWriteOffName = isWriteOffName;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	
}

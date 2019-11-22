package tools.itext;

import java.io.Serializable;

/**
 * 报销明细实体类
 * @author chengwh
 */
public class FEExpenseDetailInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 607884729054693311L;

	private String id;//报销单明细表主键
	private String expenseNo;//关联报销单号
	private String expenseType;//费用类型
	private String expenseTypeName;//费用类型名称
	private String noteType;//票据类型
	private String noteTypeName;//票据类型名称
	private String amount;//报销金额
	
	private String offAmount;//冲销扣减金额

	private String offTax;//冲销扣减税额

	private String taxCode;//税码

	private String travelId;//关联行程ID
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpenseNo() {
		return expenseNo;
	}
	public void setExpenseNo(String expenseNo) {
		this.expenseNo = expenseNo;
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
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public String getNoteTypeName() {
		return noteTypeName;
	}
	public void setNoteTypeName(String noteTypeName) {
		this.noteTypeName = noteTypeName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOffAmount() {
		return offAmount;
	}
	public void setOffAmount(String offAmount) {
		this.offAmount = offAmount;
	}
	public String getOffTax() {
		return offTax;
	}
	public void setOffTax(String offTax) {
		this.offTax = offTax;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getTravelId() {
		return travelId;
	}
	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}
	
	
	
	

}

package tools.itext;

import java.io.Serializable;

public class Opinions implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 审批岗位
	 */
	private String nodeName;

	private String personName;

	private String personId;

	/**
	 * 审批结论
	 */
	private String opinioinResult;

	/**
	 * 审批意见
	 */
	private String opinioinContent;

	/**
	 * 审批时间
	 */
	private String opinioinTime;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getOpinioinResult() {
		return opinioinResult;
	}

	public void setOpinioinResult(String opinioinResult) {
		this.opinioinResult = opinioinResult;
	}

	public String getOpinioinContent() {
		return opinioinContent;
	}

	public void setOpinioinContent(String opinioinContent) {
		this.opinioinContent = opinioinContent;
	}

	public String getOpinioinTime() {
		return opinioinTime;
	}

	public void setOpinioinTime(String opinioinTime) {
		this.opinioinTime = opinioinTime;
	}
}

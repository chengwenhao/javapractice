package demo;

import java.io.Serializable;
import java.util.List;

public class FEInvoiceBillholder implements Serializable{

	private static final long serialVersionUID = -2169076435972709086L;
	
		private String id;//主键ID
		private String billNumber;//票据编号
		private String billclassification;//票据分类
		private String billClassificationName;//票据分类中文名称
		private String invoiceType;//票据类型
		private String invoiceTypeName;//票据类型中文名称
		private String billingDate;//开票日期
		private String createNo;//创建人
		private String createNoName;//创建人名称
		private String createDate;//创建时间
	    private String updateNo;//修改人
	    private String updateNoName;
	    private String updateDate;//修改时间
	    private String isRelatedExepenseNo;//是否已关联报销单
	    private String exepenseState;//关联报销单状态
		private String exepenseNo;//关联报销单号
	    private String exepenseStateName;//关联发票状态中文名称
	    private String totalAmount;//发票总金额
	    private String fileCode;//附件Code
	    private String billholderBackupsId;//关联票小蜜识别ID
	    private String invoiceNumber;//发票号码
	    private String invoiceCode;//发票代码
	    private String reimbursableAmount;//可报销金额
	    private String checkCode;//校验码/验证码
	    private String kind;//发票消费类型
	    private String dataSources;//数据来源
	    private String passengerName;//乘客姓名
	    private String rideDate;//乘车日期
	    private String eticketNumber;//电子客票号码
	    private String fare;//票价
	    private String agentCode;//销售单位代号
	    private String caacDevelopmentFund;//民航发展基金
	    private String fuelSurcharge;//燃油附加费
	    private String issueBy;//填开单位
	    private String mileage;//里程
	    private String timeGeton;///乘车时间/上车时间
	    private String timeGetoff;//下车时间
	    private String entrance;//入口
	    private String exit;//出口
	    private String purchaserName;          //购方名称
	    private String purchaserTaxno;         //购方税号
	    private String purchaserAddressphone;  //购方地址电话
	    private String purchaserBank;          //购方开户行账号
	    private String salesName;              //销方名称
	    private String salesTaxno;             //销方税号
	    private String salesAddressphone;      //销方地址电话
	    private String salesBank;               //销方开户行账号
	    private String pretaxAmount;             //合计金额(不含税)
	    private String totalAx;                 //合计税额 
	    private String remarks;//备注
	    private String machineCode;//机器编码/机打代码
	    private String state;//发票状态
	    private String stationGeton;          //始发站
	    private String stationGetoff;         //终点站
	    private String trainNumber;           //车次
	    private String seller;                //卖方单位/个人
	    private String sellerId;              //卖方单位代码/个人身份证号
	    private String buyer;                 //买方单位/个人
	    private String buyerId;               //买方单位代码/个人身份证号
	    private String companyName;           //二手车市场
	    private String companyTaxId;          //二手车市场纳税人识别号
	    private String licensePlate;          // 车牌号
	    private String registrationNumber;    //登记证号
	    private String carCode;               //车架号/车辆识别代码
	    private String carModel;              //厂牌型号
	    private String province;              //省
	    private String city;                  //市
	    private String machineNumber;         //机打号码
	    private String taxAuthoriti;          //主管税务机关
	    private String taxAuthoritiesCode;    //主管税务机关代码
	    private String carEngineCod;          //发动机号码
	    private String certificateNumber;     //合格证号
	    private String tax;                   //税额
	    private String taxRate;               //税率
	    private String place;				  //出租车发票所在地
	    private String seat;				  //座位等级
	    private String detailinfocount;		  //关联购物清单条数
	    private String serviceName;			  //服务类型
	    private String isRealname;			  //是否实名（0否1是）
	    private String cause;				  //事由
	    private String isDrop;				  //是否废弃
	    private String inputTaxTurnover;	  //进项税转出额
	    private String photoCategories;		  //其它图片分类
	    private String photoCategoriesName;		  //其它图片分类

	    private List<FEInvoiceBillholder> feinvoicebillholderlist;
//	    private List<FEInvoiceBillholderBackups> FEInvoiceBillholderBackupslist;
//	    private List<FEInvoiceFile> feInvoiceFilelist;
	    
	    //附件信息
	    private String fileId;//附件主键
	    private String modeid;//表模型名称
		private String code;//表模型的主键
		private String filetype;//null
		private String fileSize;//文件大小
	    private String filePath;
	    private String fileName;
	    
	    
	    private String isRealnameName;//是否实名
	    private String isTraffic;//是否交通
	    
	    private String invoiceTypeAndsalesName;
	    private String invoiceRelationstate;
	    private String invoiceRelationstateName;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getBillNumber() {
			return billNumber;
		}
		public void setBillNumber(String billNumber) {
			this.billNumber = billNumber;
		}
		public String getBillClassificationName() {
			return billClassificationName;
		}
		public void setBillClassificationName(String billClassificationName) {
			this.billClassificationName = billClassificationName;
		}
		public String getInvoiceType() {
			return invoiceType;
		}
		public void setInvoiceType(String invoiceType) {
			this.invoiceType = invoiceType;
		}
		public String getInvoiceTypeName() {
			return invoiceTypeName;
		}
		public void setInvoiceTypeName(String invoiceTypeName) {
			this.invoiceTypeName = invoiceTypeName;
		}
		public String getBillingDate() {
			return billingDate;
		}
		public void setBillingDate(String billingDate) {
			this.billingDate = billingDate;
		}
		public String getCreateNo() {
			return createNo;
		}
		public void setCreateNo(String createNo) {
			this.createNo = createNo;
		}
		public String getCreateNoName() {
			return createNoName;
		}
		public void setCreateNoName(String createNoName) {
			this.createNoName = createNoName;
		}
		public String getCreateDate() {
			return createDate;
		}
		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}
		public String getUpdateNo() {
			return updateNo;
		}
		public void setUpdateNo(String updateNo) {
			this.updateNo = updateNo;
		}
		public String getUpdateNoName() {
			return updateNoName;
		}
		public void setUpdateNoName(String updateNoName) {
			this.updateNoName = updateNoName;
		}
		public String getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(String updateDate) {
			this.updateDate = updateDate;
		}
		public String getIsRelatedExepenseNo() {
			return isRelatedExepenseNo;
		}
		public void setIsRelatedExepenseNo(String isRelatedExepenseNo) {
			this.isRelatedExepenseNo = isRelatedExepenseNo;
		}
		public String getExepenseState() {
			return exepenseState;
		}
		public void setExepenseState(String exepenseState) {
			this.exepenseState = exepenseState;
		}
		public String getExepenseNo() {
			return exepenseNo;
		}
		public void setExepenseNo(String exepenseNo) {
			this.exepenseNo = exepenseNo;
		}
		public String getExepenseStateName() {
			return exepenseStateName;
		}
		public void setExepenseStateName(String exepenseStateName) {
			this.exepenseStateName = exepenseStateName;
		}
		public String getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(String totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getFileCode() {
			return fileCode;
		}
		public void setFileCode(String fileCode) {
			this.fileCode = fileCode;
		}
		public String getInvoiceNumber() {
			return invoiceNumber;
		}
		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}
		public String getInvoiceCode() {
			return invoiceCode;
		}
		public void setInvoiceCode(String invoiceCode) {
			this.invoiceCode = invoiceCode;
		}
		public String getReimbursableAmount() {
			return reimbursableAmount;
		}
		public void setReimbursableAmount(String reimbursableAmount) {
			this.reimbursableAmount = reimbursableAmount;
		}
		public String getCheckCode() {
			return checkCode;
		}
		public void setCheckCode(String checkCode) {
			this.checkCode = checkCode;
		}
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public String getDataSources() {
			return dataSources;
		}
		public void setDataSources(String dataSources) {
			this.dataSources = dataSources;
		}
		public String getPassengerName() {
			return passengerName;
		}
		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}
		public String getRideDate() {
			return rideDate;
		}
		public void setRideDate(String rideDate) {
			this.rideDate = rideDate;
		}
		public String getEticketNumber() {
			return eticketNumber;
		}
		public void setEticketNumber(String eticketNumber) {
			this.eticketNumber = eticketNumber;
		}
		public String getFare() {
			return fare;
		}
		public void setFare(String fare) {
			this.fare = fare;
		}
		public String getAgentCode() {
			return agentCode;
		}
		public void setAgentCode(String agentCode) {
			this.agentCode = agentCode;
		}
		public String getCaacDevelopmentFund() {
			return caacDevelopmentFund;
		}
		public void setCaacDevelopmentFund(String caacDevelopmentFund) {
			this.caacDevelopmentFund = caacDevelopmentFund;
		}
		public String getFuelSurcharge() {
			return fuelSurcharge;
		}
		public void setFuelSurcharge(String fuelSurcharge) {
			this.fuelSurcharge = fuelSurcharge;
		}
		public String getIssueBy() {
			return issueBy;
		}
		public void setIssueBy(String issueBy) {
			this.issueBy = issueBy;
		}
		public String getMileage() {
			return mileage;
		}
		public void setMileage(String mileage) {
			this.mileage = mileage;
		}
		public String getTimeGeton() {
			return timeGeton;
		}
		public void setTimeGeton(String timeGeton) {
			this.timeGeton = timeGeton;
		}
		public String getTimeGetoff() {
			return timeGetoff;
		}
		public void setTimeGetoff(String timeGetoff) {
			this.timeGetoff = timeGetoff;
		}
		public String getEntrance() {
			return entrance;
		}
		public void setEntrance(String entrance) {
			this.entrance = entrance;
		}
		public String getExit() {
			return exit;
		}
		public void setExit(String exit) {
			this.exit = exit;
		}
		public String getPurchaserName() {
			return purchaserName;
		}
		public void setPurchaserName(String purchaserName) {
			this.purchaserName = purchaserName;
		}
		public String getPurchaserTaxno() {
			return purchaserTaxno;
		}
		public void setPurchaserTaxno(String purchaserTaxno) {
			this.purchaserTaxno = purchaserTaxno;
		}
		public String getPurchaserAddressphone() {
			return purchaserAddressphone;
		}
		public void setPurchaserAddressphone(String purchaserAddressphone) {
			this.purchaserAddressphone = purchaserAddressphone;
		}
		public String getPurchaserBank() {
			return purchaserBank;
		}
		public void setPurchaserBank(String purchaserBank) {
			this.purchaserBank = purchaserBank;
		}
		public String getSalesName() {
			return salesName;
		}
		public void setSalesName(String salesName) {
			this.salesName = salesName;
		}
		public String getSalesTaxno() {
			return salesTaxno;
		}
		public void setSalesTaxno(String salesTaxno) {
			this.salesTaxno = salesTaxno;
		}
		public String getSalesAddressphone() {
			return salesAddressphone;
		}
		public void setSalesAddressphone(String salesAddressphone) {
			this.salesAddressphone = salesAddressphone;
		}
		public String getSalesBank() {
			return salesBank;
		}
		public void setSalesBank(String salesBank) {
			this.salesBank = salesBank;
		}
		public String getPretaxAmount() {
			return pretaxAmount;
		}
		public void setPretaxAmount(String pretaxAmount) {
			this.pretaxAmount = pretaxAmount;
		}
		public String getTotalAx() {
			return totalAx;
		}
		public void setTotalAx(String totalAx) {
			this.totalAx = totalAx;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		public String getMachineCode() {
			return machineCode;
		}
		public void setMachineCode(String machineCode) {
			this.machineCode = machineCode;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getStationGeton() {
			return stationGeton;
		}
		public void setStationGeton(String stationGeton) {
			this.stationGeton = stationGeton;
		}
		public String getStationGetoff() {
			return stationGetoff;
		}
		public void setStationGetoff(String stationGetoff) {
			this.stationGetoff = stationGetoff;
		}
		public String getTrainNumber() {
			return trainNumber;
		}
		public void setTrainNumber(String trainNumber) {
			this.trainNumber = trainNumber;
		}
		public String getSeller() {
			return seller;
		}
		public void setSeller(String seller) {
			this.seller = seller;
		}
		public String getSellerId() {
			return sellerId;
		}
		public void setSellerId(String sellerId) {
			this.sellerId = sellerId;
		}
		public String getBuyer() {
			return buyer;
		}
		public void setBuyer(String buyer) {
			this.buyer = buyer;
		}
		public String getBuyerId() {
			return buyerId;
		}
		public void setBuyerId(String buyerId) {
			this.buyerId = buyerId;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyTaxId() {
			return companyTaxId;
		}
		public void setCompanyTaxId(String companyTaxId) {
			this.companyTaxId = companyTaxId;
		}
		public String getLicensePlate() {
			return licensePlate;
		}
		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}
		public String getRegistrationNumber() {
			return registrationNumber;
		}
		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}
		public String getCarCode() {
			return carCode;
		}
		public void setCarCode(String carCode) {
			this.carCode = carCode;
		}
		public String getCarModel() {
			return carModel;
		}
		public void setCarModel(String carModel) {
			this.carModel = carModel;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getMachineNumber() {
			return machineNumber;
		}
		public void setMachineNumber(String machineNumber) {
			this.machineNumber = machineNumber;
		}
		public String getTaxAuthoriti() {
			return taxAuthoriti;
		}
		public void setTaxAuthoriti(String taxAuthoriti) {
			this.taxAuthoriti = taxAuthoriti;
		}
		public String getTaxAuthoritiesCode() {
			return taxAuthoritiesCode;
		}
		public void setTaxAuthoritiesCode(String taxAuthoritiesCode) {
			this.taxAuthoritiesCode = taxAuthoritiesCode;
		}
		public String getCarEngineCod() {
			return carEngineCod;
		}
		public void setCarEngineCod(String carEngineCod) {
			this.carEngineCod = carEngineCod;
		}
		public String getCertificateNumber() {
			return certificateNumber;
		}
		public void setCertificateNumber(String certificateNumber) {
			this.certificateNumber = certificateNumber;
		}
		public String getTax() {
			return tax;
		}
		public void setTax(String tax) {
			this.tax = tax;
		}
		public String getTaxRate() {
			return taxRate;
		}
		public void setTaxRate(String taxRate) {
			this.taxRate = taxRate;
		}
		public List<FEInvoiceBillholder> getFeinvoicebillholderlist() {
			return feinvoicebillholderlist;
		}
		public void setFeinvoicebillholderlist(List<FEInvoiceBillholder> feinvoicebillholderlist) {
			this.feinvoicebillholderlist = feinvoicebillholderlist;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getBillclassification() {
			return billclassification;
		}
		public void setBillclassification(String billclassification) {
			this.billclassification = billclassification;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getSeat() {
			return seat;
		}
		public void setSeat(String seat) {
			this.seat = seat;
		}
		public String getDetailinfocount() {
			return detailinfocount;
		}
		public void setDetailinfocount(String detailinfocount) {
			this.detailinfocount = detailinfocount;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public String getIsRealname() {
			return isRealname;
		}
		public void setIsRealname(String isRealname) {
			this.isRealname = isRealname;
		}
		public String getCause() {
			return cause;
		}
		public void setCause(String cause) {
			this.cause = cause;
		}
		public String getIsRealnameName() {
			return isRealnameName;
		}
		public void setIsRealnameName(String isRealnameName) {
			this.isRealnameName = isRealnameName;
		}
		public String getIsDrop() {
			return isDrop;
		}
		public void setIsDrop(String isDrop) {
			this.isDrop = isDrop;
		}
		public String getInputTaxTurnover() {
			return inputTaxTurnover;
		}
		public void setInputTaxTurnover(String inputTaxTurnover) {
			this.inputTaxTurnover = inputTaxTurnover;
		}
		public String getInvoiceTypeAndsalesName() {
			return invoiceTypeAndsalesName;
		}
		public void setInvoiceTypeAndsalesName(String invoiceTypeAndsalesName) {
			this.invoiceTypeAndsalesName = invoiceTypeAndsalesName;
		}
		public String getInvoiceRelationstate() {
			return invoiceRelationstate;
		}
		public void setInvoiceRelationstate(String invoiceRelationstate) {
			this.invoiceRelationstate = invoiceRelationstate;
		}
		public String getInvoiceRelationstateName() {
			return invoiceRelationstateName;
		}
		public void setInvoiceRelationstateName(String invoiceRelationstateName) {
			this.invoiceRelationstateName = invoiceRelationstateName;
		}
		public String getFileId() {
			return fileId;
		}
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
		public String getModeid() {
			return modeid;
		}
		public void setModeid(String modeid) {
			this.modeid = modeid;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getFiletype() {
			return filetype;
		}
		public void setFiletype(String filetype) {
			this.filetype = filetype;
		}
		public String getFileSize() {
			return fileSize;
		}
		public void setFileSize(String fileSize) {
			this.fileSize = fileSize;
		}
		public String getIsTraffic() {
			return isTraffic;
		}
		public void setIsTraffic(String isTraffic) {
			this.isTraffic = isTraffic;
		}
		public String getPhotoCategories() {
			return photoCategories;
		}
		public void setPhotoCategories(String photoCategories) {
			this.photoCategories = photoCategories;
		}
		public String getPhotoCategoriesName() {
			return photoCategoriesName;
		}
		public void setPhotoCategoriesName(String photoCategoriesName) {
			this.photoCategoriesName = photoCategoriesName;
		}

	
} 
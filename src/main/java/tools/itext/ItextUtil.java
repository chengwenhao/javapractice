package tools.itext;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItextUtil {


	//用于计算文档高度
	ThreadLocal<Double> pageHeight = new ThreadLocal<Double>(){
		@Override
		protected Double initialValue() {
			return Double.valueOf("0");
		}
	};

	//字体相关变量 start
	private BaseFont bfChinese;//汉字
	private Font titleFont;//标题字体大小
	private Font font;//
	private Font b_font;
	private Font b_font_13;
	private Font b_font_10;
	//字体相关变量 end




	public static void main(String[] args) throws Exception{
		ItextUtil util = new ItextUtil();
		util.doDownLoadPdf("2019111814020012348");
	}

	public void doDownLoadPdf(String expenseNo) throws Exception {
//		String basePath = req.getSession().getServletContext().getRealPath("/");
		String basePath = "/Users/chengfeng/Desktop/pdf/";
		if(bfChinese == null) {
			synchronized (this) {//初次加载
				if(bfChinese == null) {
					//字体文件路径位置（解决汉字不能显示的问题）
					String fontpath = basePath + "template" + File.separator + "font"+ File.separator + "SIMSUN.TTC";
					bfChinese = BaseFont.createFont(fontpath+",1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					titleFont = new Font(bfChinese,16, Font.BOLD);//标题字体大小
					font = new Font(bfChinese,10);
					b_font = new Font(bfChinese,12, Font.BOLD);
					b_font_13 = new Font(bfChinese,13, Font.BOLD);
					b_font_10 = new Font(bfChinese,10, Font.BOLD);
				}
			}
		}
		//3.生成pdf文件
		byte[] bytes = getPdf(expenseNo,basePath);
		//4.输出下载文件
		OutputStream out= new FileOutputStream(new File("/users/Desktop/generate/aa.pdf"));
		try{
			out.write(bytes);
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out != null) {
				out.close();
			}
		}
	}

	/**
	 * 生成pdf数组
	 * @param expenseNo
	 * @param basePath
	 * @return
	 */
	private byte[] getPdf(String expenseNo,String basePath) {
		ByteArrayOutputStream baos = null;
		Document document= null;
		try {
			//1.根据报销单据号获取报销信息
//			JsonData data = fEExpenseService.queryOne(expenseNo);

//			if(data.getCode() != 0) {
////				logger.error("此报销单编号"+ expenseNo +"不存在报销单！");
////				throw new YusysException("此报销单编号"+ expenseNo +"不存在报销单！");
////			}
//			FEExpense expense = (FEExpense)data.getData();
//			String money = expense.getTotalAmount();//申请报销金额
//			BigDecimal money_b = new BigDecimal(money);
			FEExpense expense = new FEExpense();

			DecimalFormat df1 = new DecimalFormat("#,##0.00");
//			money = df1.format(money_b);

			//获取生成PDF中核心对象
			document = new Document(new Rectangle(PageSize.A4).rotate());
			baos = new ByteArrayOutputStream();
			PdfWriter pdf = PdfWriter.getInstance(document, baos);
			document.open();
			//组装报销头信息
			this.assembleExpenseInfo(document,expense,basePath);
			//获取报销明细列表
//			JsonData data1 = fEExpenseDetailInfoService.queryExpenseDetailList(expenseNo);
//			if(data1.getCode() != 0) {
//				logger.error("获取报销明细失败，生成pdf失败");
//				throw new YusysException("获取报销明细失败，生成pdf失败");
//			}
			@SuppressWarnings("unchecked")
//			List<FEExpenseDetailInfo> expenseDetailList = (List<FEExpenseDetailInfo>)data1.getData();
			//获取审批列表信息
//			List<Opinions> approvalLst = approvalWorkApiService.getLastOpinionsOfPass(ApprovalType.reimbursement,expenseNo);
					List<FEExpenseDetailInfo> expenseDetailList = new ArrayList<FEExpenseDetailInfo>();
			new FEExpenseDetailInfo();
			//test
			Opinions opinions1 = new Opinions();
			opinions1.setNodeName("审批人一");
			opinions1.setPersonName("审批人姓名一");
			opinions1.setOpinioinTime("time一");

			Opinions opinion2 = new Opinions();
			opinion2.setNodeName("审批人二");
			opinion2.setPersonName("审批人姓名二");
			opinion2.setOpinioinTime("time二");

			Opinions opinion3 = new Opinions();
			opinion3.setNodeName("审批人三");
			opinion3.setPersonName("审批人姓名三");
			opinion3.setOpinioinTime("time三");

			List<Opinions> approvalLst = Arrays.asList(opinions1,opinion2,opinion3);
			//test


//			int expenseDetailSize = expenseDetailList.size();
			int approvalSize = approvalLst.size();
			approvalSize = approvalSize > 17 ? 17:approvalSize;

			boolean flag = false;//用于标记是否需要新增一页

			//组装报销明细列表
			this.assembleExpenseDetailTable(expenseDetailList, document, expense,df1);
			int pageCount = (new Double(pageHeight.get() + (approvalSize * 10) )).intValue();
			//如果报销明细加审批列表超过单页最大高度，则新起一页，并在新起的页面中添加报销头信息
			if(pageCount > 297){
				pageHeight.set(0.0);
				flag = true;
				document.newPage();
				this.assembleExpenseInfo(document,expense,basePath);
			}

			if(approvalSize > 0){
				//组装审批和付款列表信息
				if(approvalSize > 17) //如果行数超过17行，则审批列表分为两列
					this.assembleApprovalAndPaymentTable2(document,approvalLst,expense,df1);
				else
					this.assembleApprovalAndPaymentTable(document,approvalLst,expense,df1);
			}
			//组装尾部签名信息
			this.assembleTailSignatureInfo(document,flag);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭文档对象
			document.close();
			//关闭流
			try {
				if(baos != null) {
					baos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return baos.toByteArray();
	}


	/**
	 * 组装尾部签名信息
	 * @param document
	 * @param flag
	 * @throws Exception
	 */
	private void assembleTailSignatureInfo(Document document, boolean flag) throws Exception{
		PdfPTable endtable=new PdfPTable(12);
		if(flag)
			endtable.setSpacingBefore(450 - new Double(pageHeight.get()).intValue());
		else
			endtable.setSpacingBefore(390 - new Double(pageHeight.get()).intValue());
		endtable.setSpacingAfter(0);
		endtable.setWidthPercentage(100);
		endtable.setHorizontalAlignment(Element.ALIGN_BOTTOM);

		AssembleTable(endtable,"初审会计：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);
		AssembleTable(endtable,"复审会计：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);
		AssembleTable(endtable,"财务经理：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);
		AssembleTable(endtable,"财务总监：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);
		AssembleTable(endtable,"CFO：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);
		AssembleTable(endtable,"CEO：",b_font,"R","0",1);
		AssembleTable(endtable," ",font,"R","0",1);

		document.add(endtable);
	}

	/**
	 * 组装审批列表信息
	 * @param document
	 * @param approvalLst
	 * @param expense
	 * @param df
	 */
	private void assembleApprovalAndPaymentTable(Document document,List<Opinions> approvalLst,
	                                             FEExpense expense, DecimalFormat df) throws Exception{
		Paragraph pf = null;
		PdfPTable examineList=new PdfPTable(6);
		examineList.setSpacingBefore(15);
		examineList.setWidthPercentage(100);
		examineList.setHorizontalAlignment(Element.ALIGN_LEFT);

		AssembleTable(examineList,"审批信息",b_font_13,"","1",3);

		AssembleTable(examineList," ",font,"L","0",1);

		AssembleTable(examineList,"付款信息",b_font_13,"","1",2);

		String[] th={"审批人","审批岗位","审批通过时间"};
		for(int i=0;i<th.length;i++){
			pf = new Paragraph(th[i],b_font_10);
			pf.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPCell pc=new PdfPCell(pf);
			pc.setHorizontalAlignment(Element.ALIGN_CENTER);
			pc.setVerticalAlignment(Element.ALIGN_CENTER);
			examineList.addCell(pc);
		}
		//右侧内容
		AssembleTable(examineList," ",font,"","0",1);
		AssembleTable(examineList,"收款人户名：",b_font_10,"R","1",1);
		if("02".equals(expense.getPayee())){//供应商
			String vendorName = expense.getVendorName();
			String accountName = expense.getAccountName();
			AssembleTable(examineList,accountName == null?vendorName:accountName,font,"L","1",1);
		}else{
			AssembleTable(examineList,expense.getExpensePerName(),font,"L","1",1);
		}

		//收款人开户行
		String bank_name = "  ";
		if("02".equals(expense.getPayee())) {//供应商开户行
			bank_name = expense.getAccountBank();
		} else {
			bank_name = "招商银行";
		}
		//付款方式
		String paymentMethodName = expense.getPaymentMethodName() == null?" ":expense.getPaymentMethodName();;

		//收款人卡号
		String card = expense.getCardNo() == null?" ":expense.getCardNo();

		//借款核销金额
		String destroyAmount = (expense.getDestroyAmount() == null || "".equals(expense.getDestroyAmount()))?
				"0.00":df.format(Double.parseDouble(expense.getDestroyAmount()));

		//实际付款金额
		String	real_amount = df.format(Double.parseDouble(expense.getTotalAmount()));

		String [][] fuxx={
				{"付款方式：",paymentMethodName},
				{"收款人开户行：",bank_name},
				{"收款人帐号：",card},
				{"报销金额：",expense.getTotalAmount()},
				{"借款核销金额：",destroyAmount},
				{"实际付款金额：",real_amount}
		};

		for(int i = 1;i < approvalLst.size();i++){
			Opinions opinions = approvalLst.get(i);
			AssembleTable(examineList,"" + opinions.getPersonName(),font,"","1",1);
			AssembleTable(examineList,"" + opinions.getNodeName(),font,"","1",1);
			AssembleTable(examineList,"" + opinions.getOpinioinTime(),font,"","1",1);

			AssembleTable(examineList," ",font,"","0",1);
			if(i > 6){
				AssembleTable(examineList," ",font,"","0",1);
				AssembleTable(examineList," ",font,"","0",1);
			}else{
				AssembleTable(examineList,fuxx[i-1][0],b_font_10,"R","1",1);
				AssembleTable(examineList,fuxx[i-1][1],font,"L","1",1);
			}
		}
		for(int i = approvalLst.size();i <= 6;i++){
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList,fuxx[i-1][0],b_font_10,"R","1",1);
			AssembleTable(examineList,fuxx[i-1][1],font,"L","1",1);
		}

		document.add(examineList);
		pageHeight.set(pageHeight.get() + examineList.getTotalHeight());
	}

	/**
	 * 组装审批列表信息
	 * @param document
	 * @param approvalLst
	 * @param expense
	 * @param df1
	 */
	private void assembleApprovalAndPaymentTable2(Document document,List<Opinions> approvalLst, FEExpense expense,DecimalFormat df1) throws Exception{
		Paragraph pf = null;
		PdfPTable examineList = new PdfPTable(9);
		examineList.setSpacingBefore(15);
		examineList.setWidthPercentage(100);
		examineList.setHorizontalAlignment(Element.ALIGN_LEFT);

		AssembleTable(examineList,"审批信息",b_font_13,"","1",6);

		AssembleTable(examineList," ",font,"L","0",1);

		AssembleTable(examineList,"付款信息",b_font_13,"","1",2);

		String[] th = {"审批人","审批岗位","审批通过时间","审批人","审批岗位","审批通过时间"};
		for(int i=0;i<th.length;i++){
			pf = new Paragraph(th[i],b_font_10);
			pf.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPCell pc=new PdfPCell(pf);
			pc.setHorizontalAlignment(Element.ALIGN_CENTER);
			pc.setVerticalAlignment(Element.ALIGN_CENTER);
			examineList.addCell(pc);
		}
		//右侧内容
		AssembleTable(examineList," ",font,"","0",1);
		AssembleTable(examineList,"收款人户名：",b_font_10,"R","1",1);
		if("02".equals(expense.getPayee())){//供应商
			String vendorName = expense.getVendorName();
			String accountName = expense.getAccountName();
			AssembleTable(examineList,accountName==null?vendorName:accountName,font,"L","1",1);
		}else{
			AssembleTable(examineList,expense.getExpensePerName(),font,"L","1",1);
		}

		//收款人开户行
		String bank_name = "  ";
		if("02".equals(expense.getPayee())) {//供应商开户行
			bank_name = expense.getAccountBank();
		} else {
			bank_name = "招商银行";
		}
		//付款方式
		String paymentMethodName = expense.getPaymentMethodName() == null?" ":expense.getPaymentMethodName();;

		//收款人卡号
		String card = expense.getCardNo() == null?" ":expense.getCardNo();

		//借款核销金额
		String destroyAmount = expense.getDestroyAmount() == null?"   ":expense.getDestroyAmount();
		destroyAmount = df1.format(Double.parseDouble(destroyAmount));

		//实际付款金额
		String real_amount = df1.format(Double.parseDouble(expense.getTotalAmount()));
//		if(real_amount==null) {
//			real_amount = df1.format(Double.parseDouble(expense.getTotalAmount()));
//		}else {
//			real_amount = df1.format(Double.parseDouble(real_amount));
//		}

		String [][] fuxx={
				{"付款方式：",paymentMethodName},
				{"收款人开户行：",bank_name},
				{"收款人帐号：",card},
				{"报销金额：",expense.getTotalAmount()},
				{"借款核销金额：",destroyAmount},
				{"实际付款金额：",real_amount}
		};
		int size = 0;
		if(approvalLst.size() % 2 == 0)
			size = approvalLst.size() / 2;
		else
			size = approvalLst.size() / 2 + 1;

		if(size <= 17) size = 17;
		for(int i = 1;i < size;i++){
			Opinions opinions = approvalLst.get(i);
			AssembleTable(examineList,"" + opinions.getPersonName(),font,"","1",1);
			AssembleTable(examineList,"" + opinions.getNodeName(),font,"","1",1);
			AssembleTable(examineList,"" + opinions.getOpinioinTime(),font,"","1",1);
			int k = i + size - 1;
			if(k < approvalLst.size()){
				Opinions op = approvalLst.get(k);
				AssembleTable(examineList,"" + op.getPersonName(),font,"","1",1);
				AssembleTable(examineList,"" + op.getNodeName(),font,"","1",1);
				AssembleTable(examineList,"" + op.getOpinioinTime(),font,"","1",1);
			}else{
				AssembleTable(examineList," ",font,"","0",1);
				AssembleTable(examineList," ",font,"","0",1);
				AssembleTable(examineList," ",font,"","0",1);
			}

			AssembleTable(examineList," ",font,"","0",1);
			if(i>6){
				AssembleTable(examineList," ",font,"","0",1);
				AssembleTable(examineList," ",font,"","0",1);
			}else{
				AssembleTable(examineList,fuxx[i-1][0],b_font_10,"R","1",1);
				AssembleTable(examineList,fuxx[i-1][1],font,"L","1",1);
			}
		}
		if(approvalLst.size() >= 34 && approvalLst.size() % 2 == 0){
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
			Opinions op = approvalLst.get(approvalLst.size()-1);
			AssembleTable(examineList,"" + op.getPersonName(),font,"","1",1);
			AssembleTable(examineList,"" + op.getNodeName(),font,"","1",1);
			AssembleTable(examineList,"" + op.getOpinioinTime(),font,"","1",1);

			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
			AssembleTable(examineList," ",font,"","0",1);
		}

		document.add(examineList);
		pageHeight.set(pageHeight.get() + examineList.getTotalHeight());
	}

	/**
	 * 组装报销头信息
	 * @param document
	 * @param expense 报销信息
	 * @throws Exception
	 */
	private void assembleExpenseInfo(Document document,FEExpense expense,String basePath) throws Exception{
		File codeFile = null;
		try {
			PdfPTable table = null;
			//生成单据信息表头
			table = new PdfPTable(6);
			table.setSpacingBefore(15);
			table.setWidthPercentage(100);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			this.AssembleTable(table,"费用报销单号：",titleFont,"R","0",1);
			this.AssembleTable(table,expense.getExpenseNo(),titleFont,"L","0",1);
			this.AssembleTable(table,"凭证号："+ expense.getVoucherNo() +"",titleFont,"R","0",1);
			this.AssembleTable(table,expense.getVoucherNo(),titleFont,"L","0",1);
			this.AssembleTable(table,"条码处：",titleFont,"R","0",1);
			//条码生成 start
			//生成的条码文件位置文件夹
//			String codePath = basePath + File.separator + "temp" + File.separator + "code" + File.separator;
			String codePath = "/Users/chengfeng/Desktop/lll/";
			File file = new File(codePath);
			if(!file.exists()) {
				file.mkdirs();
			}
			//生成存储条形码的文件至临时目录
//			codeFile = BarcodeUtil.generateFile(expense.getExpenseNo(), codePath + expense.getExpenseNo() + ".png");

			Image image = Image.getInstance(codePath + expense.getExpenseNo() + ".png");
			//		this.AssembleTable(table,"",titleFont,"L","0",1);
			PdfPCell pc = new PdfPCell(image, true);
			pc.setBorder(0);
			pc.setMinimumHeight(15);
			pc.setHorizontalAlignment(Element.ALIGN_LEFT);
			pc.setVerticalAlignment(Element.ALIGN_LEFT);
			table.addCell(pc);
			//条码生成 end

			//生成基础信息
			table = new PdfPTable(6);
			table.setSpacingBefore(15);
			table.setWidthPercentage(100);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);

			this.AssembleTable(table,"报销人姓名及编号：",font,"R","0",1);
			this.AssembleTable(table,expense.getExpensePerNo() + "("+expense.getExpensePerName()+")",font,"L","0",1);
			this.AssembleTable(table,"项目编号：",font,"R","0",1);
			this.AssembleTable(table,expense.getProNo(),font,"L","0",1);
			this.AssembleTable(table,"发票抬头：",font,"R","0",1);
			this.AssembleTable(table,expense.getInvoiceTitleName(),font,"L","0",1);

			this.AssembleTable(table,"报销人部门：",font,"R","0",1);
			this.AssembleTable(table,expense.getExpensePerDeptName(),font,"L","0",1);
			this.AssembleTable(table,"项目（部门）名称：",font,"R","0",1);
			this.AssembleTable(table,expense.getProName(),font,"L","0",1);
			this.AssembleTable(table,"项目所属部门：",font,"R","0",1);
			this.AssembleTable(table,expense.getProDeptName(),font,"L","0",1);

			this.AssembleTable(table,"报销目的：",font,"R","0",1);
			this.AssembleTable(table,expense.getExpenseGoalName(),font,"L","0",1);
			if("SALE".equalsIgnoreCase(expense.getType())) {//如果是销售部门人员
				this.AssembleTable(table,"是否平台：",font,"R","0",1);
				this.AssembleTable(table,expense.getIsPlatform(),font,"L","0",1);
			}
			if("02".equals(expense.getPayee())) {//如果是对公付款
				this.AssembleTable(table,"供应商名称：",font,"R","0",1);
				this.AssembleTable(table,expense.getVendorName(),font,"L","0",1);
			}

			//		int row = 0;
			//		if(row%2==1){
			//			AssembleTable(table," ",font,"R","0",1);
			//			AssembleTable(table," ",font,"L","0",1);
			//			row = 0;
			//		}
			document.add(table);
			pageHeight.set(pageHeight.get() + table.getTotalHeight());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(codeFile != null && codeFile.exists()) {
				codeFile.delete();
			}
		}
	}

	/**
	 * 组装表格
	 * @param table table对象
	 * @param cellText 单元格对象
	 * @param font 字体
	 * @param align 对齐方式
	 * @param border 边框
	 * @param colspan 合并单元格数量
	 */
	private void AssembleTable(PdfPTable table,String cellText,Font font,String align,String border,int colspan){
		Paragraph pf=new Paragraph(cellText,font);
		PdfPCell pc=new PdfPCell(pf);

		if(colspan>1){
			pc.setColspan(colspan);
		}

		if("0".equals(border)){
			pc.setBorder(0);
		}
		pc.setMinimumHeight(15);
		if("L".equals(align)){
			pc.setHorizontalAlignment(Element.ALIGN_LEFT);
			pc.setVerticalAlignment(Element.ALIGN_LEFT);
		}else if("R".equals(align)){
			pc.setHorizontalAlignment(Element.ALIGN_RIGHT);
			pc.setVerticalAlignment(Element.ALIGN_RIGHT);
		}else{
			pc.setHorizontalAlignment(Element.ALIGN_CENTER);
			pc.setVerticalAlignment(Element.ALIGN_CENTER);
		}

		table.addCell(pc);
	}

	/**
	 * 组装报销明细信息
	 * @param expenseDetailList 报销明细列表
	 * @param document Document对象
	 * @throws Exception
	 */
	private void assembleExpenseDetailTable(List<FEExpenseDetailInfo> expenseDetailList,
	                                        Document document,FEExpense expense,DecimalFormat df1) throws Exception{
		//报销明细标题
		Paragraph pf=new Paragraph("报销明细",b_font_13);
		pf.setSpacingBefore(20);
		pf.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pf);

		PdfPTable RebsList = null;
		String[] th = null;
		RebsList=new PdfPTable(6);
		RebsList.setSpacingBefore(15);
		RebsList.setWidthPercentage(100);
		th = new String[4];
		th[0] = "报告事项";
		th[1] = "费用类型";
		th[2] = "票据类型";
		th[3] = "报销金额";

		for(int i=0;i<th.length;i++){
			pf = new Paragraph(th[i],b_font);
			pf.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPCell pc=new PdfPCell(pf);
			pc.setHorizontalAlignment(Element.ALIGN_CENTER);
			pc.setVerticalAlignment(Element.ALIGN_CENTER);
			RebsList.addCell(pc);
		}

		for (FEExpenseDetailInfo exDetail : expenseDetailList) {
			AssembleTable(RebsList,expense.getReportingMatters(),font,"","1",1);
			AssembleTable(RebsList,exDetail.getExpenseTypeName(),font,"","1",1);
			AssembleTable(RebsList,exDetail.getNoteTypeName(),font,"","1",1);
			String money1 = exDetail.getAmount();
			money1 = df1.format(new BigDecimal(money1));
			AssembleTable(RebsList,money1,font,"R","1",1);
		}

		AssembleTable(RebsList,"合计",font,"","1",5);
		BigDecimal addAmount = expenseDetailList.stream().map(x -> new BigDecimal(x.getAmount())).reduce((x, y)->x.add(y)).get();
		AssembleTable(RebsList,addAmount.toString(),font,"R","1",1);
		//异常费用说明
		AssembleTable(RebsList,"异常费用说明",b_font_10,"","1",1);

		String exception = "　";
		if(expense.getException() != null ){
			exception = "";
			String exception0 = expense.getException();
			String exceptionList[] = exception0.split("<BR>");
			for(int i = 0;i < exceptionList.length;i++){
				if(!exceptionList[i].trim().equals("")){
					exception += exceptionList[i]+"\n";
				}
			}
		}
		AssembleTable(RebsList,exception,font,"L","1",5);
		document.add(RebsList);
		pageHeight.set(pageHeight.get() + RebsList.getTotalHeight());
	}
}

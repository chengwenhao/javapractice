package tools.itext;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ItextUtil {


	public static void main(String[] args) throws Exception{
		getPdf();
	}

	public static void getPdf() throws Exception{
		String DEST = "/Users/chengfeng/Desktop/pdf/pdftest.pdf";

		//设置页面大小
		Rectangle rect = new Rectangle(PageSize.A4.rotate());
		//设置页面背景色
		//ect.setBackgroundColor(BaseColor.ORANGE);
		Document document = new Document(rect);
		//页边距
		document.setMargins(50, 50, 100, 100);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));

		document.open();




		//表头table
		PdfPTable table = new PdfPTable(6);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("费用报销单号："));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("凭证号："));
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("条码处："));
		table.addCell(cell);
		table.addCell("row 1; cell 1");
		table.addCell("row 1; cell 2");
		table.addCell("row 2; cell 1");

		document.add(table);




		document.close();
		writer.close();

	}
}

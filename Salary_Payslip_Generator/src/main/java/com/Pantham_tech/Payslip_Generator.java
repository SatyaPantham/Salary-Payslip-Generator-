package com.Pantham_tech;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class Payslip_Generator {

	public static void main(String[] args) throws IOException {
	
		
		
		String path = "E:\\Invoice\\Pantham_Tech-Payslip.pdf ";
		PdfWriter pdfWriter1 = new PdfWriter(path);
	    PdfDocument pdfDocument = new PdfDocument(pdfWriter1);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		Document document= new Document(pdfDocument);
		
		String imgSrc = "Images\\pantham.PNG";
		ImageData data = ImageDataFactory.create(imgSrc);
		Image image1 = new Image(data);
		image1.scaleAbsolute(235,111);
		
		String imgSrc1 = "Images\\Pantham_Payslip.PNG";
		ImageData data1 = ImageDataFactory.create(imgSrc1);
		Image image2 = new Image(data1);
		image2.scaleAbsolute(131,55);
		
		String imgSrc2 = "Images\\Watermark_Pantham.PNG";
		PdfCanvas canvas = new PdfCanvas(pdfDocument.addNewPage());
		ImageData data2 = ImageDataFactory.create(imgSrc2);
		Image image3 = new Image(data2);
		image3.scaleAbsolute(600, 200);
		canvas.saveState();
		PdfExtGState state = new PdfExtGState();
		state.setFillOpacity(0.4f);
		canvas.setExtGState(state);
		canvas.addImage(data2, 220f, 320f, false);
		canvas.restoreState();
	
		float col = 400f;
		float columnWidth[] = {col,col};
		Table table3 = new Table(columnWidth);
		table3.setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK);
		
		
		table3.addCell(new Cell().add(image1)
				.setTextAlignment(TextAlignment.CENTER)
				.setVerticalAlignment(VerticalAlignment.TOP)
				.setMarginBottom(15)
				.setBorder(Border.NO_BORDER)
				);
		table3.addCell(new Cell().add(image2).add("+917995685339 \n satyapantham1@gmail.com \n visakhapatnam"
				)
				.setFontSize(15f)
				.setTextAlignment(TextAlignment.RIGHT)
				.setVerticalAlignment(VerticalAlignment.TOP)
				.setMarginBottom(15)
				.setBorder(Border.NO_BORDER)
				);
		
		
		float columnWidth1[] = {80,300,100,80};
		Table custinfo = new Table(columnWidth1);
		
		custinfo.addCell(new Cell(0,4)
				.add("Employee Information").setBackgroundColor(Color.GREEN,0.3f).setFontColor(Color.BLACK)
				.setBold());
		
		
		String Name;
		String EMPID;
		String MOBILE;
		String DATE;
		
		System.out.println("\nPlease Enter the Employee Information");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter the Employee name");
		Name = sc.next();
		System.out.println("Enter the Employee ID");
		EMPID = sc.next();
		System.out.println("Enter the Employee Contact NUmber");
		MOBILE = sc.next();
		System.out.println("Date");
		DATE = sc.next();
		
		
		custinfo.addCell(new Cell().add("Name").setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add(Name).setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Employee ID").setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add(EMPID).setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Mobile No").setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add(MOBILE).setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add("Date").setBorder(Border.NO_BORDER));
		custinfo.addCell(new Cell().add(DATE).setBorder(Border.NO_BORDER));
		
		Text t1 = new Text("\n");
		Paragraph p1 = new Paragraph().add(t1);
		
		
		
		float salaryinfo[] = {140,140,140,140};
		Table T2 = new Table(salaryinfo);
		T2.addCell(new Cell(0,4)
				.add("Employee Monthly Salary Information")
				.setBold().setBackgroundColor(Color.GREEN,0.3f));
		
		T2.addCell(new Cell().add("Earning").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		T2.addCell(new Cell().add("Per Day Wage").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		T2.addCell(new Cell().add("No of Days Present").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		T2.addCell(new Cell().add("Total_amount").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		
		
		
		System.out.println("Please enter the following salary information of the employee");
	
		System.out.println("Enter the per day Wage");
		String Salary;
		Salary = sc.next();
		int i = Integer.parseInt(Salary);
		
		System.out.println("Enter No of days employee worked");
		String Days;
		Days=sc.next();
		int j = Integer.parseInt(Days);
		
		int t = i*j;
		String tot = String.valueOf(t);
		
		
		T2.addCell(new Cell().add("Basic Pay"));
		T2.addCell(new Cell().add(Salary));
		T2.addCell(new Cell().add(Days));
		T2.addCell(new Cell().add(tot));
		
		
		System.out.println("Enter wage for overtime ");
		String overwage ;
		overwage = sc.next();
		int x = Integer.parseInt(overwage);
		
		System.out.println("Enter no of overtime days");
		String over ;
		over = sc.next();
		int y = Integer.parseInt(over);
		
		int z = x*y;
		String overtot = String.valueOf(z);
		
		
		T2.addCell(new Cell().add("Over time"));
		T2.addCell(new Cell().add(overwage));
		T2.addCell(new Cell().add(over));
		T2.addCell(new Cell().add(overtot));
		
		int G = t+z;
		String Gross = String.valueOf(G);
		
		T2.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T2.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T2.addCell(new Cell().add("Gross").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));
		T2.addCell(new Cell().add(Gross).setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));
		
		float Deductioninfo[] = {140,140,140,140};
		Table T3 = new Table(salaryinfo);
		
		
		T3.addCell(new Cell(0,2).add("Deduction").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		
		T3.addCell(new Cell().add("Amount").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		T3.addCell(new Cell().add("Total").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold());
		
		System.out.println("Enter the PF amount deducted");
		String PFA;
		PFA = sc.next();
		int p = Integer.parseInt(PFA);
		
		T3.addCell(new Cell(0,2).add("Profident Fund"));
	
		T3.addCell(new Cell().add(PFA));
		T3.addCell(new Cell().add(PFA));
		
		System.out.println("Enter the Income Tax amount deducted");
		String Tax;
		Tax = sc.next();
		int taxe = Integer.parseInt(Tax);
		
		T3.addCell(new Cell(0,2).add("Income Tax"));
	
		T3.addCell(new Cell().add(Tax));
		T3.addCell(new Cell().add(Tax));
		
		System.out.println("Enter the health Insurance amount deducted");
		String insu;
		insu = sc.next();
		int insurance = Integer.parseInt(Tax);
		
		T3.addCell(new Cell(0,2).add("Health Insurance"));
	
		T3.addCell(new Cell().add(insu));
		T3.addCell(new Cell().add(insu));
		
		System.out.println("Enter the Loan amount deducted");
		String Loan;
		Loan = sc.next();
		int L = Integer.parseInt(Tax);
		
		T3.addCell(new Cell(0,2).add("Loan"));
		
		T3.addCell(new Cell().add(Loan));
		T3.addCell(new Cell().add(Loan));
		
		int D = taxe + insurance +L;
		String Deduction = String.valueOf(D);
		
		
		T3.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T3.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T3.addCell(new Cell().add("Net Deducted ").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));
		T3.addCell(new Cell().add(Deduction).setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));

		
		float NetPay[] = {140,140,140,140};
		Table T4 = new Table(NetPay);
		
		int N = G-D;
		String Net = String.valueOf(N);
		
		T4.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T4.addCell(new Cell().add("").setBackgroundColor(Color.CYAN).setBorder(Border.NO_BORDER));
		T4.addCell(new Cell().add("Net Pay ").setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));
		T4.addCell(new Cell().add(Net).setBackgroundColor(Color.CYAN).setFontColor(Color.BLACK).setBold().setBorder(Border.NO_BORDER));

		Text text5 = new Text("\n Address - Visakhaptnam , Andhra Pradesh ").setFontColor(Color.BLACK).setFontSize(8);
		Paragraph para1 = new Paragraph().add(text5);
		text5.setTextAlignment(TextAlignment.CENTER);
		
		document.add(table3);
		document.add(p1);
		document.add(p1);
		document.add(custinfo);
		document.add(p1);
		document.add(T2);
		document.add(p1);
		document.add(T3);
		document.add(p1);
		document.add(T4);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(p1);
		document.add(para1);
		
		document.close();
		
		System.out.println("Your PaySlip Is Generated");
		
	}
}

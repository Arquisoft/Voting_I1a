package es.uniovi.asw.parser.letters;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import es.uniovi.asw.models.Voter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * This class generates PDF letters
 * @author UO238754
 */
public class PDFLetter implements LetterGenerator {

	@Override
	public void generateLetter(Voter voter) throws FileNotFoundException, DocumentException {
		
		FileOutputStream letter = new FileOutputStream("Letters/" + voter.getEmail() + ".pdf");
		Document pdfDoc = new Document();
		PdfWriter.getInstance(pdfDoc, letter);
		pdfDoc.open();
		pdfDoc.add(new Paragraph(voter.getName() +",you have been added to the Electoral Roll."));
		pdfDoc.add(new Paragraph("Your login name is: " + voter.getEmail()));
		pdfDoc.add(new Paragraph("Your password is: " + voter.getPassword()));
		pdfDoc.close();
	}
}
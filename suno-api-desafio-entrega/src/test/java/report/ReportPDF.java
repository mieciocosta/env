package report;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import report.exception.ReportException;
import report.interfaces.Report;

public class ReportPDF implements Report {

	private final float MARGIN = 30;
	private String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//" + Thread.currentThread().getName()
			+ ".pdf";
	private Document document = new Document();
	private ReportCapa capa = new ReportCapa(document, MARGIN, path);
	private ContentPDF contentPDF = new ContentPDF(document, MARGIN);
	Paragraph y = new Paragraph(265, "\n");

	@Override
	public void setCover(String titulo, String objetivo) {
		capa.setCapa(titulo, objetivo);
		try {
			document.add(y);
		} catch (DocumentException e) {
			throw new ReportException(e);
		}
	}

	@Override
	public void addStep(String description, byte[] imagem) {
		contentPDF.addStep(description, imagem);
	}

	@Override
	public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem) {
		contentPDF.addStep(description, fontName, size, style, color, imagem);
	}

	@Override
	public void addStep(byte[] imagem) {
		contentPDF.addStep(imagem);
	}

	@Override
	public void addText(String description, String fontName, float size, int style, BaseColor color) {
		contentPDF.addText(description, fontName, size, style, color);
	}

	@Override
	public void addText(String description) {
		contentPDF.addText(description, FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
	}

	@Override
	public void save(boolean isPassed, String[] versions) {
		save(this.path, isPassed, versions);
	}

	@Override
	public void save(boolean isPassed) {
		save(this.path, isPassed);
	}

	private void save(String path, boolean isPassed, String[] versions) {
		try {
			this.automationType(versions);
			capa.setStatus(isPassed);
			document.close();
			ReportManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			throw new ReportException(e);
		}
	}

	private void save(String path, boolean isPassed) {
		try {
			capa.setStatus(isPassed);
			document.close();
			ReportManager.addEvidence(Paths.get(path));
		} catch (IOException e) {
			throw new ReportException(e);
		}
	}

	@Override
	public void automationType(String[] version) {
		StringBuilder strAutomationType = new StringBuilder();
		for (int i = 0; i < version.length; i++) {
			strAutomationType.append((i == 0 ? " " : "\n, ") + "[" + version[i] + "]");
		}
		try {
			capa.getDescText().go();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public Path getPath() {
		return ReportManager.getFullPath();
	}

}

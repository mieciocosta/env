package report;

import java.io.File;

import com.itextpdf.text.BaseColor;

import report.interfaces.Report;

public class EvidenceManager {

	private static Report report;

	public static void newInstance() {
		createFolderEvidence();
		report = new ReportPDF();
	}

	public static Report getReport() {
		return report;
	}

	public static void addText(String descricao) {
		System.out.print(descricao);
		report.addText(descricao);
	}

	public static void addTextStep(String step, String descricao) {
		report.addText("\n" + step);
		report.addText(descricao);
	}

	private static void createFolderEvidence() {
		File folderEvidence = new File("./Evidences");
		if (!folderEvidence.exists())
			folderEvidence.mkdirs();
	}public static void addTextColorido(String description, String fontName, float size, int style, BaseColor color) {
		report.addText(description, fontName, size, style, color);
	}
	public static void addTextColor(String description, String fontName, float size, int style, BaseColor color) {
	}

}

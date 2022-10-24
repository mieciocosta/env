package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import report.EvidenceManager;

public class CreateReport {
	
	public static void createReport() {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		Thread.currentThread().setName("Execucao_" + timeStamp);
		EvidenceManager.newInstance();
		EvidenceManager.getReport().setCover("", "");
	}

	public static void saveReport() {
		EvidenceManager.addText("");
		EvidenceManager.getReport().save(true);
	}

}

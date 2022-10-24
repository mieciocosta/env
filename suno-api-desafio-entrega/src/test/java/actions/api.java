package actions;

import static io.restassured.RestAssured.given;
import com.itextpdf.text.BaseColor;
import org.json.JSONArray;
import org.json.JSONObject;
import report.EvidenceManager;
import utils.CreateReport;
import utils.PropertyReader;

public class api {

	static String urlMovie = "/3/movie/550?api_key=";
	static String apiBase = PropertyReader.getProperty("api");

	public void validarMovie(String code, String key) {
		CreateReport.createReport();
		String url = apiBase+urlMovie+key;
		int codigoConvertido = Integer.parseInt(code);
		EvidenceManager.addText("Url da API enviada foi:\n" + url + "\n");

		try {
			String resp =
			given().relaxedHTTPSValidation().when().get(url).then().statusCode(codigoConvertido).extract().response().asString();
			System.out.println("O status foi: " + code);
			System.out.println("O response foi: " + resp);

			JSONObject json = new JSONObject(resp);
			String validaTitle = json.getString("title");
			if(!validaTitle.equals("null")){
				System.out.println("O Title eh: " + validaTitle);
			}


			EvidenceManager.addTextColorido("\nO codigo retorno da API é: " + code, "Arial", 10, 2, BaseColor.GREEN);
			EvidenceManager.addTextColorido("\nO response da API é: " + resp, "Arial", 10, 2, BaseColor.RED);
			EvidenceManager.addTextColorido("\nO Title do response é: " + validaTitle, "Arial", 10, 2, BaseColor.BLACK);
		} catch (Exception e) {
			System.out.println("Erro no retorno do status: " + code);
			EvidenceManager.addTextColorido("\nErro no retorno:", "Arial", 10, 2, BaseColor.RED);
		}

	}


	public void validarId(String idImdb, String key) {
		CreateReport.createReport();
		String url = apiBase+urlMovie+key;
		EvidenceManager.addText("Url da API enviada foi:\n" + url + "\n");

		try {
			String resp =
					given().relaxedHTTPSValidation().when().get(url).then().statusCode(200).extract().response().asString();
			System.out.println("O response foi: " + resp);

			JSONObject json = new JSONObject(resp);
			String validaImdbId = json.getString("imdb_id");
			if(validaImdbId.equals(idImdb)){
				System.out.println("O ImdbId eh: " + validaImdbId);
			}


			EvidenceManager.addTextColorido("\nO response da API é: " + resp, "Arial", 10, 2, BaseColor.RED);
			EvidenceManager.addTextColorido("\nO ImdbId do response é: " + validaImdbId, "Arial", 10, 2, BaseColor.BLACK);
		} catch (Exception e) {
			System.out.println("Erro no retorno do status");
			EvidenceManager.addTextColorido("\nErro no retorno:", "Arial", 10, 2, BaseColor.RED);
		}

	}


	public void validarSpokenLanguages( String key,String name,String iso) {
		CreateReport.createReport();
		String url = apiBase+urlMovie+key;
		EvidenceManager.addText("Url da API enviada foi:\n" + url + "\n");
		int codigoConvertido = Integer.parseInt(String.valueOf(200));

		try {
			String resp =
					given().relaxedHTTPSValidation().when().get(url).then().statusCode(codigoConvertido).extract().response().asString();
			System.out.println("O response foi: " + resp);

			JSONObject json = new JSONObject(resp);

			JSONArray getSpoken = json.getJSONArray("spoken_languages");
			JSONObject objectJson = getSpoken.getJSONObject(0);
			String getLanguage = objectJson.getString("name");
			String getIso = objectJson.getString("iso_639_1");

			if(getLanguage.equals(name) && getIso.equals(iso)){
				System.out.println("O name eh: " + getLanguage);
				System.out.println("O iso eh: " + getIso);
			}


			EvidenceManager.addTextColorido("\nO response da API é: " + resp, "Arial", 10, 2, BaseColor.RED);
			EvidenceManager.addTextColorido("\nO Language do response é: " + getLanguage, "Arial", 10, 3, BaseColor.BLACK);
			EvidenceManager.addTextColorido("\nO Iso do response é: " + getIso, "Arial", 10, 3, BaseColor.BLACK);
		} catch (Exception e) {
			System.out.println("Erro no retorno do status");
			EvidenceManager.addTextColorido("\nErro no retorno:", "Arial", 10, 2, BaseColor.RED);
		}

	}
}

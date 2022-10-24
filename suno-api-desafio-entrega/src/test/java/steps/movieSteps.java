package steps;

import actions.api;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import utils.CreateReport;

import java.util.Map;

public class movieSteps {
	api apiAction = new api();

	@Dado("que estou enviando dados para a api com a apiKey")
	public void que_estou_enviando_dados_para_a_api_com_a_apiKey(DataTable dataTable) throws Throwable {
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			String code = map.get("codigoDeRetorno");
			String key = map.get("apiKey");
			apiAction.validarMovie(code,key);
		}
	}

	@Quando("valido o id do IMDB")
	public void valido_o_id_do_IMDB(DataTable dataTable) throws Throwable {
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			String idImdb = map.get("idImdb");
			String key = map.get("apiKey");
			apiAction.validarId(idImdb,key);
		}
	}
	

	@Entao("valido o spoken language")
	public void valido_o_spoken_language(DataTable dataTable) throws Throwable {
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			String key = map.get("apiKey");
			String name = map.get("name");
			String iso = map.get("iso");
			apiAction.validarSpokenLanguages(key,name,iso);
		}
	}
	

}

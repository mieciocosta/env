/*global Given, When, Then, And*/
import { Given, When, Then, And } from "cypress-cucumber-preprocessor/lib/resolveStepDefinition";
import searchPage from "../page/home_page";
import pdpPage from "../page/pdp_page";
const ambiente = Cypress.config("baseUrl")
const search = new searchPage;
const page = new pdpPage;


Given("que o usuario esta na home",()=>{
    search.visitarSite(ambiente);
})
When('clicar em search',()=>{
    search.clickSearch();
       
})

And('pesquisar por serie peaky blinders',()=>{
   search.inputValueSearch();
   page.selecionarCartaz();
    
})

And('selecionar serie',()=>{
    page.selecionarCartaz();
     
 })

Then('validar botão de acessar conta',()=>{
     page.clickConta();
})

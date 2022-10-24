/*global Given, When, Then, And*/
import { Given, When, Then, And } from "cypress-cucumber-preprocessor/lib/resolveStepDefinition";
import searchPage from "../page/home_page";
const ambiente = Cypress.config("baseUrl")
const search = new searchPage;


Given("que o usuario esta na home",()=>{
    search.visitarSite(ambiente);
})
When('clicar em search',()=>{
    search.clickSearch();
       
})

And('pesquisar por serie peaky blinders',()=>{
   search.inputValueSearch();
    
})

Then('validar url',()=>{
    search.validarUrl();
})

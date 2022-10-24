///<reference types="Cypress"/>


import shelbyElements from '../elements/shelbys_elements'

const element = new shelbyElements

const ambiente = Cypress.config("baseUrl")
const pbUrl = Cypress.config("pbUrl")

class pdpPage{
      
   selecionarCartaz(){
    cy.get(element.clickCartaz()).should('be.visible').click()
   }
   
    clickConta(){
        cy.get(element.btnConta()).should('be.visible').click()
    }
   
}export default pdpPage;

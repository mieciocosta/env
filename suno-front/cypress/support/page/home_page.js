///<reference types="Cypress"/>


import searchElements from '../elements/search_elements'

const element = new searchElements

const ambiente = Cypress.config("baseUrl")
const pbUrl = Cypress.config("pbUrl")

class searchPage{
      
    visitarSite(){
        cy.visit(ambiente)
    }
    clickSearch(){
        cy.wait(1000);
        cy.get(element.labelSearch()).should('be.visible').click()
       
    }

    inputValueSearch(){
        cy.wait(1000);
        cy.get(element.inputSearch()).should('be.visible').click()
        cy.get(element.inputSearch()).should('be.visible').type("peaky blinders").type('{enter}')
       
    }

    validarUrl(){
        cy.url().should('eq', pbUrl)
    }
    

}export default searchPage;

const { defineConfig } = require("cypress");

module.exports = defineConfig({
  viewportWidth: 1000,
  viewportHeight: 1000,
  reporter: "mochawesome",

  reporterOptions: {
    reportDir: "cypress/relatório",
    overwrite: true,
    reportFilename: "Relatório dinâmico",
    timestamp: "dd/mm/yyyy_HHMMSS",
    charts: true,
    reportPageTitle: "custom-title",
  },

  e2e: {
    baseUrl: "https://www.themoviedb.org",
    pbUrl: "https://www.themoviedb.org/search?query=peaky%20blinders",

    setupNodeEvents(on, config) {
      const cucumber = require("cypress-cucumber-preprocessor").default;
      on("file:preprocessor", cucumber());
    },
    specPattern: 'cypress/e2e',
    supportFile: 'cypress/support/e2e.js',
  },
});

import Vue from 'vue'
import Vuetify from 'vuetify/lib'

Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    dark: false,
    themes: {
      light: {
        primary: '#4052b2',
        secondary: '#607d8b',
        accent: '#4caf50',
        error: '#f44336',
        warning: '#f44336',
        info: '#607d8b',
        success: '#4caf50'
      },
      dark: {
        primary: '#4052b2',
        secondary: '#607d8b',
        accent: '#4caf50',
        error: '#f44336',
        warning: '#f44336',
        info: '#607d8b',
        success: '#4caf50'
      }
    }
  }
})

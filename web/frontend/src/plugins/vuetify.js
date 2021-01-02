import Vue from 'vue'
import Vuetify from 'vuetify/lib/framework'

Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#fa8072',
        secondary: '#9E9E9E',
        accent: '#9E9E9E',
        error: '#F44336'
      },
      dark: {
        primary: '#33333'
      }
    }
  }
})

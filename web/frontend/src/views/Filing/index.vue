<template>
  <v-container id="filing">
    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg" class="pa-12">
          <v-timeline>
            <v-timeline-item
              v-for="(year, i) in years"
              :key="i"
              :color="year.color"
              small
            >
              <template v-slot:opposite>
        <span
          :class="`headline font-weight-bold ${year.color}--text`"
          v-text="year.year"
        ></span>
              </template>
              <div class="py-4">
                <h2 :class="`headline font-weight-light mb-4 ${year.color}--text`">Lorem ipsum</h2>
                <div>
                  Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod
                  convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an
                  salutandi sententiae.
                </div>
              </div>
            </v-timeline-item>
          </v-timeline>
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'filing',
  data: () => ({
    years: [
      {
        color: 'cyan',
        year: '1960'
      },
      {
        color: 'green',
        year: '1970'
      },
      {
        color: 'pink',
        year: '1980'
      },
      {
        color: 'amber',
        year: '1990'
      },
      {
        color: 'orange',
        year: '2000'
      }
    ]
  })
}
</script>

<style scoped>
#filing {
  width: 1200px;
  margin: 0 auto;
}
</style>

<template>
  <v-sheet rounded="lg">
    <div class="titles">文章标签</div>
    <v-chip-group column class="pa-4 pt-0">
      <v-chip v-for="(tag, index) in tags" :color="colorList[Math.floor((Math.random()*colorList.length))]" text-color="white" :key="index">
        {{ tag }}
      </v-chip>
    </v-chip-group>
  </v-sheet>
</template>

<script>
export default {
  name: 'fileTags',
  data: () => ({
    tags: [
      'Work',
      'Vacation',
      'Food',
      'Drawers',
      'Shopping',
      'Art',
      'Tech',
      'Home Improvement',
      'Creative Writing'
    ],
    colorList: ['#F44336', '#E91E63', '#9C27B0', '#673AB7', '#3F51B5', '#2196F3', '#03A9F4', '#00BCD4', '#009688', '#4CAF50', '#8BC34A', '#CDDC39', '#FFEB3B', '#FFC107', '#FF9800', '#FF5722', '#795548', '#607D8B', '#9E9E9E']
  }),
  methods: {
    getColor () {
      const letters = '0123456789ABCDEF'
      let color = '#'
      for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)]
      }
      return color
    }
  }
}
</script>

<style scoped>
.titles {
  color: black;
  font-size: 18px;
  font-weight: bolder;
  padding: 10px;
}
</style>

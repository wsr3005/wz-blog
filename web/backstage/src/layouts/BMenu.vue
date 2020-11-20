<template>
  <div id="seetingMenu">
    <v-menu
      bottom
      :offset-y="true"
      origin="center center"
      transition="scale-transition"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Seeting
        </v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          link
        >
          <v-list-item-title @click="handelClick(item.title)">{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
    <span class="text">您好，{{ seeting.name }}</span>
  </div>
</template>

<script>
import seeting from '@/seeting'

export default {
  name: 'BMenu',
  data: () => ({
    seeting,
    items: [
      { title: '修改个人信息' },
      { title: '推出' }
    ]
  }),
  methods: {
    handelClick (title) {
      alert(title)
    }
  }
}
</script>

<style scoped>

.text {
  margin-left: 20px;
  margin-right: 20px;
  color: #fff;
}
</style>

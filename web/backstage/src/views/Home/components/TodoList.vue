<template>
  <div >
    <v-expansion-panels focusable inset>
      <v-expansion-panel
        v-for="(item,i) in 5"
        :key="i"
      >
        <v-expansion-panel-header>
          Item
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>
    <v-btn block color="primary" class="mt-2"> +</v-btn>
  </div>

</template>

<script>
export default {
  name: 'TodoList',
  data: () => ({
    todoList: ['学习nginx', '打lol', '睡觉']
  })

}
</script>

<style lang="scss" scoped>
.todolist {
  color: black;
  font-weight: bolder;

  .list {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    border-top: 1px solid #ededed;
    margin: 0 1% 0 1%;

    &:nth-last-of-type(1) {
      border-bottom: 1px solid #ededed;
    }

    .buttom {
      display: none;
    }

    &:hover {
      background-color: #ededed;

      .buttom {
        display: block;
      }
    }
  }
}
</style>

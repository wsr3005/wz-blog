<template>
  <div fluid class="header-bg">
    <div :class="offsetTop > 750 ? 'header-row1' : 'header-row'">
      <div class="header-blog-left">{{ title }}</div>
      <v-spacer></v-spacer>
      <div class="header-blog-right">
        <v-btn
          class="ml-6"
          width="100"
          :color="offsetTop > 750 ? 'primary' : '#ffffff'"
          :text="offsetTop > 750 ? false : true"
        >
          登陆
        </v-btn>
        <div style="width: 250px">
          <v-text-field
            dense
            solo
            placeholder="搜索"
            hide-details
            @keypress.enter.native="search"
            v-model="searchText"
          >
            <v-icon
              slot="append"
              color="red"
              style="cursor: pointer"
              @click.native="search"
            >
              mdi-magnify
            </v-icon>
          </v-text-field>
        </div>
        <div class="header-blog-nav">
          <div
            v-for="(link, index) in links"
            :key="index"
            @click="handleClick(link, index)"
            :style="
              isActiveNav === index ? 'border-bottom: 1px solid #fa8072' : ''
            "
          >
            {{ link.title }}
          </div>
        </div>
      </div>
    </div>
    <div class="header-text">{{ headerText }}</div>
  </div>
</template>

<script>
export default {
  name: 'header',
  props: ['offsetTop'],
  data: () => ({
    links: [
      {
        title: '首页',
        url: '/home'
      },
      {
        title: '文章',
        url: '/article'
      },
      {
        title: '归档',
        url: '/filing'
      },
      {
        title: '留言',
        url: '/message'
      },
      {
        title: '作者',
        url: '/author'
      }
    ],
    title: 'wyq-blog',
    headerText: '',
    isActiveNav: 0,
    searchText: ''
  }),
  methods: {
    search () {
      alert(this.searchText)
    },
    handleClick (link, index) {
      this.isActiveNav = index
      this.$router.push(link.url)
    }
  }
}
</script>

<style scoped lang="scss">
.header-bg {
  width: 100%;
  height: 800px;
  background-image: url(../assets/images/header-bk.png);
  background-size: cover;
  background-attachment: fixed;

  .header-row {
    color: #ffffff;
    display: flex;
    align-items: center;
    width: 100%;
    position: fixed;
    z-index: 999;
    height: 60px;
  }

  .header-row1 {
    color: #333333;
    background-color: #ffffff;
    display: flex;
    align-items: center;
    width: 100%;
    position: fixed;
    z-index: 999;
    height: 60px;
  }

  .header-blog-left {
    font-size: 23px;
    font-weight: 500;
    width: 30%;
    text-align: center;
  }

  .header-blog-right {
    width: 70%;
    display: flex;
    flex-direction: row-reverse;
    align-items: baseline;
    justify-content: center;

    .header-blog-nav {
      display: flex;

      div {
        margin: 0 30px 0 30px;
        text-align: center;
        &:hover {
          cursor: pointer;
          border-bottom: 1px solid #fa8072;
        }
      }
    }
  }

  .header-text {
    color: #ffffff;
    position: relative;
    top: 50%;
    text-align: center;
    font-size: 30px;
  }
}
</style>

<template>
  <div class="home">
    <div class="banner">
      <v-banner class="py-6 px-6">
        <span>{{ $route.meta.name }}</span>
      </v-banner>
    </div>
    <v-container class="px-6" fluid>
      <v-row>
        <v-col cols="12">
          <v-card>
            <v-card-title>轮播图</v-card-title>
            <pic-upload></pic-upload>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import picUpload from '@/views/HomeSeeting/components/picUpload'
export default {
  name: 'Home',
  data: () => ({
    filelist: []
  }),
  components: {
    picUpload
  }
}
</script>

<style lang="scss" scoped>
.home {
  .banner {
    span {
      color: black;
      font-weight: bold;
      font-size: 1.3em;
    }
  }

  .content {
    display: flex;

    .pic {
      margin-right: 10px;

      &:hover {
        cursor: pointer;
      }
    }
  }
}

</style>

<template>
  <v-app>
    <v-main>
      <v-container fluid class="login-background">
        <v-row class="login-form">
          <div></div>
          <div>
            <div>博客后台管理系统</div>
            <v-form
              class="form"
              ref="form"
              v-model="valid"
            >
              <v-text-field
                v-model="name"
                label="姓名"
                required
              ></v-text-field>

              <v-text-field
                v-model="email"
                :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                :type="show ? 'text' : 'password'"
                @click:append="show = !show"
                label="密码"
                required
              ></v-text-field>

              <v-checkbox
                v-model="checkbox"
                :rules="[v => !!v || 'You must agree to continue!']"
                label="是否记住密码"
                required
              ></v-checkbox>
              <v-row justify="center" class="mt-12">
                <v-btn
                  color="success"
                  class="mr-4"
                  width="80"
                  @click="login"
                >
                  登录
                </v-btn>

                <v-btn
                  color="error"
                  class="mr-4"
                  width="80"
                  @click="reset"
                >
                  注册
                </v-btn>

                <v-btn
                  color="warning"
                  width="100"
                  @click="resetValidation"
                >
                  忘记密码
                </v-btn>
              </v-row>

            </v-form>
          </div>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'Login',
  data: () => ({
    show: false
  }),
  methods: {
    login () {
      this.$router.push('Home')
    }
  }
}
</script>

<style lang="scss" scoped>
.login-background {
  min-height: 100vh;
  background: url("../assets/login-background.jpg") no-repeat 100%;
  background-size: cover;

  .login-form {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 900px;
    height: 600px;

    & > div:first-child {
      width: 50%;
      background: url("../assets/login-form.jpg") no-repeat 100%;
      opacity: .7;
      background-size: cover;
    }

    & > div:last-child {
      width: 50%;
      background-color: #fff;

      & > div:first-child {
        font-weight: bolder;
        font-size: 40px;
        text-align: center;
        padding-top: 15%;
      }

      .form {

        padding: 10%;
      }
    }
  }

}
</style>

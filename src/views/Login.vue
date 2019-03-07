<template>
  <main>
    <el-form :model="form" :rules="rules" ref="form" label-position="left" label-width="0"
             class="login-container">
      <h3 class="title">系统登录</h3>
      <el-form-item>
        <el-input type="text" v-model="form.username" auto-complete="on" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="form.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox v-model="remember" class="remember">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" v-on:click="submit" :loading="logged_in">登录
        </el-button>
      </el-form-item>
    </el-form>
  </main>
</template>

<script>
  import { SET_LOGGED_IN } from '../store-types'

  export default {
    name: 'Login',
    data() {
      return {
        logging: false,
        remember: false,
        form: {
          username: 'admin',
          password: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入账号', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submit() {
        this.logging = true
        this.$api.post('/admin/login', this.form).then(() => {
          this.$store.commit(SET_LOGGED_IN, true)
          this.logging = false
        }).catch(() => {
          this.logging = false
          this.$message('Password Error')
        })
      }
    }
  }
</script>
<style lang="scss" scoped>
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 120px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;

    .title {
      margin: 0 auto 40px auto;
      text-align: center;
      color: #505458;
    }

    .remember {
      margin: 0 0 35px 0;
    }
  }
</style>

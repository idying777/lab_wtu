<template>
  <div class="home">
    <header >
      <div class="logo"><img src="../../assets/logo.png"></div>
      <el-menu class="container nav" default-active="1" mode="horizontal" :router="true"
               background-color="#0d295d"
               text-color="#fff"
               active-text-color="#02F8C0">
        <el-menu-item index="/">首页</el-menu-item>

        <el-submenu index="2">
          <template slot="title">研究团队</template>
          <el-menu-item index="/category/job-core">客座研究人员</el-menu-item>
          <el-menu-item index="/category/job-fix">固定研究人员</el-menu-item>
          <el-menu-item index="/category/job-flow">流动研究人员</el-menu-item>
        </el-submenu>

        <el-menu-item index="/category/team">机构职能</el-menu-item>
		<el-menu-item index="/category/notify">通知公告</el-menu-item>
        <el-menu-item index="/category/result">科研成果</el-menu-item>
        <el-menu-item index="/category/instrument">仪器设备</el-menu-item>
        <el-menu-item index="/category/exchange">开发交流</el-menu-item>
        <el-menu-item index="/files">下载专区</el-menu-item>
        <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>
	  </el-menu>
	  <el-menu v-if="$store.state.logged_in" mode="horizontal">
          <el-menu-item v-if="category">
            <el-button v-on:click="addPost">添加</el-button>
          </el-menu-item>
          <el-menu-item>
            <el-button v-on:click="logout">退出登录</el-button>
          </el-menu-item>
      </el-menu>
    </header>
    <main>
      <div class="dex">
        <img style="width: 100%" src="../../assets/index.jpg" alt="background"/>
      </div>
      <!--<div class="banner">-->
        <!--<img src="../../assets/index.jpg" alt="background"/>-->
      <!--</div>-->

      <!--<div class="focus" id="focus">-->
        <!--<div class="focus_m" id="focus_m">-->
          <!--<ul>-->
            <!--<li style="background: url(../../assets/index.jpg) no-repeat center top;display: block"></li>-->
          <!--</ul>-->
        <!--</div>-->
      <!--</div>-->
      <div class="container">
        <router-view></router-view>
      </div>
    </main>
    <footer>
      <div class="container">
        <div class="plist">
          <div class="plist-title">
            <h3>友情链接：</h3>
          </div>
          <div class="link">
            <a href="http://www.moe.gov.cn/">教育部 </a>
            <a href="http://www.dhu.edu.cn/">东华大学 </a>
            <a href="http://www.tjpu.edu.cn">天津工业大学 </a>
            <a href="http://www.zstu.edu.cn/">浙江理工大学 </a>
            <a href="http://www.suda.edu.cn/">苏州大学 </a>
            <a href="http://www.jiangnan.edu.cn/">江南大学 </a>
          </div>
        </div>
        <div class="copyright">联系我们:027-59367297 地址:武汉市江夏区阳光一号 邮编：430200<br/>Copyright©版权所有：湖北省服装信息化工程技术研究中心</div>
      </div>
    </footer>
  </div>
</template>

<script>
  import { SET_LOGGED_IN } from '../../store-types'

  export default {
    name: 'home',
    components: {},
    computed: {
      category() {
        return this.$route.params.category
      }
    },
    methods: {
      logout() {
        this.$confirm('确认退出吗?', '提示', {}).then(() => {
          this.$store.commit(SET_LOGGED_IN, false)
          this.$router.push('/')
        }).catch(() => {
        })
      },
      addPost() {
        this.$router.push(this.category + '/new')
      }
    }
  }
</script>

<style scoped lang="scss">
  @import "../../style/layout";
  .dex{
    position: relative;
    background: center top no-repeat;

    margin-top: -1px;
    padding: 0 15%;
  }
  .nav{
    margin-left:25%;
    margin-right:20%;
  }
  .card {
    min-width: 270px;
    max-width: 360px;
  }

  header {
    background-color: #fff;
  }
  .logo{
    float:left; display:block;
    padding:0 40px;
    width: 10px;
    height: 10px;
  }

  footer {
    background: #0d295d;
    color: #fff;
    padding: 10px 0;
    font-size: 12px;
    max-width: 1920px;
    min-width: $min_width;

    .plist {
      margin: 0 30px;
    }

    .plist-title {
      height: 20px;
      line-height: 20px;

      h3 {
        margin: 0;
      }
    }

    .link {
      a {
        color: #fff;
        padding: 0;
        text-align: left;

        &:link, &:visited {
          display: inline-block;
          padding: 5px 10px;
          font-size: 14px;
        }

        &:hover {
          color: #0d69b4
        }
      }

      span {
        display: inline-block;
      }
    }

    .copyright {
      margin: 0 auto;
      text-align: center;
      line-height: 30px;
    }
  }


</style>

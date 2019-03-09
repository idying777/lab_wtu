<template>
  <div class="footer container">
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
    <div class="copyright">联系我们:027-59367574 地址:武汉市江夏区阳光一号 邮编：430200<br/>Copyright©版权所有：数计重点实验室</div>
  </div>
</template>

<script>
  export default {
    name: 'FooterMain'
  }
</script>

<style scoped lang="scss">
  a {
    text-decoration: none;
  }

  .footer {
    background: #0d295d;
    color: #fff;
    padding: 10px 0;
    font-size: 12px;
  }

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
</style>

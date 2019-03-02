<template>
  <el-container id="app">
    <el-header>
      <el-row>
        <el-col :span="16" :push="12">
          <el-menu default-active="1" mode="horizontal" :router="true">
            <el-menu-item index="home" route="/">首页</el-menu-item>
            <el-menu-item index="/jgzn">机构职能</el-menu-item>
            <el-menu-item index="3">研究团队</el-menu-item>
            <el-menu-item index="4">科研成果</el-menu-item>
            <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </el-header>
    <router-view/>
    <div id="footer">
      <div class="lkplist">
        <div class="lktitle">
          <h3>友情链接：</h3>
        </div>
        <DIV class="lkcont linkft">
          <table>
            <tr>
              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.moe.gov.cn/">
                  教育部
                </A>
              </td>
              <td class="leaderstyle44622">|</td>
              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.dhu.edu.cn/">
                  东华大学
                </A>
              </td>
              <td class="leaderstyle44622">|</td>
              <td>
                <A class="c44622" style="color: aliceblue" HREF="www.tjpu.edu.cn/" onclick="_addDynClicks('wburl',1193125746,5097)"
                   target="_blank">
                  天津工业大学
                </A>
              </td>
              <td class="leaderstyle44622">|</td>
              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.zstu.edu.cn/">
                  浙江理工大学
                </A>
              </td>
              <td class="leaderstyle44622">|</td>
              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.suda.edu.cn/">
                  苏州大学
                </A>
              </td>
              <td class="leaderstyle44622">|</td>

              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.jiangnan.edu.cn/">
                  江南大学
                </A>

              </td>
              <td class="leaderstyle44622">|</td>

              <td>
                <A class="c44622" style="color: aliceblue" HREF="http://www.wtu.edu.cn/">
                  武汉纺织大学
                </A>
              </td>
            </tr>
          </table><!--#endeditable-->
        </DIV>
      </div>
      <div class="botcont">联系我们:027-59367574 地址:武汉市江夏区阳光一号 邮编：430200<BR/>Copyright©版权所有：纺织纤维及制品教育部重点实验室</div>

    </div>
  </el-container>




</template>

<script>
  export default {
    name: 'app',
    components: {},
  }
</script>

<style>

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    margin-top: 60px;
  }
  #footer{
    width:100%; background:#3a6697; color:#fff; margin:0px auto;  padding:10px 0px; font-size:12px;
  }
  .lkplist{ width:970px; margin:0px auto; display:block; overflow:hidden;}
  .lktitle{width:100%; height:37px; line-height:37px; display:block; overflow:hidden;}
  .lkcont{ width:100%; padding:0px 0px; display:block; overflow:hidden; text-align:left;}

  .linkft{ position:relative;}
  .linkft a:link,.linkft a:visited{ color:#474747; display:inline-block; padding:5px 10px; font-size:14px;}
  .linkft a:hover{ color:#0d69b4}

  .linkft span{ display:inline-block;}
  .botcont{ width:970px; margin:0px auto;text-align:center; line-height:30px; font-family:"宋体";}
</style>

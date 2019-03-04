<template>
  <div id="footer">
    <div class="lkplist">
      <div class="lktitle">
        <h3>友情链接：</h3>
      </div>
      <DIV class="lkcont linkft">
        <table>
          <tr>
            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.moe.gov.cn/">
                教育部
              </A>
            </td>
            <td class="leaderstyle44622">|</td>
            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.dhu.edu.cn/">
                东华大学
              </A>
            </td>
            <td class="leaderstyle44622">|</td>
            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.tjpu.edu.cn"
                 onclick="_addDynClicks('wburl',1193125746,5097)"
                 target="_blank">
                天津工业大学
              </A>
            </td>
            <td class="leaderstyle44622">|</td>
            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.zstu.edu.cn/">
                浙江理工大学
              </A>
            </td>
            <td class="leaderstyle44622">|</td>
            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.suda.edu.cn/">
                苏州大学
              </A>
            </td>
            <td class="leaderstyle44622">|</td>

            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.jiangnan.edu.cn/">
                江南大学
              </A>

            </td>
            <td class="leaderstyle44622">|</td>

            <td>
              <A class="c44622" style="color: aliceblue" href="http://www.wtu.edu.cn/">
                武汉纺织大学
              </A>
            </td>
          </tr>
        </table><!--#endeditable-->
      </DIV>
    </div>
    <div class="botcont">联系我们:027-59367574 地址:武汉市江夏区阳光一号 邮编：430200<br/>Copyright©版权所有：纺织纤维及制品教育部重点实验室</div>
  </div>
</template>

<script>
  export default {
    name: 'FooterMain',
  }
</script>

<style scoped>

  #footer {
    width: 100%;
    background: #3a6697;
    color: #fff;
    margin: 0 auto;
    padding: 10px 0;
    font-size: 12px;
  }

  .lkplist {
    width: 970px;
    margin: 0 auto;
    display: block;
    overflow: hidden;
  }

  .lktitle {
    width: 100%;
    height: 37px;
    line-height: 37px;
    display: block;
    overflow: hidden;
  }

  .lkcont {
    width: 100%;
    padding: 0 0;
    display: block;
    overflow: hidden;
    text-align: left;
  }

  .linkft {
    position: relative;
  }

  .linkft a:link, .linkft a:visited {
    color: #474747;
    display: inline-block;
    padding: 5px 10px;
    font-size: 14px;
  }

  .linkft a:hover {
    color: #0d69b4
  }

  .linkft span {
    display: inline-block;
  }

  .botcont {
    width: 970px;
    margin: 0 auto;
    text-align: center;
    line-height: 30px;
  }
</style>

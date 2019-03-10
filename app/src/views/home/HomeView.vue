<template>
  <div>
    <div class="row">
      <div class="card">
        <el-card style="height: 300px"
                 :v-loading="loading"
                 v-on:click="handleClick()">
          <h3 slot="header">关于我们
            <el-button v-if="logged_in"
                       @click="handleEditAbout()">编辑
            </el-button>
          </h3>
          <div v-if="loading">loading</div>
          <div v-else v-html="aboutContent"></div>
        </el-card>
      </div>
      <div class="card">
        <el-card style="height: 300px">
          <h3 slot="header"> 热点新闻</h3>
          <div v-if="loading">loading</div>
          <div v-else>
            <el-row tag="a" style="margin: 5px 0" type="flex" justify="space-between"
                    v-for="post of hotPosts.slice(0,8)"
                    :href="'/#/post/'+post.title"
                    v-bind:key="post.title">
              <span>{{post.title.slice(0,16)}}</span>
              <span class="hidden-md-and-down" style="text-align: right">
            {{post.createdAt.slice(0,10)}}
          </span>
            </el-row>
          </div>
        </el-card>
      </div>
      <div class="card">
        <items-card category="notify"/>
      </div>
    </div>
    <div class="row">
      <div class="card">
        <items-card category="instrument"/>
      </div>
      <div class="card">
        <items-card category="result"/>
      </div>
      <div class="card">
        <items-card category="exchange"/>
      </div>
    </div>
  </div>
</template>

<script>
  import ItemsCard from '../../components/ItemsCard'
  import { mapGetters, mapState } from 'vuex'
  import { markdown } from 'markdown'

  export default {
    name: 'HomeView',
    components: {
      ItemsCard
    },
    computed: {
      ...mapGetters(['getPostsByCategory']),
      ...mapState(['loading', 'posts', 'logged_in']),
      about() {
        return this.getPostsByCategory('about')[0]
      },
      aboutContent() {
        return markdown.toHTML(this.about.content)
      },
      hotPosts() {
        return this.posts.filter(f => f.title !== 'about').sort((a, b) => a.hot - b.hot)
      }
    },
    methods: {
      handleClick() {
        this.router.push('/post/about')
      },
      handleEditAbout() {
        this.$router.push('/post/about/edit')
      }
    }
  }
</script>

<style scoped lang="scss">
  .row {
    display: flex;
  }

  .card {
    flex: 1 0 300px;
    flex-wrap: wrap;
    margin: 5px;
    font-size: 13px;
  }
</style>

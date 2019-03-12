<template>
  <el-card>
    <div slot="header"
         v-if="logged_in">
      <el-upload :action="uploadUrl" multiple
                 :file-list="fileList"
                 :show-file-list="false"
                 :on-success="handleSuccess"
                 accept="*">
        <el-button>上传</el-button>
      </el-upload>
    </div>
    <ul>
      <li style="margin: 10px 20px"
          :key="file.filename" v-for="file of files">
        <a v-bind:href="file.url">
          <i class="el-icon-download"></i>
          <span>{{file.filename}}</span> </a>

        <template v-if="logged_in">
          <el-button style="float: right" @click="handleDelete(file)">删除</el-button>
        </template>
      </li>
    </ul>
  </el-card>
</template>

<script>
  import { mapState } from 'vuex'
  import { SET_FILES } from '../../store-types'

  export default {
    name: 'Files',
    data() {
      return {
        uploadUrl: process.env.VUE_APP_API_URL + '/admin/files',
        fileList: []
      }
    },
    computed: {
      ...mapState(['files', 'logged_in'])
    },
    methods: {
      handleSuccess(res, file) {
        this.$store.commit(SET_FILES, (this.files.concat({
          'filename': file.name,
          'url': this.getFileUrl(file)
        })))
      },
      handleDelete(file) {
        this.$api.delete(file.url).then(() => {
          this.$message(`delete ${file.filename} success`)
          this.$store.commit(SET_FILES, this.files.filter(f => f.filename !== file.filename))
        }).catch(() => {
          this.$message(`delete ${file.filename} failed`)
        })
      },
      getFileUrl(file) {
        return `${process.env.VUE_APP_API_URL}/files/${file.name}`
      }
    }
  }
</script>

<style scoped lang="scss">
  ul {
    list-style: none;
    margin: 0;
    padding: 0;
    height: 480px;

    li {
      height: 40px;
    }

  }

</style>

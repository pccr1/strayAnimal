<template>
  <div class="infinite-list-wrapper" style="overflow:auto">
    <MainHeader v-if="zhanshi && obj[0]" :Obj="obj[0]" />
    <el-divider></el-divider>
    <div class="pin">
      <span>评论 {{ max }}</span>
      <el-dropdown class="caidan" trigger="click" @command="handleCommand">
        <span class="el-dropdown-link">
          {{ zhuangtai }}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="热门">热门</el-dropdown-item>
          <el-dropdown-item command="正序">正序</el-dropdown-item>
          <el-dropdown-item command="倒序">倒序</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <ul
      class="list"
      v-infinite-scroll="load"
      infinite-scroll-disabled="disabled"
      infinite-scroll-distance="10px">
      <li v-for="i in count" :key="i" class="list-item">
        <PostComment :Obj="obj1[i-1]" v-if="obj1[i-1]" />
        <el-divider v-if="obj1[i-1]"></el-divider>
      </li>
    </ul>
    <p v-if="loading">加载中...</p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
import MainHeader from './MainHeader.vue'
import PostComment from './PostComment.vue'

    export default {
        name:'MainFooter',
        components: {
            MainHeader,
            PostComment,
        },
        data () {
          return {
            zhuangtai:'热门',
            max:0,//评论数量
            count: 0,//目前评论数
            jiazai:10,//每次加载数量
            loading: false,
            zhanshi:true,//主题展示
            obj:[],
            obj1:[],
          }
        },
        computed: {
          noMore () {
            return this.count >= this.max
          },
          disabled () {
            return this.loading || this.noMore
          }
        },
        methods: {
          load () {
            this.loading = true
            setTimeout(() => {
              if(this.max-this.count<this.jiazai){
                this.count += this.max-this.count
              }else{
                this.count += this.jiazai
              }
              this.loading = false
            },)
          },
          handleCommand(command) {
            this.zhuangtai=command
          },
          demo(zhanshi){
            this.zhanshi = zhanshi
          },
          show () {
            const formData = new FormData()
            formData.append('postId', this.$cookie.get('postId'))
            const fullUrl = this.$myVariable + 'post/info/selectPostInfo';
            this.$axios.post(fullUrl, formData,{
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then(response => {
                this.obj = response.data.object
            })
            .catch(error => {
                console.log(error);
            });
            
            const fullUr = this.$myVariable + 'comment/info/selectCommentInfo';
            this.$axios.post(fullUr, formData,{
              headers: {
                  'Content-Type': 'multipart/form-data'
              }
            })
            .then(response => {
                this.obj1 = response.data.object 
                this.max += this.obj1.length
            })
            .catch(error => {
              console.log(error);
            });
          },
        },
        mounted() {
          this.show();
          this.$bus.$on('zhanshi',this.demo)
        },
        beforeDestroy() {
          this.$bus.$off("zhanshi")
        }
    }
</script>

<style scoped>
  .pin {
    font-size:14px;
    font-weight: bold;
    text-align: left;
    padding-left: 20px;
  }
  .caidan {
    float: right;
    padding-right: 20px;
  }
</style>
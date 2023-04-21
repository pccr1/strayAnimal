<template>
    <div class="infinite-list-wrapper" style="overflow:auto">
        <div class="pin">
        <span>留言 {{ max }}</span>
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
            <PostComment/>
            <el-divider></el-divider>
            </li>
        </ul>
        <p v-if="loading">加载中...</p>
        <p v-if="noMore">没有更多了</p>
    </div>
</template>

<script>
import PostComment from '@/components/post/main/PostComment.vue'

    export default {
        name:'FooterTwo',
        components: {
            PostComment,
        },
        data () {
          return {
            zhuangtai:'热门',
            max:11,//留言数量
            count: 10,//目前留言数
            jiazai:10,//每次加载数量
            loading: false,
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
            },100)
          },
          handleCommand(command) {
            this.zhuangtai=command
          },
        },
    }
</script>

<style scoped>
    .infinite-list-wrapper {
        width: 400px;
        margin: 0 -20px;
    }
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
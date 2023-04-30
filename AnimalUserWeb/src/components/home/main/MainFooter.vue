<template>
  <div class="infinite-list-wrapper" style="overflow:auto">
    <MainHeader/>
    <ul
      class="list"
      padding-inline-start: false
      v-infinite-scroll="load"
      infinite-scroll-disabled="disabled"
      infinite-scroll-distance="10px">
      <li v-for="i in count" :key="i" class="list-item">
          <HomeCard :Obj="reversedObj[i-1]" v-if="reversedObj[i-1]"/>
      </li>
    </ul>
    
    <p v-if="loading">加载中...</p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
import MainHeader from './MainHeader.vue'
import HomeCard from '@/components/cards/HomeCard.vue'

    export default {
        name:"MainFooter",
        components: {
          MainHeader,
          HomeCard
        },
        data () {
          return {
            max:0,//帖子数量
            count: 0,//目前帖子数
            jiazai:10,//每次加载数量
            loading: false,
            obj:[],//帖子
          }
        },
        computed: {
          noMore () {
              return this.count >= this.max
          },
          disabled () {
              return this.loading || this.noMore
          },
          reversedObj() {
            return this.obj.slice().reverse();
          }
        },
        methods: {
          load () {
            if(this.max-this.count<this.jiazai){
            this.count += this.max-this.count
            }else{
              this.count += this.jiazai
            }
            this.loading = false
          },
          show () {
            const formData = new FormData()
            const fullUrl = this.$myVariable + 'post/info/selectPostInfo';
            this.$axios.post(fullUrl, formData,{
              headers: {
                  'Content-Type': 'multipart/form-data'
              }
            })
            .then(response => {
              this.obj = response.data.object
              let objectSize = 0;
              for(let k in response.data.object) {
                  objectSize++
              }
              this.max += objectSize
              // console.log(this.obj)
            })
            .catch(error => {
              console.log(error);
            });
                
          }
        },
        mounted() {
          this.show();
        },
  }
</script>

<style scoped>
  .el-header {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .infinite-list-wrapper {
        width: 100%;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        height: 680px;
    }
    .list {
        /* list-style-type:none; */
        list-style: none; 
        padding: 0;
        margin: 0;
    }
</style>
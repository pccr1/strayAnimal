<template>
  <div @click="$router.push({name:'one'})">
    <el-row >
      <el-col class="col" :span="12" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img :src="link" class="image">
          <div style="padding: 14px;">
            <span>{{ jieshao }}</span><!-- 介绍 -->
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name:'AnimalAlvelous',
        props:{
            jieshao:{
                type: String,
                require: true,
                default: '加载失败'
            },
            link:{
                require: true,
                default: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
            }
        }
    }
</script>

<style scoped>
  .col {
    width: 180px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>
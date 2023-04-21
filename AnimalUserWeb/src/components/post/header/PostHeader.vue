<template>
    <el-row>
      <div class="left">
        <el-button 
        size="medium" 
        icon="el-icon-arrow-left" 
        @click="$router.back()" 
        style="border: none"
        round></el-button>
      </div>
      <!-- <div class="main"> -->
        &nbsp;&nbsp;
        <el-button 
        size="mini" 
        style="border: none" 
        @click="zs" round>正文</el-button>

        &nbsp;&nbsp;

        <el-button 
        size="mini" 
        style="border: none" 
        @click="bzs" round>评论</el-button>
      <!-- </div> -->
      <div class="right">
        <el-popover placement="bottom-start" width="250" trigger="hover">
          <!--气泡里的内容-->
          <slot>
              <el-link type="primary" href="https://im.qq.com/index/" class="el-icon-eleme"
                  style="margin-right:10px;" target="_blank">
                  QQ
              </el-link>
              <el-link type="success" href="https://weixin.qq.com/" class="el-icon-s-help"
                  style="margin-right:10px;" target="_blank">
                  微信
              </el-link>
              <el-link type="warning" href="https://weibo.com/" class="el-icon-star-off"
                  style="margin-right:10px;" target="_blank">
                  微博
              </el-link>
              <el-link type="danger" href="https://tieba.baidu.com/" class="el-icon-upload"
                  style="margin-right:10px;" target="_blank">
                  贴吧
              </el-link>
              <el-link type="info" href="" class="el-icon-s-promotion">
                  动态
              </el-link>
          </slot>
          <!--分享按钮-->
          <!-- <el-link type="primary" class="el-icon-share" :underline="false" slot="reference">分享</el-link> -->
          <el-button 
          slot="reference" 
          size="mini" 
          icon="el-icon-share" 
          style="border: none"
          round>分享</el-button>
        </el-popover>
      </div>
    </el-row>
</template>

<script>

    export default {
        name:"PostHeader",
        data() {
          return{
            zhanshi:true,
          }
        },
        methods: {
          zs() {
            this.zhanshi = true
            this.$bus.$emit('zhanshi',this.zhanshi)
          },
          bzs() {
            this.zhanshi = false
            this.$bus.$emit('zhanshi',this.zhanshi)
          }
        }
    }
</script>

<style scoped>
    .left {
        float: left;
    }
    /* .main {
        width: 100px;
    } */
    .right {
        float: right;
    }
</style>
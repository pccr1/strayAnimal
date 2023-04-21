<template>
  <div class="block">
        <el-carousel :autoplay="false" trigger="click" height="150px">
            <el-carousel-item v-for="item in imgs" :key="item.key" >
                <el-image  :src="item.src" style=" height: 150px;" ></el-image>
            </el-carousel-item>
        </el-carousel>
        <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span style="float: left">基本信息</span>
            <el-button 
            style="float: right;border: none" 
            size="mini"
            icon="el-icon-star-off" 
            v-show="!like" @click="like = !like" 
            circle></el-button>
            <el-button 
            style="float: right;border:none" 
            size="mini"
            icon="el-icon-star-off" 
            v-show="like" @click="like = !like"
            type="warning" 
            circle></el-button>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
            {{'懒死你算了 ' + o }}
        </div>
</el-card>
    </div>
</template>

<script>
    export default {
        name:'FooterOne',
        data() {
            return {
                imgs:[
                        {key:'1',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203836.jpg'},
                        {key:'2',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203839.jpg'},
                        {key:'3',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203842.jpg'},
                        {key:'4',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203846.jpg'},
                        {key:'5',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203850.jpg'},
                        {key:'6',src:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203853.jpg'},
                    ],
                like: false,
            }
        }
    }
</script>

<style scoped>
    /* .block {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 680px;
    } */
    .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin:15px 0 ;
    width: 360px;
  }
</style>
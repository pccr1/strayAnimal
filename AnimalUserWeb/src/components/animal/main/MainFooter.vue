<template>         
    <div class="infinite-list-wrapper" style="overflow:auto">
      <MainHeader/> 
      <ul
        class="list"
        padding-inline-start: false
        v-infinite-scroll="load"
        infinite-scroll-disabled="disabled"
        infinite-scroll-distance="10px">
        <li v-for="a in animal" :key="a.id" class="list-item">
            <div class="kuang">
                <AnimalAlvelous :jieshao="a.jieshao" :link="a.link"/>
            </div>
        </li>
      </ul>
      <p v-if="loading">加载中...</p>
      <p v-if="noMore">没有更多了</p>
    </div>
</template>

<script>
import MainHeader from './MainHeader.vue'
import AnimalAlvelous from '../alvelous/AnimalAlvelous.vue';

    export default {
        name:'MainFooter',
        components: {
            MainHeader,
            AnimalAlvelous,
        },
        data () {
            return {
                max:11,//留言数量
                count: 10,//目前留言数
                jiazai:10,//每次加载数量
                loading: false,
                animal:[
                    {id:'001',jieshao:'十三',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/%E5%8D%81%E4%B8%89/QQ%E5%9B%BE%E7%89%8720230415203830.jpg'},
                    {id:'002',jieshao:'小黑',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/960a304e251f95cab6a6f709c8177f3e67095239.jpg'},
                    {id:'003',jieshao:'小墩',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___img1.doubanio.com_view_group_topic_l_public_p253503647.jpg%26refer%3Dhttp___img1.doubanio.jpg'},
                    {id:'004',jieshao:'大花',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_093e5b98-0554-450a-8703-6cf405cd31bf_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'005',jieshao:'小白',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_3dfacd2f-ba03-4c2b-bf6f-552dc8aec842_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'006',jieshao:'一块',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_5dc6d82f-e077-48b5-a2a0-b1998abc3713_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'007',jieshao:'大智',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_92417f58-07f9-4921-8f41-9713ae571374_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'008',jieshao:'黑蛋',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_97f19177-323c-4aa2-9b53-18a3d7830ae4_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'009',jieshao:'斑点',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_a18250f9-361e-43de-9ebc-41358f608147_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'010',jieshao:'橘座',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/src%3Dhttp___safe-img.xhscdn.com_bw1_aff104c7-5b85-4bad-ae28-71e87501b4d8_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg'},
                    {id:'011',jieshao:'大佐',link:'http://rskkl6llr.hb-bkt.clouddn.com/%E5%B0%8F%E7%8B%97%E5%B0%8F%E7%8C%AB/u%3D1189514122%2C1368191846%26fm%3D253%26fmt%3Dauto%26app%3D138%26f%3DJPEG.jpg'},
                    
                ]
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
        },
    }
</script>

<style scoped>
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
        display: flex;
        flex-wrap: nowrap; /*禁止换行 */
        flex-wrap: wrap;
        margin:0 5px; /* 设置边距 */
        
    }
    .kuang {
        margin:0 2px; /* 设置边距 */
    }
</style>
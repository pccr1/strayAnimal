<template>
  <div>
    <div class="touxiang">
        <!-- 头像 -->
        <CardHead :userAvatar="Obj.userAvatar" :userNetWorkName="Obj.userNetWorkName" :userTitle="Obj.userTitle" :userLevel="Number(Obj.userLevel)" />

        <el-button 
        class="dianzan"
        size="mini" 
        icon="el-icon-thumb"
        v-if="!like" 
        @click="change()" 
        circle>{{ zan }}</el-button>

        <el-button 
        class="dianzan"
        type="warning"
        size="mini" 
        icon="el-icon-thumb"
        v-if="like" 
        @click="change()" 
        circle>{{ zan }}</el-button>
    </div>
    <div class="zhengwen">
        <!-- 正文 -->
        <span @click.self="onTextClick">{{ Obj.commentText }}</span>
        <!-- 图片 -->
        <div class="img">
            <div class="block" 
            v-for="fit in srcList" 
            :key="fit.pictureid">
                <el-image
                @load="tianjia(fit)"
                :preview-src-list="currentUrl"
                style="width: 100px; height: 100px"
                :src="fit.pictureUrl"
                fit="cover"></el-image>
            </div>
        </div>
    </div>
    <div class="pinglun">
        <!-- 回复 -->
        <ul
        class="list"
        infinite-scroll-disabled="disabled"
        infinite-scroll-distance="10px">
            <li v-for="i in count" :key="i" class="list-item">
                <CommentFooter :Huifu="huifu[i-1]" v-if="huifu[i-1]" />
            </li>
        </ul>
        <el-link v-show="!noMore" type="info" :underline="false" @click="load">全部{{ max }}条回复 ▼</el-link>
        <p v-if="loading">加载中...</p>
    </div>
  </div>
</template>

<script>
import CardHead from '@/components/cards/CardHead.vue';
import CommentFooter from './CommentFooter.vue';

    export default {
        name:'PostComment',
        components: {
            CardHead,
            CommentFooter,
        },
        props: {
            Obj:Object,
        },
        data(){
            return{
                zan:0,//点赞数量
                like:false,//点赞
                max:0,//回复数量
                count: 0,//目前评论数
                jiazai:10,//每次加载数量
                dianji:false,//点击加载
                loading: false,
                srcList: [],//小图
                currentUrl: [],//大图
                huifu:[],//回复信息
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
            if(this.max-this.count<this.jiazai){
                this.count += this.max-this.count
            }else{
                this.count += this.jiazai
            }
            this.loading = false
            this.dianji = false
          },
          change() { //点赞功能实现
            if (!this.like) {
                const formData = new FormData()
                formData.append('commentId', this.Obj.commentId)
                const fullUrl = this.$myVariable + 'comment/info/likeIs';
                this.$axios.post(fullUrl, formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                });
                this.zan += 1
                this.like = true
            } else {
                const formData = new FormData()
                formData.append('commentId', this.Obj.commentId)
                const fullUrl = this.$myVariable + 'comment/info/noLikeIs';
                this.$axios.post(fullUrl, formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                });
                this.zan -= 1
                this.like = false
            }
            },
            jiazai1 () {
                const formData = new FormData()
                formData.append('commentId', this.Obj.commentId)
                const fullUrl = this.$myVariable + 'picture/info/selectPictureInfo';
                this.$axios.post(fullUrl, formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.srcList = response.data.object
                })
                .catch(error => {
                    console.log(error);
                });
                this.zan = this.Obj.commentLike
            },
            jiazai2 (){
                const formData = new FormData()
                formData.append('commentId', this.Obj.commentId)
                const fullUrl = this.$myVariable + 'answer/info/selectAnswerInfo';
                this.$axios.post(fullUrl, formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.huifu = response.data.object
                    // console.log(this.huifu)
                    let objectSize = 0;
                    for(let k in response.data.object) {
                        objectSize++
                    }
                    this.max += objectSize
                    if(this.max>1){
                        this.count = 2
                    }
                })
                .catch(error => {
                    console.log(error);
                });
            },
            tianjia(fit) {
                this.currentUrl.push(fit.pictureUrl);
            },
            onTextClick() {
                // 发送事件给事件总线实例
                this.$bus.$emit('textClicked', this.Obj);
            }
        },
        mounted() {
            this.jiazai1();
            this.jiazai2();
        },
    }
</script>

<style scoped>
    .dianzan {
        margin-top: 15px;
        float: right;
        padding: 8px;
        position: relative;
        right: 10px;
    }
    .touxiang {
        height: 50px;
    }
    .zhengwen {
        font-size:14px;
        margin-top: 7px;
        width: 320px;
        text-align: left;
        padding-left: 50px;
        padding-top: 10px;
    }
    .pinglun {
        background-color: #e2e2e2;
        width: 320px;
        margin-left: 50px;
        
    }
    .img {
        margin: 10px 0;
        display: flex;
        flex-wrap: nowrap; /* 禁止换行 */
        flex-wrap: wrap
    }
    .block {
        flex: 0 0 auto; /* 禁止图片缩放 */
        margin-right: 5px; /* 图片间距 */
    }
</style>
<template>
    <div style="float:left;clear: both;text-align: left;width: 347px;">
        <!--隔断线-->
        <HR style="FILTER:alpha(opacity=100,finishopacity=0,style=3)" width="100%" color=#DCDFE6 SIZE=1 />
        <!--三部分-->
        <div style="margin-left:10px; margin-bottom:4px;">
            <!--分享-->
            <div style="float:left;margin-left:30px;margin-right:25px;margin-bottom:7px;">
                <!--气泡-->
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
                    <el-link type="primary" class="el-icon-share" :underline="false" slot="reference">分享</el-link>
                </el-popover>
            </div>
            <!--竖隔断线-->
            <div style="float:left;"> <el-divider direction="vertical"></el-divider></div>
            <!--评论-->
            <div style="float:left;margin-left:25px;margin-right: 25px;">
                <el-badge :value="ping" class="item">    
                    <el-link type="primary" class="el-icon-chat-dot-square" :underline="false" @click="tiaozhuan()">
                        评论
                    </el-link>
                </el-badge>
            </div>
            <!--竖隔断线-->
            <div style="float:left;"> <el-divider direction="vertical"></el-divider></div>
            <!--点赞-->
            <div style="float:left;margin-left:25px;">
                <el-link type="primary" :underline="false" @click="change" class="el-icon-thumb" v-show="thumbsUp">点赞</el-link>
                <el-link type="warning" :underline="false" @click="change" class="el-icon-thumb" v-show="!thumbsUp">点赞</el-link>
            </div>
        </div>
    </div>
</template>
 
<script>


export default {
    //el-icon-thumb
    name: 'CardFooter',
    components: {
    },
    props:{
        postId:Number,
        postLike:Number,
    },
    data() {
        return {
            ping:0,
            thumbsUp:true,
        };
    },
    methods: {
        change() { //点赞功能实现
            if (this.thumbsUp) {
                const formData = new FormData()
                formData.append('postId', this.postId)
                
                const fullUrl = this.$myVariable + 'post/info/likeIs';
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
                this.thumbsUp = false
            } else {
                const formData = new FormData()
                formData.append('postId', this.postId)
                const fullUrl = this.$myVariable + 'post/info/noLikeIs';
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
                this.thumbsUp = true
            }

        },
        pinglun () {
            const formData = new FormData()
            formData.append('postId', this.postId)
            const fullUrl = this.$myVariable + 'comment/info/selectCommentInfo';
            this.$axios.post(fullUrl, formData,{
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then(response => {
                this.ping = response.data.object.length
            })
            .catch(error => {
                console.log(error);
            });
        },
        async tiaozhuan () {//异步函数
            await this.$cookie.set('postId', this.postId)
            this.$router.push({ name: 'post'});
        }
    },
    mounted() {
        this.pinglun();
    },
}
</script>
 
<style scoped></style>
<!--
                                    ...vr
                                    qBMBBBMBMY
                                   8BBBBOBMRMV
                                 iMBMM5vOY:BMBBv
               .r,               OEM;    .:  rBBBBBY
               vUL               7EB    . :7.  LBMMEBM
              .@Wwz.            :uvir   . i: .iLMOMOBM .
               vv::r               iY.   ...rv,@arqiao.
                Li.i:               v: . ::::7vOBBMBL..
                ,i7: vSUi，         :M7.:.,:u08OP.  .
                  .N2k5ulju7,. .    :BMGiiL7   ,i,i
                   :rL jFYjvjLY7r::.  ;v  vr... rE8q;,:,,
                  751jSLYPFu5uUoguohez ou., 1wjr2E8@rizero.
                  BB:FMi rM8EGOPF jF 15F70Mu1 5F25Luu25Gi
               ivSvvXL   :v58ZOG ZXF2UUkF SFkU1u125uUUUZ,
             :@kewensun.     ,iY20GOXSUMkSuS2F5XXrkUM5SEv.
         .:iOBMBMBBOOBMUi;,       ,:8PkFP5NkPXkFFPEqokKZu.
      .r qMqBBMOMMBMBBBM.           @kexiarli. S11kFSU5g5
    .7BBOi 1L 1MMSEBBOMBB..,        8kg552kkuPP1Uokk1kUEJ
    .;MBZ; iiMBMBMMOBEBu,           10kkS1F1X5kFP112F51kU
      .rPY   OMEMEBEMEB2,.          rME5SSSFkXPGFNk SUPZ,
              ::JuBML::r:.:.,,       SZPXOSKSP5kYGNP 15UBr
                  L,  :@sanshao.     : MNZqNXqSqqXk2EoPSXPE
              viLBx.,,v8Bj.i:r7:,    2ZkqgOXXSNNONOLSKO
            :r2. rMGMGi   . TY,li::i vOOPWNNSIEqPoSecbone
            .ilr. .ikY.     vE.   iY.. 20Fq0g55F 1S2F22uw1M
 -->        
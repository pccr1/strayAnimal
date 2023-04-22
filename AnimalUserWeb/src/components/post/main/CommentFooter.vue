<template>
    <div class="comment">
        <span>
            <el-link 
            type="primary" 
            href="#" 
            target="_blank" 
            style="font-weight:bold;font-size:13px;" 
            :underline="false">{{ reply1 }}</el-link>

            &nbsp;回复&nbsp;

            <el-link 
            href="#" 
            target="_blank" 
            style="font-weight:bold;font-size:13px;" 
            :underline="false" 
            disabled>{{ toReply1 }} :</el-link>

            <span @click.self="onTextClick">
                {{ Huifu.answerText }} &nbsp;
            </span>      
            <span style="color: #939393;font-size: 1px!important">{{ Huifu.strCreateTime }}</span>
        </span>
    </div>
</template>

<script>
    export default {
        name:'CommentFooter',
        props: {
            Huifu:Object,
        },
        data(){
            return{
                reply1:'',
                toReply1:'',
            }
        },
        methods: {
            reply () {//回复者
                const formData = new FormData()
                formData.append('userId', this.Huifu.answerUserId)
                this.$axios.post('http://localhost:9090/user/info/selectUser',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.reply1 = response.data.object.userNetWorkName
                })
                .catch(error => {
                    console.log(error);
                });
            },
            toReply () {//被回复者
                const formData = new FormData()
                formData.append('userId', this.Huifu.toBeAnswerUserId)
                this.$axios.post('http://localhost:9090/user/info/selectUser',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.toReply1 = response.data.object.userNetWorkName
                })
                .catch(error => {
                    console.log(error);
                });
            },
            onTextClick () {
                // 发送事件给事件总线实例
                this.$bus.$emit('textClicked1',this.reply1,this.Huifu);
            }
        },
        mounted() {
            this.reply();
            this.toReply();
        },
    }
</script>

<style>
    .comment {
        font-size:13px;
        margin-top: 7px;
        width: 280px;
        text-align: left;
        padding-left: 20px;
        padding-top: 1px;
    }
</style>
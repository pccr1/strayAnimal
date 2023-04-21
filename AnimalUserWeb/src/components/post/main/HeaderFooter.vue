<template>
    <!-- 正文 -->
    <div class="zhengwen">
        {{ postText }}
    </div>
</template>

<script lang="ts">
    export default {
        name:'HeaderFooter',
        props: {
            postId:Number,
            postText:String,
        },
        data(){
            return{
                
            }
        }
    }
</script>

<style>
    .zhengwen {
        font-size:14px;
        margin-top: 7px;
        width: 360px;
        text-align: left;
        padding-left: 20px;
        padding-top: 10px;
    }
</style>
<template>
    <el-container>
        <!-- 头部组件 -->
        <el-header>
            <PostHeader/>
        </el-header>

        <!-- 中间组件 -->
        <PostMain/>

        <!-- 底部组件 -->
        <PostFooter/>
    </el-container>
</template>

<script>
import PostHeader from '@/components/post/header/PostHeader.vue';
import PostMain from '@/components/post/main/PostMain.vue';
import PostFooter from '@/components/post/footer/PostFooter.vue';

    export default {
        name:'UserCommunity',
        components: {
            PostHeader,
            PostMain,
            PostFooter
        }
    }
</script>

<style scoped>
    .el-header,.el-footer {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-main {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        height: 680px;
    }

    .el-button {
        line-height: 10px;
    }
</style>
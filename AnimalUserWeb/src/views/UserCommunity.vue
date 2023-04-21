<template>
    <div>
        <!-- 头部组件 -->
        <el-header>
            <CommunityHeader/>
        </el-header>

        <!-- 中间组件 -->
        <CommunityMain/> 

        <!-- 底部组件
        <UserFooter/> -->
    </div>
</template>

<script>
import CommunityHeader from '@/components/community/header/CommunityHeader.vue';
import CommunityMain from '@/components/community/main/CommunityMain.vue';
// import UserFooter from '@/components/user/general/UserFooter.vue';

    export default {
        name:'UserCommunity',
        components: {
            // UserFooter,
            CommunityHeader,
            CommunityMain
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
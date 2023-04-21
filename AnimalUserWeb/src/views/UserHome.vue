<template>
  <el-container>
        <!-- 头部组件 -->
        <el-header>
            <HomeHeader/>
        </el-header>

        <!-- 中间组件 -->
        <HomeMain/> 

        <!-- 底部组件
        <UserFooter/> -->
    </el-container>
</template>

<script>
// import UserFooter from '../components/user/general/UserFooter.vue'
import HomeHeader from '@/components/home/header/HomeHeader.vue';
import HomeMain from '@/components/home/main/HomeMain';

    export default {
        name:'UserHome',
        components: {
            // UserFooter,
            HomeHeader,
            HomeMain
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
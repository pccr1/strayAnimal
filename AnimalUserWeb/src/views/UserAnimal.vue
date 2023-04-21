<template>
    <div>
        <!-- 头部组件 -->
        <el-header>
            <HomeHeader/>
        </el-header>

        <!-- 中间组件 -->
        <AnimalMain/> 

        <!-- 底部组件
        <UserFooter/> -->
    </div>
</template>

<script>
import HomeHeader from '@/components/home/header/HomeHeader.vue';
import AnimalMain from '@/components/animal/main/AnimalMain.vue';
// import UserFooter from '@/components/user/general/UserFooter.vue';

    export default {
        name:'UserAnimal',
        components: {
            // UserFooter,
            HomeHeader,
            AnimalMain
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
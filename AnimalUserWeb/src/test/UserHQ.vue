<template>
    <el-container>
        <!-- 头部组件 -->
        <el-header>
            <!-- <HomeHeader/> -->
            <!-- <CommunityHeader/> -->
            <PostHeader/>
        </el-header>

        <!-- 中间组件 -->
        <!-- <TestOne/> -->
        <!-- <HomeMain/>  -->
        <!-- <router-view/> -->
        <!-- <CommunityMain/> -->
        <PostMain/>

        <!-- 底部组件 -->
        <!-- <UserFooter/> -->
        <PostFooter/>
    </el-container>
</template>

<script>
import UserFooter from './general/UserFooter.vue';
import HomeHeader from './home/header/HomeHeader.vue';
import HomeMain from './home/main/HomeMain';
import TestOne from './TestOne.vue';
import CommunityHeader from './community/header/CommunityHeader';
import CommunityMain from './community/main/CommunityMain.vue';
import PostHeader from './post/header/PostHeader.vue';
import PostFooter from './post/footer/PostFooter.vue';
import PostMain from './post/main/PostMain.vue';


export default {
    name: "UserHQ",
    components: {
        UserFooter,
        TestOne,
        HomeHeader,
        HomeMain,
        CommunityHeader,
        CommunityMain,
        PostHeader,
        PostFooter,
        PostMain,
    }
}
</script>

<style scoped>
.el-footer,
.el-header {
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
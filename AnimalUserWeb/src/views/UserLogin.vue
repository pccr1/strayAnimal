<template>
    <div>
        <!-- 头部组件 -->
        <LoginHeader/>

        <!-- 中间组件 -->
        <LoginMain/>

        <!-- 底部组件 -->
        <LoginFooter/>
    </div>   
</template>

<script>
import LoginHeader from '@/components/login/header/LoginHeader.vue';
import LoginMain from '@/components/login/main/LoginMain.vue';
import LoginFooter from '@/components/login/footer/LoginFooter.vue';

    export default {
        name:'MeData',
        components: {
            LoginHeader,
            LoginMain,
            LoginFooter
        }
    }
</script>

<style scoped>

</style>
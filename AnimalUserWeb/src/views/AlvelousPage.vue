<template>
    <el-container>
        <!-- 头部组件 -->
        <el-header>
            <PageHeader/>
        </el-header>

        <PageMain/>

    </el-container>
</template>

<script>
import PageHeader from '@/components/animal/alvelous/page/header/PageHeader.vue';
import PageMain from '@/components/animal/alvelous/page/main/PageMain.vue';


    export default {
        name:'AlvelousPage',
        components: {
            PageHeader,
            PageMain
        }
        
    }
</script>

<style scoped>
    .el-header {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-button {
        line-height: 10px;
    }
</style>
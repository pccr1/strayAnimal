<template>
    <el-container>
        <el-header>
            <el-row class="main"> 
                <el-button size="mini" icon="el-icon-first-aid-kit" @click="$router.replace({name:'one'})" round>小动物</el-button>
                <el-button size="mini" icon="el-icon-chat-line-round" @click="$router.replace({name:'two'})" round>留言</el-button>
                <el-button size="mini" icon="el-icon-shopping-cart-2" @click="$router.replace({name:'three'})" round>商品</el-button>
            </el-row>
        </el-header>
            
        <el-main>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name:'PageMain',
    }
</script>

<style scoped>
    .el-header {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        height: 20px !important;
        /* line-height: 80px; */
    }
    .main {
        float: left;
    }
    .el-main{
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        height: 720px;
    }
</style>
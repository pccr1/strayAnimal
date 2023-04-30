<template>
    <el-container>
        <router-view/>

        <el-footer>
            <el-button 
            size="mini" 
            icon="el-icon-house" 
            @click="$router.push({name:'home'})" 
            round>首页</el-button>

            <el-button 
            size="mini" 
            icon="el-icon-monitor" 
            @click="$router.push({name:'community'})" 
            round>社区</el-button>

            <el-button 
            icon="el-icon-plus" 
            @click="$router.push({name:'add'})"
            circle></el-button>

            <el-button 
            size="mini" 
            icon="el-icon-first-aid-kit" 
            @click="$router.push({name:'animal'})" 
            round>动物</el-button>

            <el-button 
            size="mini" 
            icon="el-icon-mobile-phone" 
            @click="$router.push({name:'data'})" 
            round>我</el-button>  
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name:'UserFooter'
    }
</script>

<style scoped>
    .el-footer {
        width: 400px;
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
</style>
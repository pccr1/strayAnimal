<template>
    <el-header>
        <el-row>
            <el-button 
            icon="el-icon-arrow-left" 
            @click="$router.back()" 
            style="border: none"
            round></el-button>
        </el-row>
    </el-header>
</template>

<script>
    export default {
    name:"LoginHeader"
    }
</script>

<style scoped>
    .el-row {
    float: left;
    }
    .el-header {
    width: 400px;
    background-color: #ffffff;
    color: #333;
    text-align: center;
    line-height: 60px;
}

</style>
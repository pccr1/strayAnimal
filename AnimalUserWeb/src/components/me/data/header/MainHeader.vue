<template>
    <div style="width: 350px;float:left;height: 70px;margin-left: 10px;margin-top: 10px;margin:-20px 0">
        <!--头像-->
        <div style="float:left">
            <el-avatar :size="70" src="https://apic.douyucdn.cn/upload/avatar_v3/202209/d5b9d408f15f44129094fe2c8d51e7ee_big.jpg"></el-avatar>
        </div>
        <!--姓名-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" style="font-weight:bold;" :underline="false">一口三明治3Mz</el-link>
        </div>
        <!--称号-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" type="primary" style="font-size:13px" :underline="false">爱心达人</el-link>
        </div>
        <!--等级-->
        <div style="float:left;padding: 8px;">
            <el-tag effect="dark">Lv.8</el-tag>
        </div>
        <div style="margin:0 10px ;float:left">
            <span style="font-size: 1px;background: #d3d3d3;">这个人是烂狗，什么也没留下</span>
        </div>
    </div>
</template>

<script>


    export default {
        name: 'MainHeader',
        components: {

        }
}
</script>

<style scoped>
.el-tag {
    height: 20px;
    width: auto;
    line-height: 20px;
}
</style>
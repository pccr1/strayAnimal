<template>
    <div style="width: 350px;float:left;height: 70px;margin-left: 10px;margin-top: 10px;margin:-20px 0">
        <!--头像-->
        <div style="float:left">
            <el-avatar :size="70" :src="obj.userAvatar"></el-avatar>
        </div>
        <!--姓名-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" style="font-weight:bold;" :underline="false">{{ obj.userNetWorkName }}</el-link>
        </div>
        <!--称号-->
        <div style="float:left;padding: 8px;">
            <el-link href="#" target="_blank" type="primary" style="font-size:13px" :underline="false">{{ obj.userTitle }}</el-link>
        </div>
        <!--等级-->
        <div style="float:left;padding: 8px;">
            <el-tag effect="dark">Lv.{{ obj.userLevel }}</el-tag>
        </div>
        <div style="margin:0 -35px ;float:left">
            <span style="font-size: 1px;background: #d3d3d3;">这个人是烂狗，什么也没留下</span>
        </div>
    </div>
</template>

<script>


    export default {
        name: 'MainHeader',
        components: {

        },
        data() {
            return{
                obj:'',
            }
        },
        methods: {
            show() {
                const formData = new FormData()
                formData.append('userId', this.$cookie.get('userId'))
                const fullUrl = this.$myVariable + 'user/info/selectUser';
                this.$axios.post(fullUrl, formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.obj = response.data.object
                })
                .catch(error => {
                    console.log(error);
                });
            }
        },
        mounted() {
            if(this.$cookie.get('userId')){
                this.show();
            }else{
                this.$confirm('当前还未登录哦，是否前往登录?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    this.$router.push({name:'login'})
                }).catch(() => {
                    this.$message({
                    type: 'info',
                    message: '已取消'
                });   
                this.$router.back()    
                });
            }
        },
}
</script>

<style scoped>
.el-tag {
    height: 20px;
    width: auto;
    line-height: 20px;
}
</style>
<template>
    <div class="infinite-list-wrapper">
      <div class="login-form">
      <h2 style="float: left;">注册</h2>
      <br/><br/><br/><br/>
      <el-input placeholder="请输入您的手机号" v-model="username" required>
      </el-input><br/><br/><br/>
      <el-input placeholder="请输入密码" v-model="password" show-password required></el-input>
      <br/><br/>
      <el-button style="float: left;" @click="submit()">注册</el-button>
      <el-link style="margin: 15px 0;float: right;" @click="$router.replace({name:'login'})" type="info">登录</el-link>
      <br/><br/><br/>
      <div v-if="error" class="error">{{ error }}</div>
    </div>
    </div>
</template>

<script>

    export default {
        name:"RegisterFooter",
        components: {

        },
        data () {
        return {
            username: '',
            password: '',
            error: ''
        }
        },
        methods: {
        submit() {
            // 发送登录请求
            if(this.username === '' || this.password === ''){
                this.error = '用户名和密码不能为空'
            }else{
                const formData = new FormData()
                formData.append('userAccount', this.username)
                formData.append('userPassword', this.password)
                formData.append('userPhone', this.username)
                formData.append('userNetWorkName', '用户' + this.username)
                this.$axios.post('http://localhost:9090/user/info/addUser',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                if(response.data.object){
                    this.$message({
                    message: '注册成功',
                    type: 'success'
                    });
                    this.$router.push({
                        name:'login',
                        params:{
                            username:this.username,
                            password:this.password,
                        }})
                }
                this.error = response.data.message
                })
                .catch(error => {
                    console.log(error)
                });
            }
        },
        jiazai() {
            if(this.$route.params.username){
                this.username = this.$route.params.username
            }
            if(this.$route.params.password){
                this.password = this.$route.params.password
            }
        },
        },
        computed: {
        
        },
        mounted() {
            this.jiazai();
        },
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
.infinite-list-wrapper {
    width: 100%;
    background-color: #ffffff;
    color: #333;
    text-align: center;
    height: 680px;
}
.login-form {
width: 330px;
margin: auto auto;
padding: 20px;
background-color: #fff;
}

.login-form h2 {
margin-top: 0;
}

.login-form label {
display: block;
margin-top: 10px;
}

.login-form input[type="text"],
.login-form input[type="password"] {
width: 90%;
padding: 10px;
border: 1px solid #ccc;
border-radius: 3px;
}

.login-form button[type="submit"] {
display: block;
width: 100%;
margin-top: 20px;
padding: 10px;
background-color: #007bff;
color: #fff;
border: none;
border-radius: 3px;
}

.login-form button[type="submit"]:hover {
background-color: #0069d9;
cursor: pointer;
}

.login-form .error {
color: red;
margin-top: 10px;
}
</style>
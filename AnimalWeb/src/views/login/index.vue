<template>
    <div class="login-out-view">
        <form class="login-view" v-loading="loading">
            <div class="login-title">
                <div class="title">欢迎登录</div>
            </div>
            <div class="login-item">
                <div class="label">账号</div>
                <div class="content">
                    <input v-model="form.account" type="text" class="input" placeholder="请输入账号" />
                </div>
            </div>
            <div class="login-item">
                <div class="label">密码</div>
                <div class="content">
                    <input v-model="form.password" type="password" class="input" placeholder="请输入密码" />
                </div>
            </div>
            <div class="submit" @click="formSubmit">立即登录</div>
        </form>

        <div class="pic-cloud-out">
            <div class="pic-cloud">
                <img class="pic-cloud__child left" src="@/assets/public/login-cloud.png" />
                <img class="pic-cloud__child right" src="@/assets/public/login-cloud.png" />
            </div>
        </div>
    </div>
</template>

<script>
import {
  login,
  getUserInfo,
  logout
} from '@/api/login'

export default {
    name: "login",

    data() {
        return {
            //账号密码登录
            form: {
                account: "",
                password: ""
            },

            loading: false,
            userAccount:"",
            userPassword:""


        };
    },
    mounted() {

    },
    methods: {

        // 提交验证
        formSubmit() {
            if (this.loading) {
                return;
            }
            if (this.form.account == null || this.form.account === "") {
                this.$message({
                    message: "请输入账号！",
                    type: "warning"
                });
                return;
            }
            if (this.form.password == null || this.form.password === "") {
                this.$message({
                    message: "请输入密码！",
                    type: "warning"
                });
                return;
            }
            this.loading = true;
            let data = {
                ...this.form
            }
  
            this.$store.dispatch('login/login', data)
                .then((res) => {
                    
                    this.loading = false;
                    this.$router.push({ path: '/user-manage/index' })
                    this.loading = false
                })
                .catch((res) => {
                    this.loading = false
                    this.$message.error(res.message)
                })
        },

    },

};
</script>

<style scoped>
.login-out-view {
    width: 100%;
    height: 100%;
    position: relative;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #dfdede5e;
}



.login-view {
    z-index: 10;
    position: relative;
    -webkit-app-region: no-drag;
    background: #ffffff;
    width: 350px;
    height: 380px;
    border-radius: 10px;
    box-shadow: 0 0 10px #00000033;
    box-sizing: border-box;
    padding: 10px 20px;
    margin-bottom: 40px;
}

.login-view .login-title {
    width: 100%;
    margin: 30px auto;
    height: 2px;
    background: #303133;
    background-image: linear-gradient(to right, #ffffff, #232323, #ffffff);
    display: flex;
    justify-content: center;
}

.login-view .login-title .title {
    background: #ffffff;
    padding: 0 10px;
    position: relative;
    font-size: 20px;
    line-height: 1;
    height: 20px;
    color: #232323;
    font-weight: bold;
    top: -10px;
}

.login-view .login-item {
    margin-top: 10px;
    padding-top: 10px;
    border-bottom: 1px solid #efefef;
}

.login-view .login-item .label {
    color: #0176FF;
    font-size: 14px;
}

.login-view .login-item .content {
    display: flex;
    align-items: center;
}

.login-view .login-item .content .input {
    flex: 1;
    padding: 10px 0;
    border: none;
    outline: none;
    font-size: 16px;
}

.login-view .login-item .content .get-code {
    flex-shrink: 0;
    cursor: pointer;
    user-select: none;
    font-size: 12px;
}

.login-view .change-login {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
    font-size: 12px;
}

.login-view .change-login .item.left {
    color: #0176FF;
}

.login-view .change-login .item.right {
    color: #676767;
}

.login-view .change-login .item:hover {
    color: #5bb2fa;
    cursor: pointer;
}

.login-view .submit {
    margin-top: 55px;
    background: #0176FF;
    height: 40px;
    border-radius: 25px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #ffffff;
    font-size: 14px;
    line-height: 1;
    cursor: pointer;
}
</style>
<style lang="scss" scoped>
.pic-cloud-out {
    position: absolute;
    top: calc(50% - 270px);
    left: calc(50% - 250px);
}

.pic-cloud {
    position: relative;
    float: left;
    width: 500px;
    height: 100px;

    &__child {
        position: absolute;

        &.left {
            width: 80px;
            z-index: 8;
            animation: cloudLeft 6s infinite;
            animation-timing-function: linear;
        }

        &.right {
            width: 58px;
            z-index: 20;
            animation: cloudRight 7s infinite;
            animation-timing-function: linear;
        }

        @keyframes cloudLeft {
            0% {
                bottom: -20px;
                left: 30px;
            }

            50% {
                bottom: 0;
                left: 60px;
            }

            100% {
                bottom: -20px;
                left: 30px;
            }
        }

        @keyframes cloudRight {
            0% {
                top: 0;
                right: 30px;
            }

            50% {
                top: 40px;
                right: 65px;
            }

            100% {
                top: 0;
                right: 30px;
            }
        }
    }
}

</style>

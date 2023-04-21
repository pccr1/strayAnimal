<template>
    <el-container>
        <el-header>
            <el-row class="l">
                <el-button 
                v-show="zhanshi" 
                style="border: none" 
                circle>数据</el-button>

                <el-button 
                v-show="!zhanshi" 
                size="mini" 
                style="border: none" 
                @click="data"
                circle>数据</el-button>

                <el-button 
                v-show="!zhanshi" 
                style="border: none" 
                circle>动态</el-button>

                <el-button 
                v-show="zhanshi" 
                size="mini" 
                style="border: none" 
                @click="dynamic"
                circle>动态</el-button>
            </el-row>
            <el-row class="r">
                <el-button icon="el-icon-search" style="border: none" circle></el-button>
                <el-button icon="el-icon-message" style="border: none" circle></el-button>
            </el-row>
        </el-header>

        <el-main>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name:"MeHeader",
        data() {
            return{
                zhanshi:true,//展示页面
            }
        },
        methods: {
            data(){//切换data页面
                this.zhanshi = !this.zhanshi
                this.$router.replace({name:'data'})
            },
            dynamic(){//切换dynamic页面
                this.zhanshi = !this.zhanshi
                // this.$router.replace({name:'dynamic'})
            }
        }
    }
</script>

<style scoped>
    .r {
        float: right;
    }
    .l{
        float: left;
    }
    .el-header,.el-footer {
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
<template>
    <div>
    <!-- 标题 -->
        <div class="biaoti">
                {{ postHeadline }}
        </div>

        <!-- 头像栏位 -->
        <div class="touxiang">
            <CardHead :userAvatar="userAvatar" :userNetWorkName="userNetWorkName" :userTitle="userTitle" :userLevel="userLevel"/>

            <el-button 
            class="guanzhu"
            type="primary"
            size="mini" 
            v-show="!attention" 
            @click="attention=!attention" 
            circle>+ 关注</el-button>

            <el-button 
            class="guanzhu"
            type="warning"
            size="mini" 
            v-show="attention" 
            @click="attention=!attention" 
            circle>已关注</el-button>
        </div>
    </div>
</template>

<script lang="ts">
import CardHead from '@/components/cards/CardHead.vue';

    export default {
        name:'HeaderMain',
        props: {
            postId:Number,
            postHeadline:String,
            userAvatar:String,
            userNetWorkName:String,
            userTitle:String,
            userLevel:Number,
        },
        components: {
            CardHead,
        },
        data(){
            return{
                attention: false,//判断关注
                title:'DF决定优化3Mz',
            }
        }
    }
</script>

<style scoped>
    .guanzhu {
        margin-top: 15px;
        float: right;
        padding: 8px;
        position: relative;
        right: 10px;
    }
    .touxiang {
        height: 50px;
    }
    .biaoti {
        font-size:17px;
        font-weight: bold;
        text-align: left;
        padding-left: 20px;
        padding-top: 10px;
    }
</style>
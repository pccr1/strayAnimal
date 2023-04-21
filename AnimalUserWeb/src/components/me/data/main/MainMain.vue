<template>
    <div class="main">
        <div class="one">
            <MainCard :shuliang=guanzhu name="关注" />
        </div>
        <div class="one">
            <MainCard :shuliang=fensi name="粉丝" />
        </div>
        <div class="one">
            <MainCard :shuliang=huozan name="获赞" />
        </div>
         <div class="one">
            <MainCard :shuliang=shoucang name="收藏" />
        </div>
    </div>
</template>

<script>
import MainCard from './MainCard.vue';

    export default {
        name:'MainMain',
        components: {
            MainCard,
        },
        data() {
            return{
                guanzhu:16,
                fensi:3,
                huozan:144,
                shoucang:42,
            }
        }
    }
</script>

<style scoped>
    .main {
        width: 100%;
        padding:30px 0;
        box-sizing: border-box;
        clear: both;
        display: flex;
        flex-wrap: nowrap; /*禁止换行 */
        flex-wrap: wrap;
    }
    .one {
        margin:0 25px; /* 设置边距 */
    }
</style>
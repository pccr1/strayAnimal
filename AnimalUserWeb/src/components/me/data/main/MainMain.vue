<template>
    <div class="main">
        <div class="one">
            <MainCard :shuliang="obj.userConcern" name="关注" />
        </div>
        <div class="one">
            <MainCard :shuliang="obj.userFans" name="粉丝" />
        </div>
        <div class="one">
            <MainCard :shuliang="obj.userLike" name="获赞" />
        </div>
        <div class="one">
            <MainCard :shuliang=55 name="收藏" />
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
            this.show();
        },
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
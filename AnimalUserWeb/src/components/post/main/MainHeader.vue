<template>
    <div>
        <HeaderHeader :postId="Obj.postId"/>
        <HeaderMain :postId="Obj.postId" :postHeadline="Obj.postHeadline" :userAvatar="Obj.userAvatar" :userNetWorkName="Obj.userNetWorkName" :userTitle="Obj.userTitle" :userLevel="Number(Obj.userLevel)" />
        <HeaderFooter :postId="Obj.postId" :postText="Obj.postText" />
    </div>

</template>

<script>
import HeaderHeader from './HeaderHeader.vue';
import HeaderMain from './HeaderMain.vue';
import HeaderFooter from './HeaderFooter.vue';

    export default {
        name:'MainHeader',
        props:{
            Obj:Object,
        },
        components: {
            HeaderHeader,
            HeaderMain,
            HeaderFooter
        },
        data() {
            return{

            }
        }
    }
</script>

<style>

</style>
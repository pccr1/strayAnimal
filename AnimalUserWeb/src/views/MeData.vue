<template>
    <div>
        <MainHeader/>
        <MainMain/>
        <MainFooter/>
    </div>
</template>

<script>
import MainHeader from '@/components/me/data/header/MainHeader.vue';
import MainMain from '@/components/me/data/main/MainMain.vue';
import MainFooter from '@/components/me/data/footer/MainFooter.vue';

    export default {
        name:'MeData',
        components: {
            MainHeader,
            MainMain,
            MainFooter
        }
    }
</script>

<style scoped>

</style>
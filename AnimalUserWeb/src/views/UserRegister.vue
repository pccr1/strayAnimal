<template>
    <div>
        <RegisterHeader/>
        <RegisterMain/>
        <RegisterFooter/>
    </div>
</template>

<script>
import RegisterHeader from '@/components/register/header/RegisterHeader';
import RegisterMain from '@/components/register/main/RegisterMain';
import RegisterFooter from '@/components/register/footer/RegisterFooter';

    export default {
        name:'MeData',
        components: {
            RegisterHeader,
            RegisterMain,
            RegisterFooter
        }
    }
</script>

<style scoped>

</style>
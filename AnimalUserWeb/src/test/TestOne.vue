<template>
    <div class="test">
        <HomeCard />
    </div>
    
</template>

<script>
import HomeCard from '../cards/HomeCard.vue';
    export default {
        name:"TestOne",
        components:{
            HomeCard,
        }
       
    }
</script>

<style scoped>
    .test {
    width: 400px;
    background-color: #ffffff;
    color: #333;
    text-align: center;

    }

</style>
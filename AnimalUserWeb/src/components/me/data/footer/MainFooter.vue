<template>
  <ChatGPT :volunteer="{id:1,name:'戴JAVA',title:'菜逼',serviceTime:'01:01',serviceCount:1,avatar:im}"/>
</template>

<script>
import ChatGPT from './ChatGPT.vue';
import im from '@/assets/1.png'

    export default {
        name:'MainFooter',
        components: {
            ChatGPT,
        },
        data(){
            return{
                im:im
            }
        }
    }
</script>

<style>

</style>
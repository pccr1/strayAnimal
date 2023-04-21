<template>
  <el-row class="demo-avatar demo-basic">
        <div class="block">
            <el-avatar :size="60" :src="circleUrl"></el-avatar>
        </div>
        <div class="sub-title">{{ circle }}</div>
  </el-row>
</template>

<script>
    export default {
        name:'AnimalIcon',
        props:{
            circle:{
                type: String,
                require: true,
                default: '加载失败'
            },
            circleUrl:{
                require: true,
                default: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
            }
        }
    }
</script>

<style scoped>

</style>
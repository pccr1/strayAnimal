<template>
    <div class="card">
        <span style="font-size: 14px;">{{ shuliang }}</span><br>
        <span style="font-size: 12px;color: #c0c0c0;">{{ name }}</span>
    </div>
</template>

<script>
    export default {
        name:'MainCard',
        props:{
            shuliang:{//数量
                type: Number,
                require: true,
                default: 0
            },
            name:{
                type: String,
                require: true,
                default: '加载失败'
            },
        }
    }
</script>

<style scoped>
  .card {
    height: 40px;
    width: 30px;
  }
</style>
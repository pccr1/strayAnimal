<template>
  <div>
    <div>
        <span>志愿者ID：{{ ID }}</span>
    </div>
  </div>
</template>

<script>
    export default {
        name:'VoluntaryActivity',
        props: {
            ID:{
                type: Number,
                require: true,
                default: null
            },
            time:{//服务时长
                type: Number,
                require: true,
                default: 0
            },
            chenghao:{//称号
                type: String,
                require: true,
                default: '无'
            },
            cishu:{//服务次数
                type: Number,
                require: true,
                default: 0
            },
        }
    }
</script>

<style scoped>
  
</style>
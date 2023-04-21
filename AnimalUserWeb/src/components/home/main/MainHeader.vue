<template>
    <div class="block">
        <el-carousel trigger="click" height="150px">
            <el-carousel-item v-for="item in imgs" :key="item.key" >
                <el-image  :src="item.src" style=" height: 150px;" ></el-image>
            </el-carousel-item>
        </el-carousel>
    </div>

</template>

<script>
    import t1 from '@/assets/t1.png'
    import t2 from '@/assets/t2.png'
    import t3 from '@/assets/t3.png'
    import t4 from '@/assets/t4.png'

    export default {
        data(){
            return{
                imgs:[
                    {key:'1',src:t1},
                    {key:'2',src:t2},
                    {key:'3',src:t3},
                    {key:'4',src:t4},
                ]
            }
        }
    }
</script>

<style scoped>

</style>
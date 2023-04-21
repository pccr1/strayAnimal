<template>
    <div class="block">
        <el-carousel :autoplay="false" trigger="click" height="150px">
            <el-carousel-item v-for="obj in srcList" :key="obj.pictureid" >
                <el-image  
                :preview-src-list="currentUrl"
                :src="obj.pictureUrl" 
                style=" height: 150px;" ></el-image>
            </el-carousel-item>
        </el-carousel>
    </div>

</template>

<script>

    export default {
        name:'HeaderHeader',
        props:{
            postId:Number,
        },
        data() {
            return {
                srcList: [],//小图
                currentUrl: [],//大图
            }
        },
        methods: {
            picture () {
                const formData = new FormData()
                formData.append('postId', this.postId)
                this.$axios.post('http://localhost:9090/picture/info/selectPictureInfo',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(response => {
                    this.srcList = response.data.object
                    for (let i = 0; i < this.srcList.length; i++) {
                        this.currentUrl.push(this.srcList[i].pictureUrl);
                    }
                })
                .catch(error => {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.picture();
        },
    }
</script>

<style>

</style>
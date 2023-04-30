<template>
    <div style="float: left;clear: both;text-align: left;margin-left: 10px;margin-top: 10px;" >
        
        <!--标题-->
        <div style="font-size:17px;font-weight: bold;">
            {{ postHeadline }}
        </div>
        <!--内容-->
        <div style="font-size:14px;margin-top: 7px;width: 325px;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;overflow: hidden;">
            {{ postText }}
        </div>
        <!--图片-->
        <div style="margin-top: 7px;">

            <el-image 
            fit="cover"
            :src="obj.pictureUrl" 
            style="width: 100px;height: 100px;margin-right: 8px;" 
            v-for="obj in srcList"
            :key="obj.pictureid" 
            :preview-src-list="currentUrl" />

        </div>
 
    </div>
</template>

<script>
export default {
    name: 'CardMain',
    props: {
        postId:Number,
        postHeadline:String,
        postText:String,
    },
    components: {

    },
    data() {
        return {
            srcList: [],//小图
            currentUrl: [],//大图
        }
    },
    methods: {
        open(){
           // location.href = "https://www.baidu.com/s?ie=UTF-8&wd=vue%E7%82%B9%E5%87%BBdiv%E8%B7%B3%E8%BD%AC";
            this.$router.push('/CardFooter') 
        },
        picture () {
            const formData = new FormData()
            formData.append('postId', this.postId)
            const fullUrl = this.$myVariable + 'picture/info/selectPictureInfo';
            this.$axios.post(fullUrl, formData,{
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
        },
    },
    mounted() {
        this.picture();
    },
}
</script>

<style scoped>

</style>
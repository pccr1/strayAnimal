<template>
    <div class="mainHeader">
        <div class="icon">
            <AnimalIcon circle="小猫咪" circleUrl="http://rskkl6llr.hb-bkt.clouddn.com/src%3Dhttp___safe-img.xhscdn.com_bw1_79e15e89-a720-4a66-a901-225942d5d677_imageView2_2_w_1080_format_jpg%26refer%3Dhttp___safe-img.xhscdn.jpg"/>
        </div>
        <div class="icon">
            <AnimalIcon circle="小狗狗" circleUrl="http://rskkl6llr.hb-bkt.clouddn.com/u%3D1824238202%2C3166221617%26fm%3D253%26fmt%3Dauto%26app%3D138%26f%3DJPEG.jpg"/>
        </div>
        <div class="icon">
            <AnimalIcon circle="其他成员" circleUrl="http://rskkl6llr.hb-bkt.clouddn.com/u%3D3295481107%2C2923618313%26fm%3D253%26fmt%3Dauto%26app%3D138%26f%3DJPEG.jpg"/>
        </div>
        <div class="icon">
            <AnimalIcon circle="联系我们" circleUrl="http://rskkl6llr.hb-bkt.clouddn.com/d31b0ef41bd5ad6ec2717325d71e06dcb4fd3c54.jpeg"/>
        </div>
    </div>
</template>

<script>
import AnimalIcon from '../alvelous/AnimalIcon.vue';

    export default {
        name:'MainHeader',
        components: {
            AnimalIcon,
        },
    }
</script>

<style scoped>
    .mainHeader {
        display: flex;
        flex-wrap: nowrap; /*禁止换行 */
        flex-wrap: wrap;
        margin:0 10px; /* 设置边距 */
    }
    .icon {
        margin:15px 14px; /* 设置边距 */
    }
</style>
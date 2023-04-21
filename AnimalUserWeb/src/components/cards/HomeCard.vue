<template>
    <el-container>
        <el-main>
            <div style="height:100%;width:343px;background-color:#EBEEF5;margin: 0 auto;">
                <CardHead :userAvatar="Obj.userAvatar" :userNetWorkName="Obj.userNetWorkName" :userTitle="Obj.userTitle" :userLevel="Number(Obj.userLevel)" />
                <CardMain :postId="Obj.postId" :postHeadline="Obj.postHeadline" :postText="Obj.postText" />
                <CardFooter :postId="Obj.postId" :postLike="Number(Obj.postLike)" />
            </div>
        </el-main>
    </el-container>
</template>

<script>
import CardHead from './CardHead.vue';
import CardMain from './CardMain.vue';
import CardFooter from './CardFooter.vue';

export default {
    name: 'HomeCard',
    props:{
        Obj:Object,
    },
    components: {
        //MainHeader,
        //MainFooter
        CardHead,
        CardMain,
        CardFooter


    },
    methods: {
        shuchu () {
            console.log(this.Obj);
        }
    }
}
</script>



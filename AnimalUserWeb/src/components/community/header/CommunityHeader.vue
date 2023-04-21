<template>
    <el-row>
      <div class="left">
        <el-button size="mini" style="border: none" round>关注</el-button>
        <el-button size="mini" style="border: none" round>推荐</el-button>
        <el-button size="mini" style="border: none" round>热门</el-button>
      </div>
      <div class="right">
        <el-button icon="el-icon-search" style="border: none" circle></el-button>
        <el-button icon="el-icon-message" style="border: none" circle></el-button>
      </div>
    </el-row>
</template>

<script>
    export default {
        name:"CommunityHeader"
    }
</script>

<style scoped>
    .left {
        float: left;
    }
    .right {
        float: right;
    }
</style>
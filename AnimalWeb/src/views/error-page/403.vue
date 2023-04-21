<template>
  <div class="out-view">
    <div class="errPage-container">
      <el-row>
        <el-col :span="12">
          <h1 class="text-jumbo text-ginormous">
            Oops!
          </h1>
          <h2>你没有权限去该页面</h2>
          <h3>如有不满请联系你领导</h3>
        </el-col>
        <el-col :span="12">
          <img
            :src="errGif"
            width="313"
            height="428"
            alt="Girl has dropped her ice cream."
          >
        </el-col>
      </el-row>
    </div>
  </div>

</template>

<script>
import errGif from '@/assets/401_images/401.gif'

export default {
  name: 'Page401',
  data() {
    return {
      errGif: errGif + '?' + +new Date()
    }
  },
  created() {
    this.redirectUrl()
  },
  methods: {
    redirectUrl() {
      const nowHref = window.location.href
      const urlList = nowHref.split('#')
      const redirectUrl = urlList[0] + 'unauthorized.html'
      window.location.replace(redirectUrl)
    }
  }
}
</script>

<style lang="scss" scoped>
.out-view {
  width: 100%;
  height: 100%;
  background: #ffffff;
  display: flex;
  align-items: center;
  justify-content: center;
}
.errPage-container {
  width: 800px;
  max-width: 100%;
  .pan-back-btn {
    background: #008489;
    color: #fff;
    border: none !important;
  }
  .pan-gif {
    margin: 0 auto;
    display: block;
  }
  .pan-img {
    display: block;
    margin: 0 auto;
    width: 100%;
  }
  .text-jumbo {
    font-size: 60px;
    font-weight: 700;
    color: #484848;
  }
  h3 {
    margin-top: 20px;
    color: #898989;
  }
}
</style>

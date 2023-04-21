<template>
  <section class="app-main">
    <transition
      name="fade-transform"
      mode="out-in"
    >
      <keep-alive :include="cachedViews">
        <router-view :key="key" />
      </keep-alive>
    </transition>
  </section>
</template>

<script>
export default {
  name: 'AppMain',
  computed: {
    cachedViews() {
      return this.$store.state.tagsView.cachedViews
    },
    key() {
      return this.$route.path
    }
  }
}
</script>

<style lang="scss" scoped>
.app-main {
  height: calc(100vh - 45px);
  width: 100%;
  position: relative;
  overflow: hidden;
  border-top: #eaeaea;
  padding: 0 20px;
  .list-view-layout {
    position: absolute;
    top: 0;
    left: 20px;
    right: 20px;
    bottom: 0;
    width: calc(100% - 40px);
    display: flex;
    flex-direction: column;
    background: #ffffff;
  }

}

.fixed-header + .app-main {
  padding-top: 51px;
  .list-view-layout {
    position: absolute;
    top: 51px;
    left: 20px;
    right: 20px;
    bottom: 0;
    width: calc(100% - 40px);
    display: flex;
    flex-direction: column;
  }
}
</style>

<style lang="scss">
// fix css style bug in open el-dialog
.el-popup-parent--hidden {
  .fixed-header {
    padding-right: 15px;
  }
}
</style>

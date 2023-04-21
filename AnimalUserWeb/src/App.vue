<template>
  <div id="app">
    <!-- <HelloWorld/> -->
    <!-- <keep-alive> -->
      <keep-alive>
        <router-view v-if="$route.meta.keepAlive"/>   
      </keep-alive>

      <router-view v-if="!$route.meta.keepAlive"/>
    <!-- </keep-alive> -->
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld
  }
}
</script>

<style>
#app {
  height: 100%;
  width: 400px;
  left: 50%;
  top: 50%;
  text-align:center
}
</style>

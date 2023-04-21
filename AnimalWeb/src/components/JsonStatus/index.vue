<template>
  <div class="flex-cc">
    <div class="dot" :class="{ 'dot-green': status === 'success', 'dot-red': status === 'error', 'dot-orange':status === 'warning' , 'dot-gray':status === 'info' }"></div>
    <div>{{ text }}</div>
  </div>
</template>

<script>

export default {
  name: 'JsonStatus',
  props: {
    // 显示的文字
    text: {
      type: String,
      default: ''
    },
    // 传入的状态值为 success, error, warning，默认为 success
    status: {
      type: String,
      default: 'success'
    }
  },
  computed: {}
}
</script>

<style scoped>
.flex-cc {
  display: flex;
  justify-content: center;
  align-items: center;
}

.dot {
  border-radius: 50%;
  width: 8px;
  height: 8px;
  margin-right: 5px
}
.dot-green {
  background-color: #5ce916;
}
.dot-red {
  background-color: #f74141;
}
.dot-orange {
  background-color: #f5b759;
}
.dot-gray {
  background-color: #909399;
}
</style>

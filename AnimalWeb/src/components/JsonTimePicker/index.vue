<template>
  <div class="json-time-picker">
    <div @click="handleClick" class="input">
      <el-input style="width: 220px" :readonly="true" placeholder="请选择日期范围" v-model="showTimeStr"
      >
        <template slot="prefix">
          <el-date-picker
            ref="picker"
            style="z-index: -1;width: 0;height: 0;top: 20px;left:40px;position: relative;"
            v-model="value1"
            type="daterange"
            @change="handleChange"
            :value-format="valueFormat"
          >
          </el-date-picker>
        </template>
        <template slot="suffix">
          <div class="time-suffix">
            <i style="color: #2b2f3a;" class="el-icon-date" />
          </div>
        </template>
      </el-input>

    </div>
  </div>
</template>

<script>
export default {
  // 组件依赖ElementUI
  name: 'JsonTimePicker',
  props: {
    valueFormat: {
      type: String,
      default: 'yyyy-MM-dd'
    },
    value: {
      type: Array,
      default: []
    }
  },
  computed: {
    showTimeStr() {
      if (this.value1.length === 0) {
        return ''
      }
      return this.value1[0] + ' - ' + this.value1[1]
    }
  },
  watch: {
    value: {
      handler(val) {
        this.value1 = val
      },
      immediate: true
    }
  },
  data() {
    return {
      value1: '',
    }
  },
  methods: {
    handleClick() {
      this.$refs.picker.focus()
    },
    handleChange(value) {
      // 将选择的时间发送给父组件
      this.$emit('selectTime', value)
    }
  }
}
</script>

<style lang="scss" scoped>
.json-time-picker {

  .time-suffix {
    display: flex;
    height: 100%;
    align-items: center;
  }

}
</style>

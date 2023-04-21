<template>
  <div class="json-filter">
    <div class="json-filter__title">
      {{ title }}
    </div>
    <div class="json-filter__form">
      <slot name="form" />
    </div>
    <div class="json-filter__buttons">
      <slot name="buttons" />
    </div>
  </div>
</template>

<script>

export default {
  name: 'JsonFilter',
  props: {
    title: {
      type: String,
      default: ''
    },
  },
  data() {
    return {}
  },

}
</script>

<style scoped lang="scss">
.json-filter {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  padding: 20px 20px 0 20px;
  flex-shrink: 0;
  margin-bottom: 3px;
    &__title {
    flex-shrink: 0;
    font-size: 17px;
    font-style: normal;
    font-weight: 600;
    color: #343434;
    margin-right: 15px;
    padding-top: 5px;
  }

  &__form {
    flex: 1;
  }

  &__buttons {
    flex-shrink: 0;
  }
}
</style>

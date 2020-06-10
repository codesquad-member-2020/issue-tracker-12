<template>
  <div>
    <select v-model="selected">
      <option class="default-filter-title" disabled value=""
        >Filter Issues</option
      >
      <option>A</option>
      <option>B</option>
      <option>C</option>
    </select>
    <span>선택함: {{ selected }}</span>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected: '',
    };
  },
};
</script>

<style lang="scss" scoped>
.default-filter-title {
  color: red;
}
</style>

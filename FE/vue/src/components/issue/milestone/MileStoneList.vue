<template>
  <div v-if="this.$store.state.isOpenMilestone">
    open
  </div>
  <div v-else>
    close
  </div>
</template>

<script>
export default {
  updated() {
    // console.log(1);
  },
};
</script>

<style></style>

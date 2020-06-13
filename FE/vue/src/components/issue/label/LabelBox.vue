<template>
  <ListTopMenu>
    <div>{{ this.$store.state.labels.length }} labels</div>
    <div>sort</div>
  </ListTopMenu>
</template>

<script>
import { ListTopMenu } from '@/style/styled';

export default {
  components: {
    ListTopMenu,
  },
};
</script>

<style></style>

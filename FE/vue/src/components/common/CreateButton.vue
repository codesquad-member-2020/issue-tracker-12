<template>
  <CreateButton @click="createLabel">{{ btnTitle }}</CreateButton>
</template>

<script>
import { CreateButton } from '@/style/styled';

export default {
  props: ['btnTitle'],
  components: {
    CreateButton,
  },
  methods: {
    createLabel() {
      if (this.$route.path === '/labelList' && this.btnTitle === 'New Label') {
        this.$store.commit('visableCreateLabel');
      }
    },
  },
};
</script>

<style></style>

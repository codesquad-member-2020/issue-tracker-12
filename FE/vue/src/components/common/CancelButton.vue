<template>
  <CloseButton @click="clickHandler">{{ btnTitle }}</CloseButton>
</template>

<script>
import { CloseButton } from '@/style/styled';

export default {
  props: ['btnTitle'],
  components: {
    CloseButton,
  },
  methods: {
    clickHandler() {
      if (this.btnTitle === 'Close milestone') {
        this.$store.commit('closedMilestoneItem', this.$route.params.id);
        this.$router.push('/milestoneList');
      } else {
        this.$store.commit('reopenMilestoneItem', this.$route.params.id);
        this.$router.push('/milestoneList');
      }
    },
  },
};
</script>

<style></style>

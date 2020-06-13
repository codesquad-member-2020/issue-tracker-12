<template>
  <wrapper :label="isLabel">
    <img
      v-if="type == 'Labels'"
      src="../../assets/labels.svg"
      :class="{ active: isLabel }"
      class="logo"
      alt=""
    />
    <img
      v-if="type == 'Milestones'"
      src="../../assets/milestone.svg"
      :class="{ active: isLabel }"
      class="logo"
      alt=""
    />
    <Title>{{ type }}</Title>
  </wrapper>
</template>

<script>
import styled from 'vue-styled-components';
import { Wrapper, Title } from '@/style/styled';

export default {
  props: ['type'],
  data() {
    return {
      isLabel: false,
    };
  },
  created() {
    if (
      (this.$route.path === '/labelList' && this.type === 'Labels') ||
      (this.$route.path === '/milestoneList' && this.type === 'Milestones')
    )
      this.isLabel = !this.isLabel;
  },
  components: {
    Wrapper,
    Title,
  },
};
</script>

<style lang="scss" scoped>
.active {
  filter: invert(99%) sepia(3%) saturate(0%) hue-rotate(119deg) brightness(117%)
    contrast(100%);
}
.logo {
  vertical-align: text-bottom;
}
</style>

<template>
  <btn-wrapper>
    <RouterButton :type="labelType" @click.native="toLabelPage" />
    <RouterButton :type="milestoneType" @click.native="toMilestonePage" />
  </btn-wrapper>
</template>

<script>
import RouterButton from '@/components/common/RouterButton';
import { BtnWrapper } from '@/style/styled';

export default {
  data() {
    return {
      labelType: 'Labels',
      milestoneType: 'Milestones',
    };
  },
  components: {
    RouterButton,
    BtnWrapper,
  },
  methods: {
    toLabelPage() {
      this.$router.push('/labelList');
    },
    toMilestonePage() {
      this.$router.push('/milestoneList');
    },
  },
};
</script>

<style></style>

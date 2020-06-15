<template>
  <MilestoneListWrap v-if="this.$store.state.isOpenMilestone">
    <OpenMilestone></OpenMilestone>
  </MilestoneListWrap>
  <MilestoneListWrap v-else>
    close
  </MilestoneListWrap>
</template>

<script>
import OpenMilestone from '@/components/issue/milestone/OpenMilestone';
import { MilestoneListWrap } from '@/style/styled';

export default {
  updated() {
    // console.log(1);
  },
  components: {
    OpenMilestone,
    MilestoneListWrap,
  },
};
</script>

<style></style>

<template>
  <MilestoneListWrap v-if="this.$store.state.isOpenMilestone">
    <OpenMilestone></OpenMilestone>
  </MilestoneListWrap>
  <MilestoneListWrap v-else>
    <CloseMilestone></CloseMilestone>
  </MilestoneListWrap>
</template>

<script>
import OpenMilestone from '@/components/issue/milestone/OpenMilestone';
import CloseMilestone from '@/components/issue/milestone/CloseMilestone';
import { MilestoneListWrap } from '@/style/styled';

export default {
  components: {
    OpenMilestone,
    MilestoneListWrap,
    CloseMilestone,
  },
};
</script>

<style></style>

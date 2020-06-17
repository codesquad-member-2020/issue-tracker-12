<template>
  <fragment>
    <MilestoneItemWrap
      class="test"
      v-for="milestone in milestonesList.filter(item => !item.isOpen)"
      :key="milestone.id"
    >
      <Milestone :milestone="milestone" :state="true" />
    </MilestoneItemWrap>
  </fragment>
</template>

<script>
import { mapState } from 'vuex';
import Milestone from '@/components/issue/milestone/Milestone';
import { MilestoneItemWrap } from '@/style/styled';
export default {
  computed: {
    ...mapState(['milestonesList']),
  },
  components: {
    Milestone,
    MilestoneItemWrap,
  },
};
</script>

<style></style>

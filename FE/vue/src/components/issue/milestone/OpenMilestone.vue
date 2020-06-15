<template>
  <fragment>
    <MilestoneItemWrap
      class="test"
      v-for="milestone in openMilestoneList"
      :key="milestone.id"
    >
      <Milestone :milestone="milestone" :state="false" />
    </MilestoneItemWrap>
  </fragment>
</template>

<script>
import { mapState } from 'vuex';
import Milestone from '@/components/issue/milestone/Milestone';
import { MilestoneItemWrap } from '@/style/styled';
export default {
  data() {
    return {
      openMilestoneList: [],
    };
  },
  created() {
    this.openMilestoneList = this.milestonesList.filter(
      item => item.isOpen === true,
    );
  },
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

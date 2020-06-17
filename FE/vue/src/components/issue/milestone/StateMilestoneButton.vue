<template>
  <div class="test">
    <div
      v-if="type == 'open'"
      class="openContainer state-container"
      :class="{ selected: this.$store.state.isOpenMilestone }"
    >
      <img class="logo" src="../../../assets/milestone.svg" alt="" />
      <span>{{ this.$store.state.openMilestoneCount }} Open </span>
    </div>
    <div
      v-if="type == 'close'"
      class="closeContainer state-container"
      :class="{ selected: !this.$store.state.isOpenMilestone }"
    >
      <img class="logo" src="../../../assets/check.svg" alt="" />
      <span>{{ this.$store.state.closeMilestoneCount }} Closed</span>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  props: ['type'],
  created() {
    this.$store.state.openMilestoneCount = this.milestonesList.filter(
      item => item.isOpen,
    ).length;
    this.$store.state.closeMilestoneCount = this.milestonesList.filter(
      item => !item.isOpen,
    ).length;
  },
  updated() {
    this.$store.state.openMilestoneCount = this.milestonesList.filter(
      item => item.isOpen,
    ).length;
    this.$store.state.closeMilestoneCount = this.milestonesList.filter(
      item => !item.isOpen,
    ).length;
  },
  computed: {
    ...mapState(['milestonesList']),
  },
};
</script>

<style lang="scss" scoped>
.test {
  cursor: pointer;
}

.logo {
  vertical-align: text-bottom;
  margin-right: 10px;
}
.state-container {
  width: 90px;
}

.closeContainer {
  margin-left: 10px;
}

.selected {
  color: #24292e;
  font-weight: 600;
}
</style>

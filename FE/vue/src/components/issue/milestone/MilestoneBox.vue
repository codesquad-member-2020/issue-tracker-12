<template>
  <ListTopMenu>
    <BtnWrapper class="btnWrapper">
      <StateMilestoneButton :type="open" @click.native="openMilestone" />
      <StateMilestoneButton :type="close" @click.native="closeMilestone" />
    </BtnWrapper>
    <div>sort</div>
  </ListTopMenu>
</template>

<script>
import StateMilestoneButton from '@/components/issue/milestone/StateMilestoneButton';
import { ListTopMenu, BtnWrapper } from '@/style/styled';

export default {
  data() {
    return {
      open: 'open',
      close: 'close',
    };
  },
  components: {
    StateMilestoneButton,
    ListTopMenu,
    BtnWrapper,
  },
  methods: {
    openMilestone() {
      this.$store.commit('openMilestone');
    },
    closeMilestone() {
      this.$store.state.isOpenMilestone = false;
      this.$store.commit('closeMilestone');
    },
  },
};
</script>

<style lang="scss" scoped>
.btnWrapper {
  color: #586069;
  font-weight: 400;
}
</style>

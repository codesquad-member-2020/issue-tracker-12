<template>
  <ItemWrapper>
    <LeftContent class="left">
      <MilestoneTitle>{{ milestone.title }}</MilestoneTitle>
      <MilestoneDate>
        <img class="calendar-logo" src="../../../assets/calendar.svg" alt="" />
        <span>Due by {{ milestone.dueDate }}</span>
      </MilestoneDate>
      <MilestoneDescription>
        <p>{{ milestone.description }}</p>
      </MilestoneDescription>
    </LeftContent>
    <RightContent class="right">
      <div>
        <ProgressBar :complete="completeIssue">
          <span></span>
        </ProgressBar>
      </div>
      <Complete>
        <span>
          <span>{{ completeIssue }}%</span> complete
        </span>
        <span>
          <span>{{ isOpenCount }}</span> open
        </span>
        <span>
          <span>{{ isCloseCount }}</span> closed
        </span>
      </Complete>
      <Update>
        <span>Edit</span>
        <span>Close</span>
        <span>Delete</span>
      </Update>
    </RightContent>
  </ItemWrapper>
</template>

<script>
import {
  MilestoneTitle,
  MilestoneDate,
  MilestoneDescription,
  ItemWrapper,
  LeftContent,
  RightContent,
  Complete,
  Update,
  ProgressBar,
} from '@/style/styled';

export default {
  props: ['milestone'],
  computed: {
    completeIssue() {
      const arrMileStone = Array.from(this.milestone.linkIssues).length;
      return parseInt((this.isOpenCount / arrMileStone) * 100);
    },
    isOpenCount() {
      const arrMileStone = Array.from(this.milestone.linkIssues);
      const openCount = arrMileStone.filter(open => open.isOpen).length;
      return openCount;
    },
    isCloseCount() {
      const arrMileStone = Array.from(this.milestone.linkIssues);
      const closeCount = arrMileStone.filter(open => !open.isOpen).length;
      return closeCount;
    },
  },
  components: {
    MilestoneTitle,
    MilestoneDate,
    MilestoneDescription,
    ItemWrapper,
    LeftContent,
    RightContent,
    Complete,
    Update,
    ProgressBar,
  },
};
</script>

<style lang="scss" scoped>
.calendar-logo {
  margin-right: 5px;
  vertical-align: text-bottom;
}

.progress-bar {
  .progress {
  }
}
</style>

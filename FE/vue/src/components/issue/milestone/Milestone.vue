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
        <span @click="editMilestone">Edit</span>
        <span v-if="!state" :data-id="milestone.id" @click="closeMilestone">
          Close
        </span>
        <span v-else :data-id="milestone.id" @click="openMilestone">
          Reopen
        </span>
        <span :data-id="milestone.id" @click="deleteMilestone">Delete</span>
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
  props: ['milestone', 'state'],
  computed: {
    completeIssue() {
      const arrMileStone = Array.from(this.milestone.linkIssues).length;
      const completeRating = parseInt((this.isOpenCount / arrMileStone) * 100);
      if (!completeRating) return 0;
      return completeRating;
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
  methods: {
    editMilestone() {
      this.$router.push(`/createMilestone/${this.milestone.id}`);
    },
    closeMilestone({
      target: {
        dataset: { id },
      },
    }) {
      this.$store.commit('closedMilestoneItem', id);
    },
    openMilestone({
      target: {
        dataset: { id },
      },
    }) {
      this.$store.commit('reopenMilestoneItem', id);
    },
    deleteMilestone({
      target: {
        dataset: { id },
      },
    }) {
      var result = confirm('Are you sure?');
      if (result) return this.$store.commit('deleteMilestoneItem', id);
    },
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

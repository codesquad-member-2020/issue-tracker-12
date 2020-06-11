<template>
  <div class="lm-button-container">
    <LabelsButtonComponent>
      <span class="label-counter counter-container">
        {{ this.labelCount }}
      </span>
    </LabelsButtonComponent>
    <MileStoneButtonComponent>
      <span class="milestone-counter counter-container">
        {{ this.milestoneCount }}
      </span>
    </MileStoneButtonComponent>
  </div>
</template>

<script>
import LabelsButtonComponent from '@/components/issueList/LabelsButtonComponent';
import MileStoneButtonComponent from '@/components/issueList/MileStoneButtonComponent';
import { mapState } from 'vuex';

export default {
  computed: {
    ...mapState(['labelCount', 'milestoneCount']),
  },
  components: {
    LabelsButtonComponent,
    MileStoneButtonComponent,
  },
};
</script>

<style lang="scss" scoped>
.lm-button-container {
  display: inline;
}

.counter-container {
  padding: 4px 5px;
  font-size: 12px;
  font-weight: 600;
  line-height: 1;
  color: #586069;
  background-color: rgba(27, 31, 35, 0.08);
  border-radius: 20px;
}
</style>

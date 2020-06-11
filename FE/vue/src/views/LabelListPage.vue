<template>
  <div class="label-list-container">
    <div class="label-header-container">
      <LabelsButtonComponent :theme="baseStyles" />
      <MileStoneButtonComponent />
      <InputComponent />
    </div>
    <div>
      컨텐츠 영역
    </div>
  </div>
</template>

<script>
import LabelsButtonComponent from '@/components/issueList/LabelsButtonComponent';
import MileStoneButtonComponent from '@/components/issueList/MileStoneButtonComponent';
import InputComponent from '@/components/input/InputComponent';

export default {
  data() {
    return {
      baseStyles: {
        color: '#fff',
        backgroundColor: '#0366d6',
        borderColor: '#0366d6',
        float: 'left',
        padding: '6px 14px',
        fontWeight: '600',
        lineHeight: '20px',
      },
    };
  },
  components: {
    LabelsButtonComponent,
    MileStoneButtonComponent,
    InputComponent,
  },
};
</script>

<style lang="scss" scoped>
.label-list-container {
  float: left;
}

.label-header-container {
  display: flex;
}
</style>

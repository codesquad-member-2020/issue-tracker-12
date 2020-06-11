<template>
  <fragment>
    <div>
      <FilterComponent />
      <LabelsButtonComponent />
    </div>
  </fragment>
</template>

<script>
import FilterComponent from '@/components/issueList/FilterComponent';
import LabelsButtonComponent from '@/components/issueList/LabelsButtonComponent';

export default {
  components: {
    FilterComponent,
    LabelsButtonComponent,
  },
};
</script>

<style lang="scss" scoped></style>

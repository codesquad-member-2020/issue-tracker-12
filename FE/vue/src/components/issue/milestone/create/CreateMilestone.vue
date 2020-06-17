<template>
  <fragment>
    <CreateMilestoneHeader></CreateMilestoneHeader>
    <CreateMilestoneContent :propsData="milestoneData"></CreateMilestoneContent>
  </fragment>
</template>

<script>
import CreateMilestoneHeader from '@/components/issue/milestone/create/CreateMilestoneHeader';
import CreateMilestoneContent from '@/components/issue/milestone/create/CreateMilestoneContent';
export default {
  data() {
    return {
      milestoneData: [],
    };
  },
  created() {},
  components: {
    CreateMilestoneHeader,
    CreateMilestoneContent,
  },
};
</script>

<style></style>

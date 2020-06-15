<template>
  <fragment>
    <LabelListWrap>
      <InnerListWrap>
        <MilestoneBox></MilestoneBox>
        <MilestoneList></MilestoneList>
      </InnerListWrap>
    </LabelListWrap>
  </fragment>
</template>

<script>
import MilestoneBox from '@/components/issue/milestone/MilestoneBox';
import MilestoneList from '@/components/issue/milestone/MilestoneList';
import { LabelListWrap, InnerListWrap } from '@/style/styled';

export default {
  components: {
    LabelListWrap,
    InnerListWrap,
    MilestoneBox,
    MilestoneList,
  },
};
</script>

<style></style>

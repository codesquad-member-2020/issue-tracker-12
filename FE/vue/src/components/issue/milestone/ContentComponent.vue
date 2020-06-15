<template>
  <fragment>
    <LabelListWrap>
      <InnerListWrap>
        <MilestoneBox></MilestoneBox>
        <MileStoneList></MileStoneList>
      </InnerListWrap>
    </LabelListWrap>
  </fragment>
</template>

<script>
import MilestoneBox from '@/components/issue/milestone/MilestoneBox';
import MileStoneList from '@/components/issue/milestone/MileStoneList';
import { LabelListWrap, InnerListWrap } from '@/style/styled';

export default {
  components: {
    LabelListWrap,
    InnerListWrap,
    MilestoneBox,
    MileStoneList,
  },
};
</script>

<style></style>

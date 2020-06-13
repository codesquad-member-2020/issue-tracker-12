<template>
  <fragment>
    <div v-if="this.$store.state.isCreateLabel"></div>
    <CreateLabelWrap v-else>
      <CreateLabelInner>
        <previewCreateLabel :RandomHexColor="this.$store.state.previewStyle">{{
          this.$store.state.labelName
        }}</previewCreateLabel>
        <AddLabel :RandomHexColor="this.$store.state.previewStyle"></AddLabel>
      </CreateLabelInner>
    </CreateLabelWrap>
    <LabelListWrap>
      <InnerListWrap>
        <LabelBox></LabelBox>
        <div
          class="label-list"
          v-for="label in this.$store.state.labels"
          :key="label.id"
        >
          <Label :label="label"></Label>
        </div>
      </InnerListWrap>
    </LabelListWrap>
  </fragment>
</template>

<script>
import _ from '@/utils/utils';
import AddLabel from '@/components/issue/label/AddLabel';
import LabelBox from '@/components/issue/label/LabelBox';
import Label from '@/components/issue/label/Label';
import {
  CreateLabelWrap,
  CreateLabelInner,
  previewCreateLabel,
  LabelListWrap,
  InnerListWrap,
} from '@/style/styled';

export default {
  data() {
    return {
      RandomHexColor: '',
    };
  },
  components: {
    InnerListWrap,
    Label,
    AddLabel,
    CreateLabelWrap,
    CreateLabelInner,
    previewCreateLabel,
    LabelListWrap,
    LabelBox,
  },
  created() {
    this.$store.commit('setPreviewStyle');
  },
};
</script>

<style>
.label-list {
  width: 100%;
}
</style>

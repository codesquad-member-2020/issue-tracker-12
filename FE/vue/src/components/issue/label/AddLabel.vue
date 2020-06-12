<template>
  <LabelContentWrap>
    <LabelName>
      <LabelItemTitle>Label name</LabelItemTitle>
      <input
        @input="changeLabelName"
        type="text"
        placeholder="Label name"
        :value="labelName"
      />
    </LabelName>
    <LabelDesc>
      <LabelItemTitle>Description</LabelItemTitle>
      <input
        type="text"
        placeholder="Description (optional)"
        v-model="labelDescription"
      />
    </LabelDesc>
    <LabelColor>
      <LabelItemTitle>Color</LabelItemTitle>
      <ColorSelectTab>
        <RandomColorButton
          :background="RandomHexColor"
          @click="changePreviewStyle"
        >
          <img src="../../../assets/labelChange.svg" alt="" />
        </RandomColorButton>
        <input type="text" className="colorInput" v-model="hexColor" />
      </ColorSelectTab>
    </LabelColor>
    <LabelSetButtons>
      <SetButtons>
        <CancelButton @click="cancelCreateLabel">Cancel</CancelButton>
        <SaveButton
          :class="{ active: labelName.length > 0 }"
          :disabled="labelName.length < 1"
          @click="createLabel"
          >Create label</SaveButton
        >
      </SetButtons>
    </LabelSetButtons>
  </LabelContentWrap>
</template>

<script>
import {
  LabelContentWrap,
  LabelName,
  LabelDesc,
  LabelColor,
  RandomColorButton,
  LabelItemTitle,
  LabelSetButtons,
  SetButtons,
  CancelButton,
  SaveButton,
  ColorSelectTab,
} from '@/style/styled';
import _ from '@/utils/utils';

export default {
  props: ['RandomHexColor'],
  data() {
    return {
      labelName: '',
      hexColor: '',
      labelDescription: '',
    };
  },
  mounted() {
    this.hexColor = this.RandomHexColor.background;
  },
  updated() {
    this.hexColor = this.RandomHexColor.background;
  },
  components: {
    LabelContentWrap,
    LabelName,
    LabelDesc,
    LabelColor,
    RandomColorButton,
    LabelItemTitle,
    LabelSetButtons,
    SetButtons,
    CancelButton,
    SaveButton,
    ColorSelectTab,
  },
  methods: {
    changeLabelName({ target: { value } }) {
      this.labelName = value;
      this.$store.commit('changeLabelName', this.labelName);
    },
    changePreviewStyle() {
      this.$store.commit('setPreviewStyle');
    },
    cancelCreateLabel() {
      this.$store.commit('visableCreateLabel');
    },
    createLabel() {
      this.$store.commit('addToLabelList');
    },
  },
};
</script>

<style lang="scss" scoped>
.active {
  opacity: 1;
}
</style>

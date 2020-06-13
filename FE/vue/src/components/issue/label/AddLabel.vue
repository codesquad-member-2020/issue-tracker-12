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
      <LabelNameError v-if="searchSameName">
        Name has already been taken
      </LabelNameError>
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
          :class="{ active: labelName.length > 0 && !searchSameName }"
          :disabled="labelName.length < 1 || searchSameName"
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
  LabelNameError,
} from '@/style/styled';
import _ from '@/utils/utils';

export default {
  props: ['RandomHexColor'],
  data() {
    return {
      labelName: '',
      hexColor: '',
      labelDescription: '',
      isErrorLabelName: false,
    };
  },
  computed: {
    searchSameName() {
      if (
        this.$store.state.labels.filter(
          label => label.labelName === this.labelName,
        ).length > 0
      ) {
        return true;
      } else {
        return false;
      }
    },
  },
  mounted() {
    this.hexColor = this.RandomHexColor.backgroundColor;
  },
  updated() {
    this.hexColor = this.RandomHexColor.backgroundColor;
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
    LabelNameError,
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
      this.$store.commit('addToLabelList', {
        description: this.labelDescription,
        labelName: this.labelName,
      });
      this.labelName = '';
      this.labelDescription = '';
    },
  },
};
</script>

<style lang="scss" scoped>
.active {
  opacity: 1;
}
</style>

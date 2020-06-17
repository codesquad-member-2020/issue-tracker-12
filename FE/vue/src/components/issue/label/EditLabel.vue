<template>
  <LabelContentWrap>
    <LabelName>
      <LabelItemTitle>Label name</LabelItemTitle>
      <input
        @input="changeEditLabelName"
        type="text"
        placeholder="Label name"
        :value="editLabelName"
      />
      <!-- <LabelNameError v-if="searchSameName">
        Name has already been taken
      </LabelNameError> -->
    </LabelName>
    <LabelDesc>
      <LabelItemTitle>Description</LabelItemTitle>
      <input
        @input="changeEditLabelDescription"
        type="text"
        placeholder="Description (optional)"
        :value="editLabelDescription"
      />
    </LabelDesc>
    <LabelColor>
      <LabelItemTitle>Color</LabelItemTitle>
      <ColorSelectTab v-if="!isColorChange">
        <RandomColorButton
          :background="RandomHexColor"
          @click="changeEditStyle"
        >
          <img src="../../../assets/labelChange.svg" alt="" />
        </RandomColorButton>
        <input
          type="text"
          className="colorInput"
          :value="RandomHexColor.backgroundColor"
        />
      </ColorSelectTab>
      <ColorSelectTab v-else>
        <RandomColorButton :background="randomStyle" @click="changeEditStyle">
          <img src="../../../assets/labelChange.svg" alt="" />
        </RandomColorButton>
        <input
          type="text"
          className="colorInput"
          :value="randomStyle.backgroundColor"
        />
      </ColorSelectTab>
    </LabelColor>
    <LabelSetButtons>
      <SetButtons>
        <CancelButton @click="cancelEditLabel">Cancel</CancelButton>
        <!-- <SaveButton
          :class="{ active: labelName.length > 0 && !searchSameName }"
          :disabled="labelName.length < 1 || searchSameName"
          @click="createLabel"
          >Create label</SaveButton
        > -->
        <ChangeSaveLabel :data-id="RandomHexColor.id" @click="saveEditLabel"
          >Save changes</ChangeSaveLabel
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
  ChangeSaveLabel,
  ColorSelectTab,
  LabelNameError,
} from '@/style/styled';
import _ from '@/utils/utils';

export default {
  props: ['RandomHexColor'],
  data() {
    return {
      editLabelName: '',
      editLabelDescription: '',
      isColorChange: false,
      randomStyle: null,
      islabelChange: false,
    };
  },
  created() {
    this.editLabelName = this.RandomHexColor.labelName;
    this.editLabelDescription = this.RandomHexColor.description;
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
    ChangeSaveLabel,
    ColorSelectTab,
    // LabelNameError,
  },
  computed: {
    // searchSameName() {
    //   if (
    //     this.$store.state.labels.filter(
    //       label => label.labelName === this.RandomHexColor.labelName,
    //     ).length > 0
    //   ) {
    //     return true;
    //   } else {
    //     return false;
    //   }
    // },
  },
  methods: {
    changeEditLabelName({ target: { value } }) {
      this.editLabelName = value;
      this.$emit('changeLabelName', this.editLabelName);
    },
    changeEditLabelDescription({ target: { value } }) {
      this.editLabelDescription = value;
    },
    cancelEditLabel() {
      this.$emit('cancelEdit');
    },
    changeEditStyle() {
      this.isColorChange = true;
      this.randomStyle = this.cretaeRandomStyled();
      this.$emit('editRandomStyle', this.randomStyle);
    },
    cretaeRandomStyled() {
      const previewStyle = _.pipe(
        _.createRandomHexColor,
        _.hexToLuma,
        _.isWhiteColor,
      )();
      return previewStyle;
    },
    saveEditLabel({
      target: {
        dataset: { id },
      },
    }) {
      this.$emit('saveLabel');
      let labelInfo = {};

      if (this.randomStyle === null) {
        labelInfo = {
          id: parseInt(id),
          labelName: this.editLabelName,
          description: this.editLabelDescription,
          backgroundColor: this.RandomHexColor.backgroundColor,
          textColor: this.RandomHexColor.textColor,
        };
      } else {
        labelInfo = {
          id: parseInt(id),
          labelName: this.editLabelName,
          description: this.editLabelDescription,
          ...this.randomStyle,
        };
      }

      this.$store.commit('saveLabel', labelInfo);
    },
  },
};
</script>

<style lang="scss" scoped></style>

<template>
  <LabelItem>
    <Info v-if="!isEdit">
      <LabelTab>
        <LabelPreview :label="label">
          {{ label.labelName }}
        </LabelPreview>
      </LabelTab>
      <DescriptionTab>{{ label.description }}</DescriptionTab>
      <MutedLinkTab></MutedLinkTab>
      <ButtonTab>
        <Button :data-id="label.id" @click="editLabel">Edit</Button>
        <Button :data-id="label.id" @click="deleteLabel">Delete</Button>
      </ButtonTab>
    </Info>
    <EditInfo v-else>
      <EditLabelTab>
        <LabelPreview v-if="!isInputChange" :label="label">
          {{ label.labelName }}
        </LabelPreview>
        <LabelPreview v-else :label="randomStyle">
          {{ changePreviewLabelName }}
        </LabelPreview>
        <Button :data-id="label.id" @click="deleteLabel">Delete</Button>
      </EditLabelTab>
      <EditLabel
        :RandomHexColor="label"
        @changeLabelName="changePreview"
        @saveLabel="saveLabel"
        @editRandomStyle="createRandomStyle"
        @cancelEdit="cancelLabel"
      ></EditLabel>
    </EditInfo>
  </LabelItem>
</template>

<script>
import EditLabel from '@/components/issue/label/EditLabel';
import {
  LabelItem,
  LabelTab,
  Info,
  EditInfo,
  DescriptionTab,
  MutedLinkTab,
  ButtonTab,
  Button,
  LabelPreview,
  EditLabelTab,
} from '@/style/styled';

export default {
  props: ['label'],
  data() {
    return {
      isEdit: false,
      isInputChange: false,
      changePreviewLabelName: '',
      randomStyle: null,
    };
  },
  created() {
    this.randomStyle = this.label;
  },
  components: {
    EditLabel,
    LabelItem,
    LabelTab,
    LabelPreview,
    Info,
    EditInfo,
    DescriptionTab,
    MutedLinkTab,
    ButtonTab,
    Button,
    EditLabelTab,
  },
  methods: {
    editLabel() {
      this.isEdit = !this.isEdit;
    },
    deleteLabel({
      target: {
        dataset: { id },
      },
    }) {
      const result = confirm(
        'Are you sure? Deleting a label will remove it from all issues and pull requests.',
      );
      if (result == true) {
        this.$store.commit('deleteLabel', id);
      } else {
        return;
      }
    },
    changePreview(e) {
      this.isInputChange = true;
      if (e === '') return (this.changePreviewLabelName = 'Label Preview');
      this.changePreviewLabelName = e;
    },
    saveLabel() {
      this.isEdit = !this.isEdit;
    },
    cancelLabel() {
      this.isEdit = !this.isEdit;
      this.isInputChange = !this.isInputChange;
    },
    createRandomStyle(e) {
      this.randomStyle = e;
    },
  },
};
</script>

<style></style>

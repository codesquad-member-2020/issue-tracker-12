<template>
  <LabelItem>
    <Info>
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
  </LabelItem>
</template>

<script>
import {
  LabelItem,
  LabelTab,
  Info,
  DescriptionTab,
  MutedLinkTab,
  ButtonTab,
  Button,
  LabelPreview,
} from '@/style/styled';

export default {
  props: ['label'],
  components: {
    LabelItem,
    LabelTab,
    LabelPreview,
    Info,
    DescriptionTab,
    MutedLinkTab,
    ButtonTab,
    Button,
  },
  methods: {
    editLabel({
      target: {
        dataset: { id },
      },
    }) {
      console.log(id);
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
  },
};
</script>

<style></style>

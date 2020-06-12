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
        <Button>Edit</Button>
        <Button>Delete</Button>
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
};
</script>

<style></style>

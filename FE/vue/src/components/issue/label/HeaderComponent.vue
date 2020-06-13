<template>
  <LabelHedaer class="headerContainer">
    <RouterBox />
    <CreateButton :btnTitle="'New Label'"></CreateButton>
  </LabelHedaer>
</template>

<script>
import RouterBox from '@/components/common/RouterBox';
import CreateButton from '@/components/common/CreateButton';
import { LabelHedaer } from '@/style/styled';

export default {
  components: {
    RouterBox,
    CreateButton,
    LabelHedaer,
  },
};
</script>

<style lang="scss" scoped></style>

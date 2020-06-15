<template>
  <Hedaer class="headerContainer">
    <RouterBox />
    <CreateButton :btnTitle="'New Label'"></CreateButton>
  </Hedaer>
</template>

<script>
import RouterBox from '@/components/common/RouterBox';
import CreateButton from '@/components/common/CreateButton';
import { Hedaer } from '@/style/styled';

export default {
  components: {
    RouterBox,
    CreateButton,
    Hedaer,
  },
};
</script>

<style lang="scss" scoped></style>
